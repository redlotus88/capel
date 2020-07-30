package com.c7n.designPattern.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * <功能描述>
 * ————————
 * <修改记录>
 * ————————
 *
 * @author jialong.wang
 * @Date on 2020/7/30 9:17 AM
 * @since 1.0
 */
public class Director implements DevelopmentNeeds {

    private Map<String, DevelopmentNeeds> needs = new HashMap<>();

    public Director() {
        needs.put("洗车", new DeveloperOne());
        needs.put("优惠券", new DeveloperTwo());
    }

    @Override
    public void doing(String needsName) {
        needs.get(needsName).doing(needsName);
    }
}
