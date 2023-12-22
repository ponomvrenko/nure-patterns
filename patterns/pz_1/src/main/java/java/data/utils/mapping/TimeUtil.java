package java.data.utils.mapping;

import java.sql.Time;

public class TimeUtil {

    public static Time fromSql(java.sql.Time sqlTime) {
        String timeString = sqlTime.toString();
        byte hours = Byte.parseByte(timeString.split(":")[0]);
        byte minutes = Byte.parseByte(timeString.split(":")[1]);
        byte seconds = Byte.parseByte(timeString.split(":")[2]);

        return new Time(hours, minutes, seconds);
    }

    public static java.sql.Time toSql(Time time) {
        return new java.sql.Time(time.getHours(), time.getMinutes(), time.getSeconds());
    }
}
