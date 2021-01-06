package com.c7n.junit;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * JUnit5HelloWorld
 *
 * @author jialong.wang
 * @Date on 2021/1/6 11:08 AM
 * @since 1.0
 */
@DisplayName("Test01 - Hello World")
public class JUnit5HelloWorld {

    @Test
    void addition() {
        Assertions.assertEquals(2, 1 + 1);
    }
}
