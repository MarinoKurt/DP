#include <stdio.h>
#include <malloc.h>

typedef char const *(*PTRFUN)(void);

struct Animal {
    char const *name;
    PTRFUN *function_table;
};

char const *dogGreet(void) {
    return "vau!";
}

char const *dogMenu(void) {
    return "kuhanu govedinu";
}

char const *catGreet(void) {
    return "mijau!";
}

char const *catMenu(void) {
    return "konzerviranu tunjevinu";
}

PTRFUN doggo[] = {dogGreet, dogMenu};
PTRFUN catty[] = {catGreet, catMenu};

void constructDog(struct Animal *a, char const *name) {
    a->name = name;
    a->function_table = doggo;
}

void constructCat(struct Animal *a, char const *name) {
    a->name = name;
    a->function_table = catty;
}

struct Animal *createCat(char const *name) {
    struct Animal *a = (struct Animal *) malloc(sizeof(struct Animal));
    constructCat(a, name);
    return a;
}

struct Animal *createDog(char const *name) {
    struct Animal *a = (struct Animal *) malloc(sizeof(struct Animal));
    constructDog(a, name);
    return a;
}

void animalPrintGreeting(struct Animal *animal) {
    printf("%s pozdravlja: %s\n", animal->name, animal->function_table[0]());
}

void animalPrintMenu(struct Animal *animal) {
    printf("%s voli %s\n", animal->name, animal->function_table[1]());
}

void testAnimals(void) {
    struct Animal *p1 = createDog("Hamlet");
    struct Animal *p2 = createCat("Ofelija");
    struct Animal *p3 = createDog("Polonije");
    struct Animal p4;
    constructDog(&p4, "Kiki"); //stack

    animalPrintGreeting(p1);
    animalPrintGreeting(p2);
    animalPrintGreeting(p3);
    animalPrintGreeting(&p4);

    animalPrintMenu(p1);
    animalPrintMenu(p2);
    animalPrintMenu(p3);
    animalPrintMenu(&p4);

    free(p1);
    free(p2);
    free(p3);
}

struct Animal **createNDoggosMal(int n) {
    struct Animal **doggos = (struct Animal **) malloc(n * sizeof(struct Animal));
    for (int i = 0; i < n; i++) {
        constructDog(&doggos[i], "Dog");
        printf("Created doggo");
    }
}

int main() {
    testAnimals();
}