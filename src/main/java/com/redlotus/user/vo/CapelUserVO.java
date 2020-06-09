package com.redlotus.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
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

    @NotNull(message = "用户名不能为空")
    private String username;

    @NotNull(message = "密码不能为空")
    private String password;
}
