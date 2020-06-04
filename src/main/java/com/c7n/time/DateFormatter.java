package com.c7n.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * CDateFormatter util工具
 */
public final class DateFormatter {

    private DateFormatter() {}

    /**
     * format pattern yyyy-MM-dd HH:mm:ss
     * @param date Date
     * @return String
     */
    public static String formatDate(Date date) {
        ZoneId zone = ZoneId.systemDefault();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.format(LocalDateTime.ofInstant(date.toInstant(), zone));
    }

    /**
     * format pattern yyyy-MM-dd HH:mm:ss
     *
     * @param localDateTime
     * @return
     */
    public static String formatDate(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }
}
