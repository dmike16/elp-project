package dmike.innerC;

/**
 * Created by andrea on 29/12/15.
 * @author dmike
 */
interface withClass{
    void f();
    class Test {
        Test(){
            test = true;
        }
        boolean getTest(){
            return test;
        }
        private boolean  test = false;
    }
}
public class mainParcel implements withClass{
    @Override
    public void f() {
        Test tt = new Test();
        System.out.println(tt.getTest());
    }

    public static void main(String... args){
        withClass mm = new mainParcel();
        Contents c = Parcel.contents();
        Destination d = Parcel.destination("Help");


        System.out.println(c.value() + " " + d.readLabel());
        mm.f();
    }
}
