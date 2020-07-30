package com.c7n.designPattern.strategy;

/**
 * <功能描述>
 * ————————
 * <修改记录>
 * ————————
 *
 * @author jialong.wang
 * @Date on 2020/7/30 9:52 PM
 * @since 1.0
 */
public class OperationContext {

    private OperationStrategy strategy;

    public OperationContext(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
