package com.c7n;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by dragon on 2019/7/4.
 */
@SpringBootApplication
@EnableApolloConfig
public class Application {

    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder()
                .sources(Application.class)
                .run(args);
    }
}
