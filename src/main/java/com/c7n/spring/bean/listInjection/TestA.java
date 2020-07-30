package com.c7n.spring.bean.listInjection;

import org.springframework.stereotype.Component;

/**
 * <功能描述>
 * ————————
 * <修改记录>
 * ————————
 *
 * @author jialong.wang
 * @Date on 2020/7/30 10:13 PM
 * @since 1.0
 */
@Component
@Mark
public class TestA implements Test {

    @Override
    public void test() {
        System.out.println("test A");
    }
}
