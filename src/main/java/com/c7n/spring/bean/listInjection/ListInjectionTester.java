package com.c7n.spring.bean.listInjection;

import com.c7n.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <功能描述>
 * ————————
 * <修改记录>
 * ————————
 *
 * @author jialong.wang
 * @Date on 2020/7/30 10:16 PM
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
@ActiveProfiles("junit")
public class ListInjectionTester {

    @Autowired
    private TestParent testParent;

    @Test
    public void testListInjection() {
        testParent.printTest();
    }

}
