package com.c7n.random;

import java.util.Random;

/**
 * Created by dragon on 2019/7/24.
 */
public class RandomTest {

    public static void main(String[] args) {
        Random random = new Random();
        Integer test = random.nextInt(99999);
        System.out.println(String.format("%06d", test.intValue()));
    }
}
