package com.c8n.logic_delete;

import com.c8n.ApplicationTest;
import com.c8n.mapper.LogicDeleteTestMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by dragon on 2019/7/4.
 */
@SpringBootTest(classes = {ApplicationTest.class})
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.JVM)
@ActiveProfiles("junit")
@Slf4j
public class LogicDeleteTest {

    @Autowired
    private LogicDeleteTestMapper logicDeleteTestMapper;

    @Test
    public void testLogicDelete() {
        LogicDeleteTestBean bean = new LogicDeleteTestBean();
        bean.setId(1);
        bean.setData("test");

        logicDeleteTestMapper.insert(bean);
        LogicDeleteTestBean select = logicDeleteTestMapper.selectById(1);
        log.info("{}", select);

        logicDeleteTestMapper.deleteById(1);
    }
}
