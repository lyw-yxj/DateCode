package com.First.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcUtil {
    //封装建立数据库链接的方法
  public static String  driver=null;
    public   static String password=null;
    public  static String username=null;
    public  static String url=null;
    static {
        try {
       InputStream in= jdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
       //导入输入流
        Properties prop=new Properties();
        prop.load(in);
        driver= prop.getProperty("driverClassName");
        username=  prop.getProperty("username");
      password= prop.getProperty("password");
       url= prop.getProperty("url");
        Class.forName(driver);
        //注册数据库的驱动器，用于翻译，这里使用的是mysql的驱动器
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection(){
        Connection co=null;
        //获得了连接器
        try {
            co= DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return co;
    }
    public static void close(Connection co){
        try {
            co.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



    public static void rollback(Connection con)
    {
        try {
            con.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
