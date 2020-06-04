package com.c7n.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dragon on 2019/8/8.
 */
public class StringTest {

    public static void main(String[] args) {
//        System.out.println("\u643a\u7a0b\u8ba2\u5355\u521b\u5efa\u5931\u8d25,\u643a\u7a0b\u8ba2\u5355\u53f7:10350992007\u8ba2\u5355\u6570\u636e\u5b58\u8868\u5931\u8d25!");
        List<Integer> tests = new ArrayList<>();
        tests.add(100);
        tests.add(10);
        tests.add(5);

        System.out.println(tests.parallelStream().reduce((acc, item) -> acc - item).get());
    }
}
