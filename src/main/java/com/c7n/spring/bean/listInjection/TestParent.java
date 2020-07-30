package com.c7n.spring.bean.listInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
@Component
public class TestParent {

    @Autowired
    @Mark
    private List<Test> tests;

    public void printTest() {
        tests.stream().forEach(Test::test);
    }

}
