#ifndef DOGHOUSE_H
#define DOGHOUSE_H
#include "Dog.h"

class DogHouse{
public:
    DogHouse(Dog* dog, const std::string& house):p(dog),houseName(house){
        std::cout<< "Created DogHouse: "<<*this<<std::endl;
    }
    DogHouse(const DogHouse& dh):p(dh.p),houseName("copy-constucted" + dh.houseName){
        p->attach();
        std::cout<<"DogHouse copyconstructor: "<<*this<<std::endl;
    }
    DogHouse& operator=(const DogHouse& dh){
        if(&dh != this){
            houseName = dh.houseName + "assigned";
            p->detach();
            p=dh.p;
            p->attach();
        }
        std::cout<< "DogHouse operator= :"<<*this<<std::endl;
        return *this;
    }
    ~DogHouse(){
        std::cout<< "DogHouse decostructor: "<<*this<<std::endl;
        p->detach();
    }
    void renameHouse(const std::string& newName){
        houseName =newName;
    }
    void unalias(){p =p->unalias();}
    void renameDog(const std::string& newName){
        unalias();
        p->rename(newName);
    }
    Dog* getDog(){
        unalias();
        return p;
    }
    friend std::ostream& operator<<(std::ostream& os, const DogHouse& dh){
        return os<<"["<<dh.houseName<<"] contains"<<*dh.p;
    }

private:
    Dog* p;
    std::string houseName;
};

#endif // DOGHOUSE_H
