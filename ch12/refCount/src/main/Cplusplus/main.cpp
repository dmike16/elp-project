#include"doghouse.h"
using namespace std;

int main(){
    DogHouse fidos(Dog::make("Fido"),"FidoHouse"),
            spots(Dog::make("Spot"),"SpotHouse");
    cout<<"Entering copy-constructor"<<endl;
    DogHouse bobs(fidos);
    cout<<"After copy-con.. bobs"<<endl;
    cout<<"fidos:"<<fidos<<endl;
    cout<<"spotd:"<<spots<<endl;
    cout<<"bobs:"<<bobs<<endl;
    cout<<"Entering assignemed"<<endl;
    spots=fidos;
    cout<<"After assignemed"<<endl;
    cout<<"spots:"<<spots<<endl;
    cout<<"Entering self assignemed"<<endl;
    bobs=bobs;
    cout<<"After self assignemed"<<endl;
    cout<<"bobs:"<<bobs<<endl;
    cout<<"Entering rename"<<endl;
    bobs.getDog()->rename("BOB");
    cout<<"After rename BOB"<<endl;

    return 0;
}
