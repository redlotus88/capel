package com.c8n.stream;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FeatureOfCollectors {


    public static void main(String[] args) {
        // Test Collect Set
        List<TestObject> tests = new ArrayList<>();
        tests.add(new TestObject("1", "2"));
        tests.add(new TestObject(null, null));
        Set<String> result = testCollectSet(tests);
        System.out.println(result);
//        Iterator<String> it = testCollectSet(tests).iterator();
//        System.out.println(it.next());
//        System.out.println(it.next());


        // Test Collector Group by
        List<TestObject> test2 = new ArrayList<>();
        test2.add(new TestObject("1", "2"));
        test2.add(new TestObject("1", "3"));
        test2.add(new TestObject("2", "4"));
        test2.add(new TestObject("2", "4"));
        Map<String, List<TestObject>> result2 = testCollectorGroupBy(test2);
        System.out.println(result2);

        List<TestObject> result3 = result2.values().stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(result3);
    }

    private static Set<String> testCollectSet(List<TestObject> tests) {
        return tests.stream().map(TestObject::getA).collect(Collectors.toSet());
    }

    private static Map<String, List<TestObject>> testCollectorGroupBy(List<TestObject> tests) {
        return tests.stream().collect(
                Collectors.groupingBy(TestObject::getA,
                        Collectors.mapping(Function.identity(), Collectors.toList())));
    }
}


class TestObject {
    private String a;
    private String b;

    public TestObject(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}
