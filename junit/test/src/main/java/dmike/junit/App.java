package dmike.junit;

/**
 * Hello world!
 *
 */
public class App 
{
    public int evalutaror(String expression) {
        int sum = 0;
        for (String val : expression.split("\\+")) {
            sum += Integer.valueOf(val);
        }
        return sum;
    }

}
