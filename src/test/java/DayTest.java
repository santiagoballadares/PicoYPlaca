import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

public class DayTest {
    private Day day;
    private String dayName;
    private TimeInterval[] timetable;
    private int[] licenseDigits;

    @Before
    public void setUp() {
        dayName = "MONDAY";
        timetable = new TimeInterval[]{
                new TimeInterval(LocalTime.parse("08:00"), LocalTime.parse("12:00")),
                new TimeInterval(LocalTime.parse("17:00"), LocalTime.parse("21:00"))};
        licenseDigits = new int[]{2,4,6,8};
        day = new Day(dayName, timetable, licenseDigits);
    }

    @Test
    public void getName() {
        Assert.assertEquals("String objects mismatch.", dayName, day.getName());
    }

    @Test
    public void setName() {
        String newName = "FRIDAY";
        day.setName(newName);
        Assert.assertEquals("String objects mismatch.", newName, day.getName());
    }

    @Test
    public void getTimetable() {
        Assert.assertArrayEquals("Arrays mismatch.", timetable, day.getTimetable());
    }

    @Test
    public void setTimetable() {
        TimeInterval[] newTimetable = new TimeInterval[]{
                new TimeInterval(LocalTime.parse("10:00"), LocalTime.parse("15:00"))};
        day.setTimetable(newTimetable);
        Assert.assertArrayEquals("Arrays mismatch.", newTimetable, day.getTimetable());
    }

    @Test
    public void getLicenseDigits() {
        Assert.assertArrayEquals("Arrays mismatch.", licenseDigits, day.getLicenseDigits());
    }

    @Test
    public void setLicenseDigits() {
        int[] newLicenseDigits = new int[]{1,3,5,7};
        day.setLicenseDigits(newLicenseDigits);
        Assert.assertArrayEquals("Arrays mismatch.", newLicenseDigits, day.getLicenseDigits());
    }
}