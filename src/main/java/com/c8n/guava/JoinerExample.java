package com.c8n.guava;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 字符串连接工具: Joiner
 *
 * java lambda 8 的Collectors性能与Joiner相似，可以直接使用.
 */
@Log4j2
public class JoinerExample {

    public static void main(String[] args) {
        /*
         *  Joiner连接测试
         */
        List<String> arrayString = Arrays.asList("a", "b", "c", null, "d");
        log.info("Build String skip null： " + Joiner.on("|").skipNulls().join(arrayString));
        log.info("Build String use default replace null: " + Joiner.on("|").useForNull("no value").join(arrayString));

        /*
         * Joiner效率
         */
        long currentTime = System.currentTimeMillis();
        int num = 100000;
        List<String> randomList = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            randomList.add(RandomStringUtils.random(2));
        }
        log.info("生成{}个字符 耗时：{} ms", num, System.currentTimeMillis() - currentTime);

        currentTime = System.currentTimeMillis();
        String join = Joiner.on(",").join(randomList);
        log.info("Joiner连接{}个字符 耗时：{} ms", num, System.currentTimeMillis() - currentTime);

        currentTime = System.currentTimeMillis();
        String collect = randomList.stream().collect(Collectors.joining("|"));
        log.info("Stream连接{}个字符 耗时：{} ms", num, System.currentTimeMillis() - currentTime);


        /*
            MapJoiner 的测试
         */
        Map<String, String> testMap = Maps.newLinkedHashMap();
        testMap.put("Washington D.C","Redskins");
        testMap.put("New York City","Giants");
        testMap.put("Philadelphia","Eagles");
        testMap.put("Dallas","Cowboys");
        String returnedString = Joiner.on("#").withKeyValueSeparator("=").join(testMap);
        log.info("MapJoiner连接字符串 结果：{}", returnedString);
    }

}
