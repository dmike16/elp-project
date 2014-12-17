#ifndef WIDGET_H
#define WIDGET_H
#include<fstream>
#include<new>
#include<vector>
extern std::ofstream trace;

    class Widget{
    public:
        Widget(){ trace << "*";}
        ~Widget(){ trace <<"~";}

        void* operator new(std::size_t sz) {
            trace << "Widget::new: "<< sz <<"bytes"<< std::endl;
            void *addr = ::new char[sz];
            address.push_back((Widget*)addr);
            return addr;
        }
        void operator delete(void* p){
            trace<<"Widget::delete"<<std::endl;
            if(getWidgetNumbers()){
                int i=0;
                for(;i<address.size() && p!=address.at(i);i++);
                if(i>getWidgetNumbers())
                    return;
                else{
                    address.erase(address.begin()+i);
                    ::delete p;
                }
            }
        }
        void* operator new[](std::size_t sz) {
            trace << "Widget::new[]: "<< sz <<"bytes"<< std::endl;
            void *addr = ::new char[sz];
            address.push_back((Widget*)addr);
            return addr;
        }
        void operator delete[](void* p){
            trace<<"Widget::delete[]"<<std::endl;
            if(getWidgetNumbers()){
                int i=0;
                for(;i<address.size() && p!=address.at(i);i++);
                if(i>getWidgetNumbers())
                    return;
                else{
                    address.erase(address.begin()+i);
                    ::delete[] p;
                }
            }
        }
        static std::size_t getWidgetNumbers(){
            return address.size();
        }

    private:
        static const int size=10;
        static std::vector<Widget*> address;
        int i[10];
    };

#endif // WIDGET_H
