package com.c7n.lock;

import lombok.Data;

/**
 * 抽象资源类
 *
 * @author jialong.wang
 * @Date on 2020/12/15 3:18 PM
 * @since 1.0
 */
@Data
public class Resource {

    public static final Resource FIXED_RESOURCE_1 = new Resource();
    public static final Resource FIXED_RESOURCE_2 = new Resource();

    public static Resource newResource() {
        return new Resource();
    }
}
