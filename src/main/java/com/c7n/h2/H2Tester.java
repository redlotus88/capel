package com.c7n.h2;

import com.c7n.Application;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * <功能描述>
 *
 * @author jialong.wang
 * @Date on 2021/1/14 1:31 PM
 * @since 1.0
 */
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
@NoArgsConstructor
@ActiveProfiles("h2")
public class H2Tester {

    @Autowired
    H2TestRepository h2TestRepository;

    @Test
    public void testCRUD() {
        H2TestModel h2TestModel = new H2TestModel();
        h2TestModel.setType("China/Shanghai");
        h2TestModel.setLongitude(121.28);
        h2TestModel.setLatitude(31.14);

        h2TestRepository.save(h2TestModel);
    }
}
