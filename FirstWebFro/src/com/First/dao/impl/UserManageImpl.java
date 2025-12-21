package com.First.dao.impl;

import com.First.common.jdbcUtil;
import com.First.dao.UserManage;
import com.First.pojo.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserManageImpl implements UserManage {


    @Override
    public void AddUserMannage(user users) {

        Connection con=null;
        try{
             con=jdbcUtil.getConnection();
             con.setAutoCommit(false);
                //获得数据库链接对象
            //设置一个非自动提交事务

        PreparedStatement pre= con.prepareStatement("insert  into  users values(default,?,?,?,?,?)");
        pre.setString(1,users.getUsername());
        pre.setString(2,users.getUsersex());
        pre.setString(3,users.getUsersex());
        pre.setString(4,users.getPhonenumber());
        pre.setString(5,users.getQqnumberl());
        pre.execute();
//更新数据
            con.commit();
   //提交事务
        }catch(Exception e)
        {
            e.printStackTrace();


        }finally{
            jdbcUtil.rollback(con);
            //回滚处理，对于提交失败的一起退出
            jdbcUtil.close(con);


        }

    }
// 查找用户
    @Override
    public List<user> FindUserManage(user users) {
        Connection con=null;
        List<user> list=new ArrayList<user>();

        try{
            System.out.println(users.getUsername()+"errrrrrr");
          con=jdbcUtil.getConnection();
           String sql= CreateSQL(users);
            PreparedStatement pre= con.prepareStatement(sql);
            System.out.println("eeeeeeefg");
          ResultSet re= pre.executeQuery();
          System.out.println("eerrr");
          while(re.next())
          {
              System.out.println(re.getString("username"));
              user user1=new user();
             user1.setUserid(re.getInt(1));
             user1.setUsername(re.getString(2));
             user1.setUserpwd(re.getString(3));
             user1.setUsersex(re.getString(4));
             user1.setPhonenumber(re.getString(5));
             user1.setQqnumberl(re.getString(6));
             System.out.println("wwerrrrrrrrrr"+user1.getPhonenumber());
             list.add(user1);

          }
        }catch( Exception e)
        {
            e.printStackTrace();


        }finally{

            jdbcUtil.close(con);
        }
    return list;



    }

    @Override
    public user selectUserById(int id) {

        Connection con=null;
        user user1=null;
        //获得了con
        try{

            con=jdbcUtil.getConnection();
           PreparedStatement pre= con.prepareStatement("select *from users where userid=?");
            pre.setInt(1,id);
            ResultSet r=pre.executeQuery();
            while(r.next())
            {
                user1=new user();
                user1.setUserid(r.getInt(1));
                user1.setUsername(r.getString(2));
                user1.setUserpwd(r.getString(3));
                user1.setUsersex(r.getString(4));
                user1.setPhonenumber(r.getString(5));
                user1.setQqnumberl(r.getString(6));
                System.out.println("wwerrrrrrrrrr"+user1.getPhonenumber());
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            jdbcUtil.close(con);
        }

        return   user1;

    }

    @Override
    public void updateUserById(user users) {
        Connection con=null;
        try{
            con=jdbcUtil.getConnection();
           PreparedStatement pre= con.prepareStatement("UPDATE users SET username=?, usersex=?, phonenumber=?, qqnumber=? WHERE userid=?");
            pre.setString(1,users.getUsername());
            pre.setString(2,users.getUsersex());
            pre.setString(3,users.getPhonenumber());
            pre.setString(4,users.getQqnumberl());
            pre.setInt(5,users.getUserid());
            pre.execute();

        }catch(Exception e)
        {e.printStackTrace();

        }finally{
            jdbcUtil.close(con);

        }
    }

    private String   CreateSQL(user users)
    {
        //
        StringBuffer sql=new StringBuffer("select * from users where 1=1");
        //返回一个string类型
        if(users.getUsername()!=null&&users.getUsername().length()>0)
        {
            sql.append("  and username ="+"'"+users.getUsername()+"'");

        }
        if(users.getUsersex()!=null&&users.getUsersex().length()>0)
        {
            sql.append("  and usersex ="+"'"+users.getUsersex()+"'");
        }
        if(users.getPhonenumber()!=null&&users.getPhonenumber().length()>0)
        {
            sql.append("  and phonenumber ="+"'"+users.getPhonenumber()+"'");
        }
        if(users.getQqnumberl()!=null&&users.getQqnumberl().length()>0)
        {
            sql.append("  and qqnumber ="+"'"+users.getQqnumberl()+"'");
        }
        System.out.println(sql.toString());
return sql.toString();
    }
}
