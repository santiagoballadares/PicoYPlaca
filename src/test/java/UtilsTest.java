import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class UtilsTest {

    @Test
    public void isNullOrEmpty() {
        String nonEmptyString = "This is a not null nor empty string.";
        String emptyString = "";
        String nullString = null;

        Assert.assertFalse("False expected.", Utils.isNullOrEmpty(nonEmptyString));
        Assert.assertTrue("True expected.", Utils.isNullOrEmpty(emptyString));
        Assert.assertTrue("True expected.", Utils.isNullOrEmpty(nullString));
    }

    @Test
    public void getLastDigitFromString() {
        String s = "123456789";
        int expectedDigit = 9;
        Assert.assertEquals("Digit mismatch.", expectedDigit, Utils.getLastDigitFromString(s));
    }

    @Test
    public void isIntInArray() {
        int[] haystack = new int[]{2,4,6,8,10,12};
        int needle = 8;
        Assert.assertTrue("True expected.", Utils.isIntInArray(haystack, needle));
        Assert.assertFalse("False expected.", Utils.isIntInArray(haystack, 1));
    }

    @Test
    public void isLocalDateInArray() {
        LocalDate[] haystack = new LocalDate[]{
                LocalDate.parse("2016-02-05"),
                LocalDate.parse("2016-10-01"),
                LocalDate.parse("2017-07-23")
        };
        LocalDate needle = LocalDate.parse("2016-10-01");
        Assert.assertTrue("True expected.", Utils.isLocalDateInArray(haystack, needle));
        Assert.assertFalse("False expected.", Utils.isLocalDateInArray(haystack, LocalDate.parse("2000-06-01")));
    }
}