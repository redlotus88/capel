package com.c7n.designPattern.staticProxy;

/**
 * 实际的电影播放对象
 */
public class RealMovie implements Movie {

    @Override
    public void play() {
        System.out.println("您正在观看电影：《泰坦尼克号》");
    }
}
