package com.Game.main;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BarrierBack {
    private List<Barrier> b;

    Random f=new Random();
    public BarrierBack(){
       b= new ArrayList<>();

    }
    public void draw(Graphics d,Bird bird)
    {

        for(int i=0;i<b.size();i++)
        {
            Barrier df=b.get(i);
            df.draw(d);

        }
        bum(bird);
     lo();
    }
    public void lo(){
        if(b.size()==0)
        {
            ran();
            Barrier top=new Barrier(600,0,TOP,0);
            b.add(top);
            Barrier down=new Barrier(600,500-DOWN,DOWN,2);
            b.add(down);
        }
        else{
            //判断
         Barrier last=  b.get(b.size()-1);
         if(last.isF()){
             ran();
              Barrier top=new Barrier(600,0,TOP,0);
             b.add(top);
             Barrier down=new Barrier(600,500-DOWN,DOWN,2);
             b.add(down);
         }
        }
    }
    //上方障碍物高度
    private int TOP;
    private int DOWN;
    public void ran(){
        TOP=f.nextInt(400)+100;
        DOWN=f.nextInt(400)+100;
        //重合
        if(TOP+DOWN>450)
        {
            ran();
        }
    }
    public boolean bum(Bird bd)
    {
        for(int i=0;i<b.size();i++)
        {
            Barrier d=b.get(i);
            if(d.tangle().intersects((bd.getRet())))
            {
                System.out.println("撞上");
                bd.life=false;
        }
        }
        return false;
    }
}
