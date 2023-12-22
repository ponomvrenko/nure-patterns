package java.domain.model.training;

public class Time {
    private byte minutes;
    private byte seconds;

    public Time(byte minutes, byte seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public byte getMinutes() {
        return minutes;
    }

    public byte getSeconds() {
        return seconds;
    }

    public void setMinutes(byte minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(byte seconds) {
        this.seconds = seconds;
    }
}
