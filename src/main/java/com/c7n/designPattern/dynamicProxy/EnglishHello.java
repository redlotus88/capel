package com.c7n.designPattern.dynamicProxy;

/**
 * <功能描述>
 *
 * @author jialong.wang
 * @Date on 2020/8/30 10:09 PM
 * @since 1.0
 */
public class EnglishHello implements HelloInterface {

    @Override
    public String sayHello() {
        return "Hi!";
    }
}
