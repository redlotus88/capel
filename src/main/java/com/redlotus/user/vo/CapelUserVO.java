package com.redlotus.user.vo;

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

    @NotEmpty(message = "用户名不能为空")
    @Length(max = 16)
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Length(max = 32)
    private String password;
}
