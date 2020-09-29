package io.stahlferro.mangorhodes.utility.models;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class TimeConstants {
    public static final SimpleDateFormat GENERIC_DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    // Allows LocalDateTime to accept yyyy-MM-dd, in which default 00:00:00 will be the time default
    public static final DateTimeFormatter LOCAL_DATE_OPTIONAL_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendPattern("yyyy-MM-dd['T'HH:mm[:ss]]")
            .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
            .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
            .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
            .toFormatter();
}
