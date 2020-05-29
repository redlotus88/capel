package com.c8n.bigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {

    public static void main(String[] args) {

        BigDecimal bigDecimal = new BigDecimal("12312412.123123");

        System.out.println("Origin value: " + bigDecimal.toPlainString());
        System.out.println("To Integer: " + bigDecimal.intValue());
        // Throw Error java.lang.ArithmeticException: Rounding necessary
//        System.out.println("To Integer Exact: " + bigDecimal.intValueExact());
        System.out.println("To Big Integer: " + bigDecimal.toBigInteger());
        // Throw Error java.lang.ArithmeticException: Rounding necessary
//        System.out.println("To Big Integer Exact: " + bigDecimal.toBigIntegerExact());

        BigDecimal roundHalfUp1 = new BigDecimal("123.456").setScale(0, RoundingMode.HALF_UP);
        BigDecimal roundHalfUp2 = new BigDecimal("9912345678901.589").setScale(0, RoundingMode.HALF_UP);
        System.out.println("Round Half up: " + roundHalfUp1.toBigIntegerExact());
        System.out.println("Round Half up: " + roundHalfUp2.toBigInteger());
        System.out.println("Round Half up: " + roundHalfUp2.doubleValue());
    }
}
