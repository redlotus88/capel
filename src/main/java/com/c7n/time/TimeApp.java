package com.c7n.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by dragon on 2019/7/22.
 */
public class TimeApp {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.toInstant());

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(LocalDateTime.ofInstant(date.toInstant(), zone));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(LocalDateTime.ofInstant(date.toInstant(), zone)));
    }
}
