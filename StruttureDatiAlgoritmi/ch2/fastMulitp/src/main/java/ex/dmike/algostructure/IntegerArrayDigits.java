package ex.dmike.algostructure;


/**
 * Created by andrea on 04/11/15.
 * @author dmike
 */
public class IntegerArrayDigits {
    public IntegerArrayDigits(){
        digits = new int[MAX_DIGITS +1];

        digits[0] = 1;
        for(int i = MAX_DIGITS; i > 0; i--){
            digits[i] = 0;
        }
    }
    public IntegerArrayDigits(int x){
        digits = new int[MAX_DIGITS + 1];

       if (x < 0){
           digits[0] = -1;
       } else {
           digits[0] = 1;
       }

        for(int i = MAX_DIGITS; i > 0; i--,x /= 10){
            digits[i] = x % 10;
        }

    }
    public static IntegerArrayDigits sum(IntegerArrayDigits x, IntegerArrayDigits... args){
        if (args.length == 0){
            return x;
        } else {
            IntegerArrayDigits result = new IntegerArrayDigits();

            int mult = 1;
            int tmp_mod;

            IntegerArrayDigits[] prev = new IntegerArrayDigits[args.length + 1];
            int carryable = 0;
            prev[0] = x;
            int j = 1;
            for (IntegerArrayDigits k : args) {
                prev[j] = k;
                j++;
            }

            for (int i = MAX_DIGITS, tmp, partial, carry = 0; i > 0; i--) {
                partial = x.digits[i] + carry;
                carry = 0;
                for (IntegerArrayDigits k : args) {
                    tmp = partial + k.digits[i];
                    if (tmp != 0) {
                        tmp_mod = tmp / Math.abs(tmp);
                    } else {
                        tmp_mod = 1;
                    }
                    if (i - 1 != 0 && (tmp < 0 && (prev[carryable].digits[i - 1] > 0) || (tmp > 0 && prev[carryable].digits[i - 1] < 0))) {
                        partial = partial - tmp_mod * 10 + k.digits[i];
                        carry = carry + tmp_mod;
                        if (prev[carryable].digits[i - 1] <= carry) {
                            carryable++;
                        }
                    } else if (Math.abs(tmp) > (10 * mult - 1)) {
                        mult++;
                        carry = carry + tmp_mod;
                        partial = tmp;
                    } else {
                        partial = tmp;
                    }
                }
                result.digits[i] = partial % 10;
                mult = 1;
            }
            for (int i = 1; i <= MAX_DIGITS; i++) {
                if (result.digits[i] != 0) {
                    result.digits[0] = result.digits[i] / (Math.abs(result.digits[i]));
                    break;
                }
            }
            return result;
        }

    }
    @Override
    public String toString (){
        String integer = "";
        int _sign = 1;
        boolean no_print = true;

        if (digits[0] == -1){
            integer += '-';
            _sign = -1;
        } else {
            integer += '+';
        }

        for (int i = 1; i <=MAX_DIGITS; i++){
            if (digits[i] != 0 || !no_print){
                no_print = false;
                integer += digits[i]*_sign;
            }
        }
        if (no_print){
            integer += '0';
        }

        return  integer;
    }
    public static void main(String[] args){
        IntegerArrayDigits n = new IntegerArrayDigits(-14);
        IntegerArrayDigits l = new IntegerArrayDigits(-1);
        IntegerArrayDigits k = new IntegerArrayDigits(-7);


        System.out.println(n);
        System.out.println(k);
        System.out.println(IntegerArrayDigits.sum(n,l,k));
    }
    private int [] digits;
    private static final int MAX_DIGITS = 8;
}
