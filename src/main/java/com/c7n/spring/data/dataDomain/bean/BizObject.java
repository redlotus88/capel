package com.c7n.spring.data.dataDomain.bean;

import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity(name = "com.c7n.spring.data.dataDomain.bizObject")
@Data
public class BizObject {

    /**
     * uuid 自动生成
     */
    @Id
    @Column(nullable = false, unique = true, length = 32)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected int id;

    @Column
    private String keySerial;

    @Column
    private String bizValue1;

    @Column
    private String bizValue2;

    public BizObject() {
    }

    BizObject(String keySerial) {
        this.keySerial = keySerial;
    }


    public static class BizObjectBuilder {
        BizObject of(BizObjectDto dto) {
            BizObject instance = new BizObject(dto.getKey().toString());
            BeanUtils.copyProperties(dto, instance);
            return instance;
        }
    }
}
