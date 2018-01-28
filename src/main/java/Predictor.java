import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class Predictor {
    private Map<String, Day> days;
    private LocalDate[] holidays;

    public Predictor(Map<String, Day> days, LocalDate[] holidays) {
        this.days = days;
        this.holidays = holidays;
    }

    public Map<String, Day> getDays() {
        return days;
    }

    public void setDays(Map<String, Day> days) {
        this.days = days;
    }

    public LocalDate[] getHolidays() {
        return holidays;
    }

    public void setHolidays(LocalDate[] holidays) {
        this.holidays = holidays;
    }

    /**
     * Evaluates whether a car can be on the road or not.
     * @param licensePlateNumber The car's license plate number.
     * @param date String The date.
     * @param time LocalTime The time.
     * @return boolean True when a car is allowed to be on the road, else false.
     */
    public boolean evaluate(String licensePlateNumber, String date, LocalTime time) {
        System.out.println("Evaluating for: Date=" + date + "; Time=" + time.toString());

        // Cast the input date from String to LocalDate.
        LocalDate dateToQuery = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);

        // Check if the given date is a holiday.
        if (isHoliday(dateToQuery)) {
            return true;
        }

        // Look up the date's day in the HashMap 'days'.
        // Here we assume that if a day has not been added to 'days', then that day has no restrictions at all.
        Day day = findDay(dateToQuery.getDayOfWeek().name());

        // If not found, return true.
        if (day == null) {
            return true;
        }

        // Get the last digit of the car's license plate number.
        int licenseLastDigit = Utils.getLastDigitFromString(licensePlateNumber);

        // Look up for the last digit in the day's license digits array.
        if (Utils.isIntInArray(day.getLicenseDigits(), licenseLastDigit)) {
            // Check if time is in any time range.
            for (int i=0; i < day.getTimetable().length; ++i) {
                // If time is in any time range, return false.
                if (day.getTimetable()[i].containsTime(time)) {
                    return false;
                }
            }

            // Return true as time is not in any time range.
            return true;
        }

        // Finally return false if no other condition has been met.
        return false;
    }

    private boolean isHoliday(final LocalDate date) {
        return Utils.isLocalDateInArray(this.holidays, date);
    }

    private Day findDay(final String dayName) {
        return this.days.get(dayName);
    }
}
