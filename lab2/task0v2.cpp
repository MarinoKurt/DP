#include <iostream>
#include <assert.h>
#include <stdlib.h>

struct Point {
    int x;
    int y;
};

struct Shape {
    virtual void draw() = 0;
    virtual void move(int dx, int dy) = 0;
    enum EType {
        circle, square, rhomb
    };
    EType type_;
};

class Circle {
public:
    virtual void draw() {
        std::cerr << "in drawCircle\n";
    }

    virtual void move(int dx, int dy){
        std::cerr << "in moveCircle\n";
        center_.x+=dx;
        center_.y+=dy;
    }
    Shape::EType type_;
    double radius_;
    Point center_;
};

class Square {
public:
    virtual void draw() {
        std::cerr << "in drawSquare\n";
    }

    virtual void move(int dx, int dy){
        std::cerr << "in moveSquare\n";
        center_.x+=dx;
        center_.y=dy;
    }
    Shape::EType type_;
    double side_;
    Point center_;
};

class Rhomb {
public:
    virtual void draw() {
        std::cerr << "in drawRhomb\n";
    }

    virtual void move(int dx, int dy){
        std::cerr << "in moveRhomb\n";
        center_.x+=dx;
        center_.y+=dy;
    }
    Shape::EType type_;
    double side_;
    Point center_;
    int angle;
};

void drawShapes(Shape **shapes, int n) {
    for (int i = 0; i < n; ++i) {
        struct Shape *s = shapes[i];
        s->draw();
    }
}

void moveShapes(Shape **shapes, int n, int dx, int dy) {
    for (int i = 0; i < n; ++i) {
        struct Shape *s = shapes[i];
        s->move(dx,dy);
    }
}

int main() {
    Shape *shapes[4];
    shapes[0] = (Shape *) new Circle;
    shapes[0]->type_ = Shape::circle;
    shapes[1] = (Shape *) new Square;
    shapes[1]->type_ = Shape::square;
    shapes[2] = (Shape *) new Square;
    shapes[2]->type_ = Shape::square;
    shapes[3] = (Shape *) new Circle;
    shapes[3]->type_ = Shape::circle;
    shapes[4] = (Shape *) new Rhomb;
    shapes[4]->type_ = Shape::rhomb;

    drawShapes(shapes, 5);
    moveShapes(shapes, 5, 5, 5);
}