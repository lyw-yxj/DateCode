package com.Game.main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Cloud {
    private BufferedImage img;
    private int speed;
    private  int x,y;
    public Cloud(){

    }

    public Cloud(BufferedImage img, int speed, int x, int y) {
        this.img = img;
        this.speed = speed;
        this.x = x;
        this.y = y;
    }
    public void draw(Graphics d)
    {
        x-=speed;
        d.drawImage(img,x,y,null);

    }
}
