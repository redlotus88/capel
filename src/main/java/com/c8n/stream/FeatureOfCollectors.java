package com.c8n.stream;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class FeatureOfCollectors {


    public static void main(String[] args) {
        // Test Collect Set
        List<TestObject> tests = new ArrayList<>();
        tests.add(new TestObject("1", "2"));
        tests.add(new TestObject(null, null));
        System.out.println(testCollectSet(tests));
        Iterator<String> it = testCollectSet(tests).iterator();
        System.out.println(it.next());
        System.out.println(it.next());
    }

    private static Set<String> testCollectSet(List<TestObject> tests) {
        return tests.stream().map(TestObject::getA).collect(Collectors.toSet());
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
