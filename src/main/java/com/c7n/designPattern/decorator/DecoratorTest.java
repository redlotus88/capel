package com.c7n.designPattern.decorator;

/**
 * <功能描述>
 * ————————
 * <修改记录>
 * ————————
 *
 * @author jialong.wang
 * @Date on 2020/7/30 9:45 AM
 * @since 1.0
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Human human = new Man();
        Human superman = new ManDecorator(human);

        superman.run();
    }
}
