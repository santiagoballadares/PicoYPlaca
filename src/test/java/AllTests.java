import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UtilsTest.class,
        TimeIntervalTest.class,
        DayTest.class,
        PredictorTest.class
})
public class AllTests {
}
