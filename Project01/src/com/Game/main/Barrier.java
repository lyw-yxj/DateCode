package com.Game.main;

import com.Game.util.GameU;
import com.Game.util.newConst;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Barrier {
    //障碍物类
    private static BufferedImage[] im;
    //初始化参数,只需要生成一次云朵参数
    static{
        final int COUNT=3;
        im=new BufferedImage[COUNT];
        for(int i=0;i<COUNT;i++)
        {
            im[i]= GameU.loadImage(newConst.barr[i]);

        }
    }
private Rectangle df;
    private int speed=3;
    private int x,y;
    private int width,height;
    private int type;
    //障碍物状态
    public static final int nomal=4;
    public static final int up=0 ;
    public static final int down=2;
    //获得障碍物宽度和高度
    public static final  int  bwidth1=im[0].getWidth();
    public static final  int  bheight1=im[0].getHeight();
    public static final  int  bwidth2=im[1].getWidth();
    public static final  int  bheight2=im[1].getHeight();




    public Barrier(){}

    public Barrier(int x, int y, int height, int type) {
        this.x = x;
        this.y = y;
        this.width =bwidth1;
        this.height = height;
        this.type =type;
        df=new Rectangle();
    }
    public void draw(Graphics s)
    {
        switch(type)
        {
            case up:
                updraw(s);
                break;
            case down:
                downdraw(s);
                break;
        }
    }
    public void rect(Graphics d)
    {
        int x1=this.x;
        int y1=this.y;
       int w1=im[0].getWidth();
     //  d.setColor(Color.white);
      // d.drawRect(x1,y1,w1,height);
       setRecyangle(x1,y1,height,w1);
    }
    //碰撞矩形
    public void setRecyangle(int x,int y,int height1,int width1)
    {
        df.x=x;
        df.y=y;
    df.width=width1;
    df.height=height1;
    }
    public void drawc(Graphics d)
    {
        downdraw(d);
        updraw(d);
    }
    //绘制从上到下的障碍物
    public void updraw(Graphics f)
    {
        //快数,总障碍物层高度-头高度，
        int count=(height-bheight2)/bheight1+1;
        for(int i=0;i<count;i++)
        {
            f.drawImage(im[0],x,y+i*bheight1,null);

        }
        //绘制头
        int y=height-bheight2;
        //衔接头部
        f.drawImage(im[2],x-(bwidth2-bwidth1)/2,y,null);
       x-=speed;
       rect(f);
    }
    //绘制从下到上的障碍物
   public void downdraw(Graphics d)
    {
        int count=height/bheight1+1;
        for(int i=0;i<count;i++)
        {
            d.drawImage(im[0],x,newConst.Height-i*bheight1,null);
        }
     int y=newConst.Height-height;
        d.drawImage(im[1],x-(bwidth2-bwidth1)/2,y,null);

    x-=speed;
    rect(d);
    }
    //判断何时绘制下一组
    public  boolean isF() {
        return 600 - x > 150;
    }
    public Rectangle tangle(){
        return df;
    }
}
