package d.mike.javaprogramming;

abstract class empty{
    public abstract void showMe();
}

public class eseFour extends empty{
    public eseFour(){};
    public void showMe(){
        System.out.println("Inside eseFour");
    }
    public static void quickly(empty obj){
       //eseFour coU = (eseFour) obj;
       //coU.showMe();
       obj.showMe();
    }
    public static void main(String[] args){
        eseFour g = new eseFour();
        eseFour.quickly(g);
    }
}