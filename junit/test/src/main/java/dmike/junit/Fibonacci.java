package dmike.junit;

/**
 * Created by dmike on 21/04/17.
 */
public class Fibonacci {
    public static int compute(int n){
        int r = 0;

        if(n <= 1){
            r = n;
        }else{
            r = compute(n-1) + compute(n-2);
        }

        return r;
    }
}
