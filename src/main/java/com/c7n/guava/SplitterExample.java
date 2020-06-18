package com.c7n.guava;

import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Log4j2
public class SplitterExample {

    public static void main(String[] args) {
        String testString = "Monday,Tuesday,,Thursday,Friday,,";
        String[] parts = testString.split(",");
        log.info("Java String splitter example: {}", Arrays.toString(parts));
        log.info("Guava Splitter example: {}", Splitter.on(",").split(testString));
        testSplitter();
    }

    private static void testSplitter() {
        String startString = "Washington D.C=Redskins#New York City=Giants#Philadelphia=Eagles#Dallas=Cowboys";
        Map<String, String> testMap = Maps.newLinkedHashMap();
        testMap.put("Washington D.C","Redskins");
        testMap.put("New York City","Giants");
        testMap.put("Philadelphia","Eagles");
        testMap.put("Dallas","Cowboys");

        Splitter.MapSplitter mapSplitter = Splitter.on("#").withKeyValueSeparator("=");
        Map<String, String> splitMap = mapSplitter.split(startString);
        assertThat(testMap, is(splitMap));
    }
}
