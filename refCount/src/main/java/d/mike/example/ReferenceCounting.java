package d.mike.example;

/**
 * Created by dmike on 12/12/14.
 */

class Shared {
    private int refcount = 0;
    private static long count =0;
    private final long id =count++;

    public Shared (){
        System.out.println("Creating " + this);
    }
    public void addRef (){
        refcount++;
    }
    protected void dispose (){
        if(--refcount == 0)
            System.out.println("Disposing " + this);
    }
    @Override
    protected void finalize(){
        if(refcount!= 0)
            System.out.println("SOme referece are not detach");
    }
    @Override
    public String toString (){
        return "Shared " + id;
    }
}
class Composition {
    private Shared share;
    private static long count =0;
    private final long id =count++;
    Composition(Shared objShare){
        System.out.println("Creating " + this);
        share =objShare;
        share.addRef();
    }
    protected void dispose (){
        System.out.println("Disposing " + this);
        share.dispose();
    }
    @Override
    public String toString (){
        return "Composition " + id;
    }

}


public class ReferenceCounting {
    public static void main(String[] args){
        Shared shere = new Shared();
        Composition[] comp = {new Composition(shere),
        new Composition(shere),new Composition(shere),new Composition(shere),
        new Composition(shere),};
        for(Composition c: comp)
            c.dispose();
        System.gc();
    }

}
