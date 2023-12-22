package domain.model.training;

public class Time {
    private byte hours;
    private byte minutes;
    private byte seconds;

    public Time(byte hours, byte minutes, byte seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public byte getHours() {
        return hours;
    }

    public byte getMinutes() {
        return minutes;
    }

    public byte getSeconds() {
        return seconds;
    }

    public void setHours(byte hours) {
        this.hours = hours;
    }

    public void setMinutes(byte minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(byte seconds) {
        this.seconds = seconds;
    }
}
