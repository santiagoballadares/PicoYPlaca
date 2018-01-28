import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Predictor predictor;

    private static void init() {
        // Timetable for each day.
        TimeInterval[] timetable = new TimeInterval[]{
                new TimeInterval(LocalTime.parse("07:00"), LocalTime.parse("09:30")),
                new TimeInterval(LocalTime.parse("16:00"), LocalTime.parse("19:30"))};

        // Collection of days.
        Map<String, Day> days = new HashMap<>();
        days.put("MONDAY",      new Day("MONDAY",       timetable, new int[]{1,2}));
        days.put("TUESDAY",     new Day("TUESDAY",      timetable, new int[]{3,4}));
        days.put("WEDNESDAY",   new Day("WEDNESDAY",    timetable, new int[]{5,6}));
        days.put("THURSDAY",    new Day("THURSDAY",     timetable, new int[]{7,8}));
        days.put("FRIDAY",      new Day("FRIDAY",       timetable, new int[]{9,0}));

        // Array of holidays.
        LocalDate[] holidays = new LocalDate[]{
                LocalDate.parse("2018-01-01"),
                LocalDate.parse("2018-02-12"),
                LocalDate.parse("2018-02-13"),
                LocalDate.parse("2018-03-30"),
                LocalDate.parse("2018-05-01")};

        // The predictor.
        predictor = new Predictor(days, holidays);
    }

    public static void main(String[] args) {
        // First, let's init the predictor
        init();

        System.out.println("\"Pico y Placa\" predictor");

        String input;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\nSelect option: (q) Quit (n) New query");
            input = sc.nextLine().trim();

            if ("n".equals(input)) {
                System.out.println("Enter license plate number:");
                String licensePlateNumber = sc.nextLine().trim();

                if (Utils.isNullOrEmpty(licensePlateNumber)) {
                    System.out.println("License plate number: " + licensePlateNumber + " is incorrect.");
                    continue;
                }

                LocalDate today = LocalDate.now();
                String dateStr = today.format(DateTimeFormatter.ISO_LOCAL_DATE);
                LocalTime time = LocalTime.now();

                if (predictor.evaluate(licensePlateNumber, dateStr, time)) {
                    System.out.println("The car with the given license plate number can be on the road.");
                } else {
                    System.out.println("The car with the given license plate number cannot be on the road.");
                }
            }
        } while (!"q".equals(input));
    }
}
