package com.c7n.guava;

import com.google.common.base.Strings;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class StringsExample {

    public static void main(String[] args) {
        // pad char
        log.info(Strings.padEnd("foo", 6, 'x'));

        // Always use nullToEmpty for String object.
        log.info(Strings.nullToEmpty(null));
    }
}
