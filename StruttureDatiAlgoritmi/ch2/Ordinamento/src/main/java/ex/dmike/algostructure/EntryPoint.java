package ex.dmike.algostructure;

/**
 * Created by dmike on 17/10/15.
 * @author dmike
 */
public class EntryPoint {
    static public void main(String[] args){
        int[] a = {44, 35, 23, 13 ,6 , 3};
        int[] b = {44, 35, 23, 13 ,6 ,3};

        Sort.printArray(Sort.selection(a), Sort.stepSel);
        Sort.printArray(Sort.insection(b),Sort.stepIns);
    }
}
