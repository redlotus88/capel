package com.c8n.bestPractice;

/**
 * 求最大公约数的方式
 */
public class GreatestCommonDivisor {

    public static void main(String[] args) {
        System.out.println(gcd(5, 10));
    }

    public static int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}
