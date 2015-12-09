package dm.ex.java;

/**
 * Created by dmike on 08/12/15.
 * @author dmike
 */
abstract class Base {
    Base(){
        print();
    }
    abstract void print();
}

class Second extends Base{
    @Override
    void print (){
        System.out.println(value);
    }
    private int value = 23;
}

public class AbstractExThree {
    public static void main (String[] args){
        Second obj = new Second();
        obj.print();
    }
}
