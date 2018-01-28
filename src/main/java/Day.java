public class Day {
    private String name;
    private TimeInterval[] timetable;
    private int[] licenseDigits;

    public Day(String name, TimeInterval[] timetable, int[] licenseDigits) {
        this.name = name.toUpperCase();
        this.timetable = timetable;
        this.licenseDigits = licenseDigits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public TimeInterval[] getTimetable() {
        return timetable;
    }

    public void setTimetable(TimeInterval[] timetable) {
        this.timetable = timetable;
    }

    public int[] getLicenseDigits() {
        return licenseDigits;
    }

    public void setLicenseDigits(int[] licenseDigits) {
        this.licenseDigits = licenseDigits;
    }
}
