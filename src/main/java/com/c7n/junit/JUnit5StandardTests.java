package com.c7n.junit;

import org.junit.jupiter.api.*;

/**
 * JUnit5StandardTests
 *
 * @author jialong.wang
 * @Date on 2021/1/6 1:14 PM
 * @since 1.0
 */
@DisplayName("Junit5 标准测试用例")
public class JUnit5StandardTests {

    @BeforeAll
    static void initAll() {
        System.out.println("所有测试前，执行方法。");
    }

    @BeforeEach
    void init() {
        System.out.println("每个测试单元前 执行方法。");
    }

    @Test
    void succeedingTest() {

    }

    @Test
    void failingTest() {
        Assertions.fail("a failing test");
    }

    @Test
    @Disabled("for demostration purposes")
    void skippedTest() {
        // not executed
    }

    @Test
    void abortedTest() {
        Assumptions.assumeTrue("abc".contains("Z"));
        Assertions.fail("test should have been aborted");
    }

    @AfterEach
    void tearDown() {
        System.out.println("每个测试单元结束后，执行方法");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("所有测试用例结束后，执行方法");
    }
}
