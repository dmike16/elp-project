package ex.dmike.algostructure;

/**
 * Created by dmike on 22/10/15.
 * @author dmike
 */
public class KeySearch {
    public int sequenzial(int k){
        boolean find = false;
        int index = -1;
        status = "Key not found";
        for (int i = 0, n = sequ.length; i < n && (!find); i++){
            if (sequ[i] == k){
                find = true;
                index = i;
                status = "Key "+ k + " find at index " + i;
            }
        }
        return index;
    }
    public int binary(int k){
        boolean find = false;
        int index = -1;
        int left = 0;
        int right = sequ.length -1;
        int center;

        status = "Key not found";
        while((!find) && (left <= right)){
            center = (left + right)/2;
            if(k < sequ[center]){
                right = center -1;
            } else if (k > sequ[center]){
                left = center + 1;
            } else{
                index = center;
                find = true;
                status = "Key "+ k + " find at index " + index;
            }
        }
        return index;
    }
    @Override
    public String toString(){
        return status;
    }
    public KeySearch(int[] a){
        sequ = a;
    }
    private int[] sequ;
    private String status = "Not Searched";
}
