package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormater {
    private static final String DATE_FORMAT = "dd-MM-yy";
    private static final String DATE_FORMAT_WITH_HOUR = "dd-MM-yy HH'h'mm'm'ss's'";

    public static String formattedDateAndHour() {
        return formatDate(DATE_FORMAT_WITH_HOUR);
    }

    public static String formattedDate() {
        return formatDate(DATE_FORMAT);
    }

    private static String formatDate(String format) {
        Date now = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
        return dateFormatter.format(now);
    }
}
