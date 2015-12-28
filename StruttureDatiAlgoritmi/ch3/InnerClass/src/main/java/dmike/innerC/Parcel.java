package dmike.innerC;

import sun.security.krb5.internal.crypto.Des;

/**
 * Created by andrea on 28/12/15.
 * @author dmike
 */
interface Destination{
    String readLabel();
}
class Wrapping{
    public Wrapping(int x){
        i = x;
    }
    public int value(){
        return i;
    }
    private int i;
}

public class Parcel {
    public Destination destination(String s){
        class PDestination implements Destination{
            public String readLabel(){
                return label;
            }
            private String label;
            private PDestination(String whereTo){
                label = whereTo;
            }
        }

        return new PDestination(s);
    }

    public static void main(String[] args){
        Parcel p = new Parcel();
        Destination d = p.destination("Method");
        System.out.println(d.readLabel());

        p.track();

        System.out.println(p.wrapping(10).value());

        Destination d2 = p.destinationAn("Anonymous Class");
        System.out.println(d2.readLabel());
    }

    public void track(){
        internalTracking(true);
    }

    public Wrapping wrapping(int x){
        return new Wrapping(x){
            public int value(){
                return super.value() * 47;
            }
        };
    }
    public Destination destinationAn(final String b){
        return new Destination() {
            @Override
            public String readLabel() {
                return label;
            }
            private String label = b;
        };
    }
    private void internalTracking( boolean b){
        if (b){
            class TrackingSlip{
                TrackingSlip(String s){
                    id = s;
                }
                String getSlip(){
                    return id;
                }
                private String id;
            }
            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
            System.out.println(s);
        }
    }

}
