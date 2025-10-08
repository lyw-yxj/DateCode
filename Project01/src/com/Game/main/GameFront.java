package com.Game.main;

import com.Game.util.GameU;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameFront {
    //前景类
    private static int NUM=2;
    private List<Cloud> cloudList;
    //list容器
    private static final int speed=8;
    private Random r;
    private BufferedImage[]img;
    public GameFront(){
        cloudList=new ArrayList<>();
        //多态存入云彩图片
        img=new BufferedImage[NUM];
        for(int i=0;i<NUM;i++)
        {
            img[i]= GameU.loadImage("img\\cloud"+i+".png");

        }
       r=new Random();
    }
    public void logic(){
    if((int)(500*Math.random())<5){
        System.out.println("tianjia");
     Cloud d = new Cloud(img[r.nextInt(NUM)], speed, 600, r.nextInt(150));
     cloudList.add(d);
     System.out.println("kuanfu");
      }
    System.out.println("dffff");
    }
    //每次云彩移动的速度一致，x位置发生改变，y位置随机，每次判断条件将云朵添加进入云朵池，每次运行画出云朵均会调用一次draw方法，将云朵全部画出，之后再次添加再次画出
    public void draw(Graphics f)
    {
       logic();
System.out.println("diaoong");
        for(int i=0;i<cloudList.size();i++)
        {
            cloudList.get(i).draw(f);
            System.out.println();
        }
    }

}
