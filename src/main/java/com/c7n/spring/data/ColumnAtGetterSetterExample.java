package com.c7n.spring.data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "column_at_getter_setter_example")
public class ColumnAtGetterSetterExample {
    /**
     * uuid 自动生成
     */
    @Id
    @Column(nullable = false, unique = true, length = 32)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private BigDecimal mileageLimit;

    public ColumnAtGetterSetterExample() {}

    public ColumnAtGetterSetterExample(BigDecimal mileageLimit) {
        this.mileageLimit = mileageLimit;
    }

    @Column
    public void setMileageLimit(BigDecimal mileageLimit) {
        this.mileageLimit = mileageLimit;
    }

    @Column
    public BigDecimal getMileageLimit() {
        return this.mileageLimit;
    }

    public int getId() {
        return this.id;
    }
}
