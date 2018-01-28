import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

public class TimeIntervalTest {
    private TimeInterval timeInterval;
    private LocalTime startTime;
    private LocalTime endTime;

    @Before
    public void setUp() {
        startTime = LocalTime.parse("08:00");
        endTime = LocalTime.parse("12:00");
        timeInterval = new TimeInterval(startTime, endTime);
    }

    @Test
    public void getStartTime() {
        Assert.assertEquals("Localtime objects mismatch.", startTime, timeInterval.getStartTime());
    }

    @Test
    public void setStartTime() {
        LocalTime newStartTime = LocalTime.parse("09:00");
        timeInterval.setStartTime(newStartTime);
        Assert.assertEquals("Localtime objects mismatch.", newStartTime, timeInterval.getStartTime());
    }

    @Test
    public void getEndTime() {
        Assert.assertEquals("Localtime objects mismatch.", endTime, timeInterval.getEndTime());
    }

    @Test
    public void setEndTime() {
        LocalTime newEndTime = LocalTime.parse("13:00");
        timeInterval.setEndTime(newEndTime);
        Assert.assertEquals("Localtime objects mismatch.", newEndTime, timeInterval.getEndTime());
    }

    @Test
    public void containsTime() {
        Assert.assertFalse("False expected.", timeInterval.containsTime(LocalTime.parse("07:59")));
        Assert.assertTrue("True expected.", timeInterval.containsTime(startTime));
        Assert.assertTrue("True expected.", timeInterval.containsTime(LocalTime.parse("10:00")));
        Assert.assertTrue("True expected.", timeInterval.containsTime(endTime));
        Assert.assertFalse("False expected.", timeInterval.containsTime(LocalTime.parse("12:01")));
    }
}