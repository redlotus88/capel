package com.c7n.lock;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * 抽象资源类
 *
 * @author jialong.wang
 * @Date on 2020/12/15 3:18 PM
 * @since 1.0
 */
@Data
@NoArgsConstructor
public class Resource {

    public static final Resource FIXED_RESOURCE_1 = new Resource();
    public static final Resource FIXED_RESOURCE_2 = new Resource();

    private String id = UUID.randomUUID().toString();

    private BigDecimal quantity;


    public Resource(String id, Integer qty) {
        this.id = id;
        this.quantity = BigDecimal.valueOf(qty);
    }

    public static Resource newResource() {
        return new Resource();
    }

    public void setQuantity(int qty) {
        this.quantity = BigDecimal.valueOf(qty);
    }
}
