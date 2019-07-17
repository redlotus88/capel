package com.c8n;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by dragon on 2019/7/4.
 */
@SpringBootApplication
public class ApplicationTest {

    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder()
                .sources(ApplicationTest.class)
                .profiles("junit")
                .run(args);
        System.out.println("启动junit本地应用");
    }
}
