package com.c7n.designPattern.delegate;

/**
 * <功能描述>
 * ————————
 * <修改记录>
 * ————————
 *
 * @author jialong.wang
 * @Date on 2020/7/30 9:14 AM
 * @since 1.0
 */
public class DeveloperTwo implements DevelopmentNeeds {

    @Override
    public void doing(String needsName) {
        System.out.println("我是程序员2号，我在苦逼的开发：" + needsName + "需求");
    }
}
