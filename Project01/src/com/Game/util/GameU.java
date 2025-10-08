package com.Game.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class GameU {
    //加载图片,静态方法，返回BufferedImage类
    public static BufferedImage loadImage(String path)
    {
        try {
            return ImageIO.read(new FileInputStream(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
