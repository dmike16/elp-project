/*
 * =====================================================================================
 *
 *       Filename:  car.cpp
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  18/01/2015 19:42:05
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Michele Cipolla (), cipmiky@gmail.com
 *   Organization:  ddm
 *
 * =====================================================================================
 */

class Engine {
    public:
        void start() const {}
        void rev() const {}
        void stop() const {}
};

class Wheel {
    public:
        void inflate(int psi) const {}
};

class Window {
    public:
        void rollup() const {}
        void rolldown() const {}
};

class Door{
    public:
        Window window;
        void open() const {}
        void close() const {}
};

class Car{
    public:
        Engine engine;
        Wheel wheel[4];
        Door left,right;
};

int main() {
    Car car;
    car.left.window.rollup();
    car.wheel[0].inflate(72);
}
