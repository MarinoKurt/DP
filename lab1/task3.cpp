#include <iostream>

class CoolClass {
        public:
        virtual void set(int x) { x_ = x; };

        virtual int get() { return x_; };
        private:
        int x_;
};

class PlainOldClass {
        public:
        void set(int x) { x_ = x; };

        int get() { return x_; };
        private:
        int x_;
};

int main() {
    std::cout << sizeof(CoolClass) << "\n";
    std::cout << sizeof(PlainOldClass) << "\n";
}