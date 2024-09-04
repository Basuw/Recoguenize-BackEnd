package recoguenize.com.backend.mapper.common;

import java.sql.Time;
import java.time.LocalTime;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class DurationMapper {

    public Time toTime(String duration) {
        String[] parts = duration.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        LocalTime localTime = LocalTime.of(0, minutes, seconds);
        return Time.valueOf(localTime);
    }

    public String toString(Time time) {
        if (time == null) {
            return null;
        }
        LocalTime localTime = time.toLocalTime();
        int minutes = localTime.getMinute();
        int seconds = localTime.getSecond();
        return String.format("%02d:%02d", minutes, seconds);
    }
}
