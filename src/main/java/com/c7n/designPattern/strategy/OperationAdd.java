package com.c7n.designPattern.strategy;

/**
 * <功能描述>
 * ————————
 * <修改记录>
 * ————————
 *
 * @author jialong.wang
 * @Date on 2020/7/30 9:51 PM
 * @since 1.0
 */
public class OperationAdd implements OperationStrategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
