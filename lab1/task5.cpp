#include <iostream>

typedef int (*PTRFUN)(void);

class B {
public:
    virtual int prva() = 0;

    virtual int druga() = 0;
};

class D : public B {
public:
    virtual int prva() { return 0; }

    virtual int druga() { return 42; }
};

void extract(B *pb) {
    PTRFUN a = **((PTRFUN **) pb);
    PTRFUN b = *(*((PTRFUN **) pb) + 1);
    int pr = a();
    int dr = b();
    std::cout << "prva: " << pr << " druga: " << dr << "\n";
}

int main() {
    D *pb = new D();
    extract(pb);
}