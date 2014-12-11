#ifndef DOG_H
#define DOG_H

#include <iostream>
#include <string>

class Dog {
public:
    static Dog* make(const std::string& name) {
        return new Dog(name);
    }
    Dog(const Dog& d):nm(d.nm + "copy"),refcount(1){
        std::cout<<"Dog copy-constructor: "<<*this<<std::endl;
    }
    ~Dog(){
        std::cout<< "Deleting Dog: "<< *this<<std::endl;
    }
    void attach(){
        ++refcount;
        std::cout<< "Attached Dog "<< *this<<std::endl;
    }
    void detach(){
        //need a control over refcount != 0
        std::cout<<"Detaching Dog: "<< *this<<std::endl;
        if(--refcount == 0) delete this;
    }
    Dog* unalias () {
        std::cout<< "Unaliasing Dog: "<<*this<<std::endl;
        if(refcount == 1) return this;
        --refcount;
        return new Dog(*this);
    }
    void rename(const std::string& newName){
        nm =newName;
        std::cout<< "Dog renamed: "<<*this<<std::endl;
    }
    friend std::ostream& operator<<(std::ostream& os, const Dog& d){
        return os<<"["<<d.nm<<"], rc= "<<d.refcount;
    }
private:
    std::string nm;
    int refcount;
    Dog(const std::string& name):nm(name), refcount(1){
        std::cout<<"Creating Dog: "<< *this << std::endl;
    }
    Dog& operator=(const Dog& rv);
};

#endif // DOG_H
