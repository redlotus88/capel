package com.c7n.graph;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;

/**
 * 缩略图生成
 *
 * 使用java库
 *  - net.coobird.thumbnailator
 *  GITHUB: https://github.com/coobird/thumbnailator
 */
public class ThumbGenrator {

    public static void main(String[] args) throws IOException {
        File picPath = new File("/Users/dragon/Desktop/衣服尺码.jpeg");
        Thumbnails.of(picPath).size(600,480).outputFormat("jpg").toFile("tmp/thumbnails_");

    }

}
