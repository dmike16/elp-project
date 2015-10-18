package ex.dmike.algostructure;

import java.util.Arrays;
/**
 * Created by dmike on 17/10/15.
 * @author dmike
 * @version 0.1
 */
class Sort {
    static int stepSel = 0;
    static int stepIns = 0;

    static int[] selection(int[] a){
        int min = 0, minIndex = 0;
        int j = 0;
        stepSel = 0;

        for (int i = 0, n = a.length; i < n; i++, stepSel++){
            min = a[i];
            minIndex = i;
            for (j = i+1; j < n; j++, stepSel++){
                if (a[j] < min){
                    min = a[j];
                    minIndex = j;
                }
            }
            a[minIndex]  = a[i];
            a[i] = min;
        }

        return a;
    }
    static int[] insection(int[] a){

        int next = 0;
        int j = 0;
        stepIns = 0;

        for (int i = 0,n = a.length; i < n; i++){
            next = a[i];
            j = i;
            stepIns++;
            while((j > 0) && (a[j-1] > next)){
                a[j] = a[j-1];
                j = j-1;
                stepIns = stepIns + 2;
            }
            a[j] = next;
        }
        return a;
    }
    static void printArray(int[] a, int step){
        System.out.println(Arrays.toString(a) + " Step: " + step);
    }
}
