package com.redlotus;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by dragon on 2019/7/4.
 */
@SpringBootApplication
public class RedlotusApplicationTest {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(RedlotusApplicationTest.class)
                .run(args);
        System.out.println("启动junit本地应用");
    }
}
