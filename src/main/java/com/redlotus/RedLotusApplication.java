package com.redlotus;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by dragon on 2019/7/4.
 */
@SpringBootApplication
@EnableApolloConfig
public class RedLotusApplication {

    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder()
                .sources(RedLotusApplication.class)
                .run(args);
    }
}
