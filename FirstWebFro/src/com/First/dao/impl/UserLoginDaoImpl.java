package com.First.dao.impl;

import com.First.common.jdbcUtil;
import com.First.dao.UserLoginDao;
import com.First.pojo.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginDaoImpl implements UserLoginDao {
    //用户登录页面，返回一个user
    public user findUserByUserPwdAndUsername(String name, String pwd)  {
        Connection cn=null;
        user u=null;

        try {
            cn = jdbcUtil.getConnection();
            String sql = "select * from users where username=? and userpwd=?";
            PreparedStatement pre = cn.prepareStatement(sql);
            pre.setString(1,name);
         pre.setString(2,pwd);
            ResultSet rs=pre.executeQuery();
            System.out.println("errr");
            //返回的数据集
            while(rs.next())
            {   u=new user();
                System.out.println(rs.getString("username"));
                u.setUserid(rs.getInt(1));
                 u.setUsername(rs.getString(2));
                 u.setUserpwd(rs.getString(3));
                 u.setUsersex(rs.getString(4));
                 u.setPhonenumber(rs.getString(5));
                 u.setQqnumberl(rs.getString(6));
                System.out.println(u.getUsername());

            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            jdbcUtil.close(cn);


        }



return u;


    }

}
