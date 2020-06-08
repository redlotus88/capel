package com.redlotus.user.builder;

import com.redlotus.user.model.CapelUser;
import lombok.AllArgsConstructor;
import lombok.Data;
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

    public static CapelUserBuilder of(String username, String password) {
        return new CapelUserBuilder(username, password);
    }
}
