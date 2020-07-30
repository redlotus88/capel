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
public class OperationTester {

    public static void main(String[] args) {
        OperationContext oc1= new OperationContext(new OperationAdd());
        System.out.println("10 + 5 = " + oc1.executeStrategy(10, 5));

        OperationContext oc2 = new OperationContext(new OperationSubtract());
        System.out.println("10 - 5 = " + oc2.executeStrategy(10, 5));

        OperationContext oc3 = new OperationContext(new OperationMultiply());
        System.out.println("10 * 5 = " + oc3.executeStrategy(10, 5));
    }
}
