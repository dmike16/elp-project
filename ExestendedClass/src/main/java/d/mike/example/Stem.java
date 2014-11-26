package d.mike.example;

/**
 * Created by dmike on 26/11/14.
 */
public class Stem extends Root{
    public Stem(){
        super();
        System.out.println("Stem Class");
    }
    public void dispose(){
        System.out.println("Dispose Stem");
        three.dispose();
        two.dispose();
        one.dispose();
        super.dispose();
    }
    public static void main(String[] args){
        Stem x=new Stem();

        try{
            System.out.println("Inside Try");
        } finally {
            x.dispose();
        }
    }
    private Component1 one = new Component1();
    private Component2 two = new Component2();
    private Component3 three = new Component3();
}

class Component1 {
    Component1(){
        System.out.println("Component1 Class");
    }
    void dispose(){
        System.out.println("Dispose Component 1");
    }
}

class Component2{
     Component2(){
        System.out.println("Component2 Class");
    }
    void dispose(){
        System.out.println("Dispose Component 2");
    }
}

class Component3{
    Component3(){
        System.out.println("Component3 Class");
    }
    void dispose(){
        System.out.println("Dispose Component 3");
    }
}

class Root {
     Root(){
        System.out.println("Root Class");
    }
    void dispose(){
        System.out.println("Dispose Root");
        three.dispose();
        two.dispose();
        one.dispose();
    }

    private Component1 one = new Component1();
    private Component2 two = new Component2();
    private Component3 three = new Component3();
}