package dmike.junit;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.logging.Logger;

/**
 * Created by dmike on 22/04/17.
 * @author dmike
 */
public class TestLogger implements TestRule{
    @Override
    public Statement apply(final Statement statement, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                logger = Logger.getLogger(String.format("%s.%s"
                        ,description.getTestClass().getName(),
                        description.getDisplayName()));
                statement.evaluate();
            }
        };
    }

    public Logger getLogger(){
        return this.logger;
    }

    private Logger logger;
}
