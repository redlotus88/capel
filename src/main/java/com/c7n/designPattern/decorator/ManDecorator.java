package com.c7n.designPattern.decorator;

/**
 * <功能描述>
 * ————————
 * <修改记录>
 * ————————
 *
 * @author jialong.wang
 * @Date on 2020/7/30 9:44 AM
 * @since 1.0
 */
public class ManDecorator extends AbstractorDecorator {

    public ManDecorator(Human human) {
        super(human);
    }

    private void fly() {
        System.out.println("人可以飞");
    }

    @Override
    public void run() {
        super.run();
        fly();
    }
}
