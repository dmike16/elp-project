package dmike.innerC;

/**
 * Created by andrea on 28/12/15.
 * @author dmike
 */

interface Selector {
    boolean end();
    Object current();
    void next();
}

public class Sequence {
    public static void main(String[] args){
        Sequence seq = new Sequence(10);

        for (int i = 0; i < 10; i++){
            seq.add(Integer.toString(i));
        }

        Selector sel = seq.selector();

        while(!sel.end()){
            System.out.print(sel.current() + " ");
            sel.next();
        }
        Sequence.SequenceSelector d = seq.new SequenceSelector();
        System.out.println(d.outside().next);

    }
    public Sequence(int size){
        items = new Object[size];
    }
    public void add(Object x){
        if (next < items.length) {
            items[next++] = x;
        }
    }
    public Selector selector(){
        return new SequenceSelector();
    }
    private Object[] items;
    private int next = 0;
    private class SequenceSelector implements Selector{
        public boolean end(){
            return i == items.length;
        }
        public Object current(){
            return items[i];
        }
        public void next(){
            if (i < items.length){
                i++;
            }
        }
        public Sequence outside(){
            return Sequence.this;
        }
        private int i = 0;
    }
}
