package com.c7n.spring.data.dataDomain.bean;

import com.c7n.spring.data.dataDomain.Beanizable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BizObjectDto implements Beanizable<BizObject> {

    private DoubleKey<Key1, Key2> key;

    private String bizValue1;

    private String bizValue2;

    @Override
    public BizObject toEntity() {
        return new BizObject.BizObjectBuilder().of(this);
    }
}