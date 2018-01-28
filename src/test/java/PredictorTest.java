import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class PredictorTest {
    private Predictor predictor;
    private Map<String, Day> days;
    private LocalDate[] holidays;
    private TimeInterval[] timetable;

    @Before
    public void setUp() {
        timetable = new TimeInterval[]{new TimeInterval(LocalTime.parse("09:00"), LocalTime.parse("12:00"))};

        days = new HashMap<>();
        days.put("SATURDAY", new Day("SATURDAY", timetable, new int[]{1,2,3}));
        days.put("SUNDAY", new Day("SUNDAY", timetable, new int[]{4,5,6}));

        holidays = new LocalDate[]{LocalDate.parse("2018-01-28")};

        predictor = new Predictor(days, holidays);
    }

    @Test
    public void getDays() {
        Assert.assertEquals("HashMaps mismatch.", days, predictor.getDays());
    }

    @Test
    public void setDays() {
        Map<String, Day> newDays = new HashMap<>();
        newDays.put("MONDAY", new Day("MONDAY", timetable, new int[]{1,2,3}));
        predictor.setDays(newDays);
        Assert.assertEquals("HashMaps mismatch.", newDays, predictor.getDays());
    }

    @Test
    public void getHolidays() {
        Assert.assertArrayEquals("Arrays mismatch.", holidays, predictor.getHolidays());
    }

    @Test
    public void setHolidays() {
        LocalDate[] newHolidays = new LocalDate[]{LocalDate.parse("2018-01-27")};
        predictor.setHolidays(newHolidays);
        Assert.assertArrayEquals("Arrays mismatch.", newHolidays, predictor.getHolidays());
    }

    @Test
    public void evaluate() {
        String licensePlateNumber = "PCL6011";
        String date1 = "2018-01-27";
        String date2 = "2018-04-10";
        LocalTime time1 = LocalTime.parse("10:10");
        LocalTime time2 = LocalTime.parse("15:30");

        Assert.assertFalse("False expected.", predictor.evaluate(licensePlateNumber, date1, time1));
        Assert.assertTrue("True expected.", predictor.evaluate(licensePlateNumber, date1, time2));
        Assert.assertTrue("True expected.", predictor.evaluate(licensePlateNumber, date2, time2));
    }
}