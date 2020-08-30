package com.c7n.designPattern.dynamicProxy;

/**
 * <功能描述>
 *
 * @author jialong.wang
 * @Date on 2020/8/30 10:08 PM
 * @since 1.0
 */
public class ChineseHello implements HelloInterface {

    @Override
    public String sayHello() {
        return "你好";
    }
}
