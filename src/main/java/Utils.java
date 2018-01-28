import java.time.LocalDate;
import java.util.Arrays;

public class Utils {
    public static boolean isNullOrEmpty(final String s) {
        return s == null || s.trim().isEmpty();
    }

    public static int getLastDigitFromString(final String s) throws NullPointerException {
        return Integer.parseInt(s.substring(s.length() - 1));
    }

    public static boolean isIntInArray(final int[] arr, int n) throws NullPointerException {
        return Arrays.stream(arr).anyMatch(x -> x == n);
    }

    public static boolean isLocalDateInArray(final LocalDate[] arr, LocalDate d) throws NullPointerException {
        return Arrays.stream(arr).anyMatch(x -> d.equals(x));
    }
}
