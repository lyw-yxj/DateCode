package com.Game.main;

import com.Game.util.GameU;
import com.Game.util.newConst;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bird {
    private Rectangle ret;
    //小鸟图片
    private BufferedImage[]images;
    private static final int count=3;
    //小鸟状态
    private int state;
    public boolean life=true;
    public static final int normal=0;
    public static final int up=1;
    public static final int down=2;
    //移动的方向
    public  boolean updf=false;
    public  boolean downdf=false;
    private int speed=4;
    public  int  x=200,y=200;
     public  Bird(){
        images=new BufferedImage[count];
        for(int i=0;i<count;i++)
        {
            images[i]= GameU.loadImage(newConst.Image[i]);
        }
        int w=images[0].getHeight();
        int d=images[0].getWidth();
        ret=new Rectangle(d,w);
     }
    public void flyLogic(){
        if(updf)
        {
            y-=speed;
            System.out.println(y);
            if(y<30)
                y=30;
        }
        if (!updf){
            y+=speed; System.out.println(y);
            if(y>475)
                y=475;
        }
    }
    public void draw(Graphics g)
    {
        flyLogic();
        System.out.println("O");
        g.drawImage(images[state],x,y,null);
      //  g.drawRect(x,y,(int)ret.getWidth(),(int)ret.getHeight());
        ret.x=x;
        ret.y=y;

    }

    public void fly(int fly)
    {
        switch (fly){
            case 1:
                state=1;
                updf=true;
                downdf=false;
     System.out.println("cz");
                break;
            case 5:
                state=2;
                updf=false;
                System.out.println("cv");
                break;
        }
    }
    public Rectangle getRet()
    {
        return ret;
    }
}
