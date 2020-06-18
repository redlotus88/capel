package com.c7n.guava;

import com.google.common.base.CharMatcher;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 字符匹配相关操作。 可以用以移除(替换)字符串中符合规则的字符
 */
public class CharMatcherExample {

    public static void main(String[] args) {
        String tabsAndSpaces = " String  with      spaces     and\n" +
                "              tabs ";

        String expected = " String with spaces and tabs ";
        String scrubbed = CharMatcher.whitespace().collapseFrom(tabsAndSpaces, ' ');
        assertThat(scrubbed, is(expected));

        String expectedWithTrim = "String with spaces and tabs";
        String scrubbedWithTrim = CharMatcher.whitespace().trimAndCollapseFrom(tabsAndSpaces, ' ');
        assertThat(expectedWithTrim, is(scrubbedWithTrim));
        
        testRetainFrom();
    }

    private static void testRetainFrom() {
        String lettersAndNumbers = "foo989yxbar234";
        String expected = "989234";
        // javaDigit() is deprecated, use inRange to replace
//        String retained = CharMatcher.javaDigit().retainFrom(lettersAndNumbers);
        String retained = CharMatcher.inRange('0', '9').retainFrom(lettersAndNumbers);
        assertThat(expected, is(retained));
    }


}
