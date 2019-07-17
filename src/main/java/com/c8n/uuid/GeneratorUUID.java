package com.c8n.uuid;

import java.util.UUID;

/**
 * Created by dragon on 2019/7/17.
 */
public class GeneratorUUID {

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-", ""));
    }
}
