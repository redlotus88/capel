package com.c8n.guava;

import com.google.common.base.Splitter;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

@Log4j2
public class SplitterExample {

    public static void main(String[] args) {
        String testString = "Monday,Tuesday,,Thursday,Friday,,";
        String[] parts = testString.split(",");
        log.info("Java String splitter example: {}", Arrays.toString(parts));
        log.info("Guava Splitter example: {}", Splitter.on(",").split(testString));


    }
}
