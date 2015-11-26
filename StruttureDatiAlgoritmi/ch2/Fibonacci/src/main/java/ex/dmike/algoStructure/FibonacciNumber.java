package ex.dmike.algoStructure;

/**
 * Created by dmike on 25/11/15.
 * @author dmike
 */
class Fibonacci{
    Fibonacci(){}
    long Fn (int n){ return  0;}
}

class Fibonacci1 extends Fibonacci {
    @Override
    long Fn (int n){

        double phi = 1.618;
        double phi_tilde = -0.618;

        return  Math.round((1/Math.sqrt(5))*(Math.pow(phi,n)- Math.pow(phi_tilde,n)));
    }

    @Override
    public String toString(){
        return "Fibonacci1";
    }
}

class Fibonacci2 extends Fibonacci{
    @Override
    long Fn(int n) {
        if (n <=2){
            if ( n == 0){
                return 0;
            } else {
                return 1;
            }
        } else {
            return Fn(n-1) + Fn(n-2);
        }
    }

    @Override
    public String toString(){
        return "Fibonacci2";
    }
}

class Fibonacci3 extends Fibonacci{
    @Override
    long Fn(int n) {
        long[] fib = new long[n+1];
        fib[1] = 1;

        for(int i = 2; i <= n; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }

    @Override
    public String toString(){
        return "Fibonacci3";
    }
}

class Fibonacci4 extends Fibonacci{
    @Override
    long Fn(int n) {
        long a = 0;
        long c;
        long b = 1;

        if ( n == 0){
            return a;
        }

        for(int i=2; i<=n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    @Override
    public String toString(){
        return "Fibonacci4";
    }
}

class Fibonacci5 extends Fibonacci{
    @Override
    long Fn(int n) {
        long[][] M = {{1,0},{0,1}};

        if (n == 0)return 0;

        for(int i = 1; i<n; i++){
            M = matrixProduct(M,Q);
        }
        return M[0][0];
    }

    @Override
    public String toString(){
        return "Fibonacci5";
    }
     static long[][] matrixProduct(long[][] M, long[][] A){
        long tmpOne = M[0][0]*A[0][0] + M[0][1]*A[1][0];
        long tmpTwo = M[0][0]*A[0][1] + M[0][1]*A[1][1];
        long tmpThree = M[1][0]*A[0][0] + M[1][1]*A[1][0];
        long tmpFour = M[1][0]*A[0][1] + M[1][1]*A[1][1];

        M[0][0] = tmpOne;
        M[0][1]= tmpTwo;
        M[1][0]= tmpThree;
        M[1][1]= tmpFour;

        return M;

    }
    static long[][] Q = {{1,1},{1,0}};
}

class Fibonacci6 extends Fibonacci5 {
    @Override
    long Fn(int n) {

        if ( n == 0) return 0;

        long[][] M = matrixPow(Q, n-1);

        return M[0][0];
    }

    @Override
    public String toString() {
        return "Fibonacci6";
    }

    static long[][] matrixPow(long[][] A, int k){
        if (k <= 1){
            Mp[0][0] = 1;
            Mp[1][1] = 1;
            Mp[0][1] = 0;
            Mp[1][0] = 0;
        } else {
            Mp = matrixPow(A,k/2);
            Mp = matrixProduct(Mp,Mp);
        }
        if ( k%2 != 0){
            Mp = matrixProduct(Mp,A);
        }
        return Mp;
    }
    private static long[][] Mp = new long[2][2];
}

public class FibonacciNumber {
    public static long  fibonacci(Fibonacci fib, int n){
        return fib.Fn(n);
    }
    public static void main(String[] args){
        long startTime;
        long taskTime;

        Fibonacci[] fn = new Fibonacci[6];
        fn[0] = new Fibonacci1();
        fn[1] = new Fibonacci2();
        fn[2] = new Fibonacci3();
        fn[3] = new Fibonacci4();
        fn[4] = new Fibonacci5();
        fn[5] = new Fibonacci6();


        int n = 45;
        for (Fibonacci fib: fn){
            startTime = System.currentTimeMillis();
            System.out.println(fib + "(" + n+ ")= " + fibonacci(fib,n));
            taskTime = System.currentTimeMillis() - startTime;
            System.out.println("Time : " + taskTime + "millsec");
        }
    }
}
