package com.c7n.time;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Created by dragon on 2019/7/23.
 */
public class TimeStampApp {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
    }
}
