package com.redlotus.user.vo;

import com.redlotus.user.common.FieldConstraintConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * Capel User VO
 *
 * 用户VO对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CapelUserVO implements Serializable {

    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空")
    @Length(max = FieldConstraintConstants.MAX_USERNAME_LENGTH)
    private String username;

    /**
     * 前端传的密码
     */
    @NotEmpty(message = "密码不能为空")
    @Length(max = FieldConstraintConstants.MAX_PASSWORD_LENGTH)
    private String password;
}
