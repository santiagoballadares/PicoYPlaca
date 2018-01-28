import java.time.LocalTime;

public class TimeInterval {
    private LocalTime startTime;
    private LocalTime endTime;

    public TimeInterval(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public boolean containsTime(final LocalTime time) {
        return (time.equals(this.startTime) || time.isAfter(this.startTime)) &&
                (time.equals(this.endTime) || time.isBefore(this.endTime));
    }
}
