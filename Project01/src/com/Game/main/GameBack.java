package com.Game.main;

import com.Game.util.GameU;
import com.Game.util.newConst;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameBack {
    private BufferedImage bejing;
    //图片背景构造

    public GameBack(){
        //传入参数，
       bejing= GameU.loadImage(newConst.IMG);

    }
    public void  draw(Graphics g)
    {
        g.setColor(newConst.Color);
        g.fillRect(0,0,newConst.Width,newConst.Height);

        int height=bejing.getHeight();
        int weight= bejing.getWidth();
        int count=newConst.Width/weight+1;
        for(int i=0;i<count;i++)
        {
            g.drawImage(bejing,weight*i,newConst.Height-height,null);
        }
    }
}
