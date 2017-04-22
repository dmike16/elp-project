package dmike.junit;

import org.junit.Rule;
import org.junit.Test;

import java.util.logging.Logger;

/**
 * Created by dmike on 22/04/17.
 * @author dmike
 */
public class LoggerTest {
    @Rule public final TestLogger logger = new TestLogger();

    @Test public void testLogger(){
        Logger log = logger.getLogger();
        log.warning("Test is running");
    }
}
