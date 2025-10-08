package com.Game.main;

import com.Game.util.newConst;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

public class GameFrame extends Frame {
    //实例化
    private GameBack newBack;
    //鸟实例化
    private Bird bd;
    //前景类
    private GameFront hj;
    //障碍物层
    private BarrierBack bh;
    //存放图片
    private BufferedImage buffing =new BufferedImage(newConst.Width,newConst.Height,BufferedImage.TYPE_4BYTE_ABGR);
    public GameFrame(){
        setVisible(true);
        //设置是否可见
        setSize(newConst.Width,newConst.Height);
        //设置大小
        setTitle(newConst.Title);
        //设置标题
        setLocation(newConst.x,newConst.y);
        //不可改变
        setResizable(false);
        //关闭事件
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);

            }
        }) ;

     init();
    new run().start();
    addKeyListener(new KeyAdapter() {


        @Override
        public void keyPressed(KeyEvent e) {
            add(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
           minu(e);
        }
    });
    }
public void init(){
        newBack=new GameBack();
        bd=new Bird();
        hj=new GameFront();
        bh=new BarrierBack();
    }
class run extends Thread{
    @Override
    public void run() {
        while(true) {
            repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public void update(Graphics s)
{
    if(bd.life==true) {


        //调用画布的画笔
        Graphics df = buffing.getGraphics();
        newBack.draw(df);
        bd.draw(df);
        hj.draw(df);
        bh.draw(df, bd);
        s.drawImage(buffing, 0, 0, null);
    }
    else{
        String over="游戏结束";
        s.setColor(Color.red);
        s.setFont(new Font("微软雅黑",1,60));
        s.drawString(over,300,300);
    }
}
public void add(KeyEvent e)
{
    switch ((e.getKeyCode()))
    {
        case KeyEvent.VK_UP:
            bd.fly(1);
            System.out.println("shang1");
             break;

    }
}
public void minu(KeyEvent e)
{
    switch ((e.getKeyCode()))
    {
        case KeyEvent.VK_UP:
            bd.fly(5);
            System.out.println("df");
            break;

    }

}

    }
