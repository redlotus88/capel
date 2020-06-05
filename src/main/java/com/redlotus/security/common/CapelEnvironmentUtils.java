package com.redlotus.security.common;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Capel 环境的工具类
 */
public class CapelEnvironmentUtils {

    /**
     * 根据 Spring profiles 判断当前的运行环境。
     * @param profiles String[]
     * @return boolean
     */
    public static boolean isDev(String[] profiles) {
        return profiles.length == 0
                || ArrayUtils.contains(profiles, "default")
                || ArrayUtils.contains(profiles, "dev");
    }
}
