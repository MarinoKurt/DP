#include <stdio.h>
#include <stdlib.h>

typedef enum { false, true } bool;

typedef double (*PTRFUN)();

struct Unary_Function{
    PTRFUN* func;
    int lower_bound;
    int upper_bound;
};

struct Square{
    struct Unary_Function suf;
};

struct Linear{
    struct Unary_Function luf;
    double a;
    double b;
};

double sq_value_at(double x);
double lin_value_at(double x, struct Linear *self);
double negative_value_at(double x, struct Unary_Function *self);
void tabulate(struct Unary_Function *self);
bool same_functions_for_ints(struct Unary_Function *f1, struct Unary_Function *f2, double tolerance);

PTRFUN uf_func[] = {NULL, negative_value_at};
PTRFUN s_func[] = {sq_value_at, negative_value_at};
PTRFUN l_func[] = {lin_value_at, negative_value_at};

struct Linear* create_Linear(int lb, int ub, double a_coef, double b_coef){
    struct Linear *l = (struct Linear*)malloc(sizeof(struct Linear));
    l->a = a_coef;
    l->b = b_coef;
    l->luf.lower_bound = lb;
    l->luf.upper_bound = ub;
    l->luf.func = l_func;
    return l;
}

struct Square* create_Square(int lb, int ub){
    struct Square *s = (struct Square*)malloc(sizeof(struct Square));
    s->suf.lower_bound = lb;
    s->suf.upper_bound = ub;
    s->suf.func = s_func;
    return s;
}

struct Unary_Function* create_Unary_Function(int lb, int ub){
    struct Unary_Function *uf = (struct Unary_Function*)malloc(sizeof(struct Unary_Function));
    uf->lower_bound = lb;
    uf->upper_bound = ub;
    uf->func = uf_func;
    return uf;
}

int main(){
    struct Unary_Function *f1 = (struct Unary_Function*) create_Square(-2,2);
    tabulate(f1);
    struct Unary_Function *f2 = (struct Unary_Function*) create_Linear(-2, 2, 5, -2);
    tabulate(f2);
    printf("f1==f2: %s\n", same_functions_for_ints(f1, f2, 1E-6) ? "DA" : "NE");
    printf("neg_val f2(1) = %lf\n", f2->func[1](1.0, f2));
    free(f1);
    free(f2);
    return 0;
}

double sq_value_at(double x){
    return x*x;
}

double lin_value_at(double x, struct Linear *self){
    return self->a*x + self->b;
}

double negative_value_at(double x, struct Unary_Function *self){
    return -self->func[0](x, self);
}

void tabulate(struct Unary_Function *self){
    for(int x = self->lower_bound; x <= self->upper_bound; x++) {
        printf("f(%d)=%lf\n", x, self->func[0]((double)(x), self));
    }
}

bool same_functions_for_ints(struct Unary_Function *f1, struct Unary_Function *f2, double tolerance){
    if(f1->lower_bound != f2->lower_bound) return false;
    if(f1->upper_bound != f2->upper_bound) return false;
    for(int x = f1->lower_bound; x <= f1->upper_bound; x++) {
        double delta = f1->func[0](x, f1) - f2->func[0](x, f2);
        if(delta < 0) delta = -delta;
        if(delta > tolerance) return false;
    }
    return true;
}