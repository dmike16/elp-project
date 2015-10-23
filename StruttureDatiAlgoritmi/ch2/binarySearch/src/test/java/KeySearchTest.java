/**
 * Created by dmike on 22/10/15.
 * @author dmike
 */
import ex.dmike.algostructure.KeySearch;
import static org.junit.Assert.*;
import org.junit.Test;


public class KeySearchTest {
    @Test
    public void testSearch(){
        int[] v = {23,24,50,52,60,200};
        KeySearch a = new KeySearch(v);

        assertEquals("24 in v is in pos 1",1,a.binary(24));
        assertEquals("200 in v is in pos 5",5,a.sequenzial(200));
        assertEquals("23 in v is in pos 0",0,a.binary(23));
        assertEquals("100 is not in v",-1,a.binary(100));
    }
}
