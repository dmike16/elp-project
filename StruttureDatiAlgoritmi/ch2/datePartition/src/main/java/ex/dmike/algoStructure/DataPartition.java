package ex.dmike.algoStructure;

/**
 * Created by dmike on 24/11/15
 * @author dmike .
 */
public class DataPartition {
    public static boolean Partition(int[] a, int s) {
        int len = a.length;
        boolean[][] part = new boolean[len + 1][s + 1];

        part[0][0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= s; j++) {
                if (part[i - 1][j]) {
                    part[i][j] = true;
                } else if (j >= a[i - 1] && part[i - 1][j - a[i - 1]]) {
                    part[i][j] = true;
                }
            }
        }

        return part[len][s];
    }

    public static int Knapsack (int[] weight, int[] value, int puissance){
        int n = weight.length;
        int[][] V = new int[n + 1][puissance +1];

        for(int i = 1; i <= n; i++){
            for (int j = 0; j <= puissance; j++){
                V[i][j] = V[i-1][j];
                if (j >= weight[i-1]){
                    int m = V[i-1][j-weight[i-1]] + value[i-1];
                    if (m > V[i][j]){
                        V[i][j] = m;
                    }
                }
            }
        }

        return V[n][puissance];
    }

    public static void main(String[] args){
        int[] A ={9,7,5};
        int ss = 0;
        for (int x: A){
            ss += x;
        }
        System.out.println("Total Sum of A: " + ss);
        System.out.println("SubSet With Sum " + ss/2 + ": " + DataPartition.Partition(A,ss/2));

        int[] v = {3,1,4};
        System.out.println("Max Value: " + DataPartition.Knapsack(v,A,5) + " with poss: " + 5);
    }
}
