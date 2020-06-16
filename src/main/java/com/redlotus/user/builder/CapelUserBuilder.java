package com.redlotus.user.builder;

import com.redlotus.user.model.CapelUser;
import com.redlotus.user.vo.CapelUserVO;
import lombok.NoArgsConstructor;

/**
 * Capel User Builder Class
 */
@NoArgsConstructor
public class CapelUserBuilder {

    public CapelUser capelUser = new CapelUser();

    public CapelUserBuilder(String username, String password) {
        capelUser.setUsername(username);
        capelUser.setPassword(password);
    }

    public CapelUser build() {
        return capelUser;
    }


    public CapelUserBuilder username(String username) {
        capelUser.setUsername(username);
        return this;
    }

    public CapelUserBuilder password(String password) {
        capelUser.setPassword(password);
        return this;
    }

    public static CapelUserBuilder of(CapelUserVO vo) {
        return CapelUserBuilder.of(vo.getUsername(), vo.getPassword());
    }

    public static CapelUserBuilder of(String username, String password) {
        return new CapelUserBuilder(username, password);
    }
}
