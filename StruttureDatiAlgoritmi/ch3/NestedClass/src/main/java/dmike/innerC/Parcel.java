package dmike.innerC;

/**
 * Created by andrea on 29/12/15.
 * @author dmike
 */
interface Contents {
    int value();
}
interface Destination{
    String readLabel();
}

public class Parcel {
    public static Destination destination (String s){
        return new ParcelDestination(s);
    }
    public static Contents contents(){
        return new ParcelContents();
    }
    private static class ParcelContents implements Contents {
        @Override
        public int value() {
            return i;
        }
        private int i = 11;
    }
    protected static class ParcelDestination implements Destination{
        @Override
        public String readLabel() {
            return label;
        }
        public static void f(){}
        static int x = 10;
        static class AnotheLevel{
            public static void f(){}
            static int x = 10;
        }
        private String label;
        private ParcelDestination(String whereTo){
            label = whereTo;
        }
    }
}
