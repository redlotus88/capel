package com.c7n.designPattern.decorator;

/**
 * <功能描述>
 * ————————
 * <修改记录>
 * ————————
 *
 * @author jialong.wang
 * @Date on 2020/7/30 9:43 AM
 * @since 1.0
 */
public class AbstractorDecorator implements Human {

    private Human human;

    public AbstractorDecorator(Human human) {
        this.human = human;
    }

    @Override
    public void run() {
        human.run();
    }
}
