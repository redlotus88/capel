package com.redlotus.user.model;

import com.redlotus.user.common.FieldConstraintConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

    @Column(nullable = false, unique = true, length = FieldConstraintConstants.MAX_USERNAME_LENGTH)
    private String username;

    @Column(nullable = false, length = FieldConstraintConstants.MAX_PASSWORD_LENGTH)
    private String password;
}
