package com.redlotus.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.*;

/**
 * Capel系统 用户对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class CapelUser {

    /**
     * uuid 自动生成
     */
    @Id
    @Column(nullable = false, unique = true, length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    private String uuid;

    @Column(nullable = false, unique = true, length = 16)
    private String username;

    @Column(nullable = false, length = 32)
    private String password;
}
