package com.c7n.graph;

import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;

/**
 * 根据一张给定的图片，生成该图片的九宫格图片。
 *
 * 使用java库：
 *  -
 *
 * 定义序号如下：
 * 1 2 3
 * 4 5 6
 * 7 8 9
 */
@Log4j2
public class JiuGongGeGenerator {

    public static int serialNo = 1;

    public static void main(String[] args) throws IOException {
        File picPath = new File("/Users/dragon/Desktop/衣服尺码.jpeg");
        generate(picPath, "tmp/");
    }

    public static void generate(File picPath, String dest) throws IOException {
        File destDirectory = new File(dest);
        if (destDirectory.isDirectory()) {
            cut(picPath, dest, 3, 3);
        } else {
            log.error("不存在指定路径: {}", dest);
        }
    }

    /**
     * 图像切割（指定切片的行数和列数）
     * @param srcImageFile 源图像地址
     * @param descDir 切片目标文件夹
     * @param rows 目标切片行数。
     * @param cols 目标切片列数。
     */
    public static void cut(File srcImageFile, String descDir, int rows, int cols) throws IOException {
        BufferedImage bi = ImageIO.read(srcImageFile);
        int srcHeight = bi.getHeight();
        int srcWidth = bi.getWidth();

        if (srcWidth > rows && srcHeight > cols) {
            Image img;
            ImageFilter cropFilter;
            Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);

            int destWidth = srcWidth;
            int destHeight = srcHeight;

            if (srcWidth % cols == 0) {
                destWidth = srcWidth / cols;
            } else {
                destWidth = (int) Math.floor(Double.parseDouble(Integer.toString(srcWidth)) / cols) + 1;
            }

            if (srcHeight % rows == 0) {
                destHeight = srcHeight / rows;
            } else {
                destHeight = (int) Math.floor(Double.parseDouble(Integer.toString(srcHeight)) / rows) + 1;
            }

            // 循环建立切片
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    // 四个参数分别为图像起点坐标和宽高
                    // 即: CropImageFilter(int x,int y,int width,int height)
                    cropFilter = new CropImageFilter(j * destWidth, i * destHeight,
                            destWidth, destHeight);
                    img = Toolkit.getDefaultToolkit().createImage(
                            new FilteredImageSource(image.getSource(),
                                    cropFilter));
                    BufferedImage tag = new BufferedImage(destWidth,
                            destHeight, BufferedImage.TYPE_INT_RGB);
                    Graphics g = tag.getGraphics();
                    g.drawImage(img, 0, 0, null); // 绘制缩小后的图
                    g.dispose();
                    // 输出为文件
                    ImageIO.write(tag, "JPEG", new File(descDir
                            + "_r" + i + "_c" + j + ".jpg"));
                }
            }
        }
    }
}
