package com.redlotus.security.common;

/**
 * 环境常量
 */
public enum EnvironmentEnums {

    DEFAULT("default"), DEV("dev");

    private String name;

    EnvironmentEnums(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
