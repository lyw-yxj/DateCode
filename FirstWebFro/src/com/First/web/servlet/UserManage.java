package com.First.web.servlet;

import com.First.pojo.user;
import com.First.service.UserManageService;
import com.First.service.impl.UserManageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userManager.do")
public class UserManage  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String flag=req.getParameter("flag");
        if("addUser".equals(flag)){

          this.addUser(req,resp);

        }
        else if("findUser".equals(flag)){
            this.findUser(req,resp);

        }else if("selectId".equals(flag)){
            this.selectId(req,resp);
        }else if("updateUser".equals(flag)){
            this.modify(req,resp);
        }

    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp)  throws IOException {
        //调用
        try {
            user u = getUser(req);
            UserManageService in = new UserManageServiceImpl();
            in.AddUserMannage(u);
            //客户跳转,添加用户没有错误，只有可能时系统问题
            resp.sendRedirect("ok.jsp");
        } catch (Exception e) {

            resp.sendRedirect("error.jsp");
            e.printStackTrace();

        }
    }

        //管理用户请求的类
        //一般用户请求的GEt或者post都直接到post来
        //不同的请求内容要分开处理，使用一个函数来操作
        //对于用户没有添加成功处理
         private user  getUser(HttpServletRequest req) {
             //调用
             String userName = req.getParameter("username");
             String userSex = req.getParameter("usersex");
             String userpassword = req.getParameter("userpassword");
             String phoneNummber = req.getParameter("phonenumber");
             String qqnumber = req.getParameter("qqnumber");
             user u=new user();
             u.setQqnumberl(qqnumber);
             u.setPhonenumber(phoneNummber);
             u.setUsername(userName);
             u.setUserpwd(userpassword);
             u.setUsersex(userSex);
             return u;

         }
         private void  findUser(HttpServletRequest req, HttpServletResponse resp){
             //数据应该获取不全，一般不全直接空字符串来传递，所以后期要判别长度
             try {
                 user u = getUser(req);
                 UserManageService in = new UserManageServiceImpl();
                 List<user> list = in.findUser(u);
                 req.setAttribute("list", list);
                 //基于请求转发，来转到该页面中
                 req.getRequestDispatcher("UserManage/viewUser.jsp").forward(req, resp);
             }catch (Exception e)
             {
                 e.printStackTrace();
             }

         }
         private void selectId(HttpServletRequest req,HttpServletResponse resp) throws IOException {

            String id= req.getParameter("id");
             try{
                 UserManageService in = new UserManageServiceImpl();
                 user users = in.selectUserById(Integer.parseInt(id));

                 req.setAttribute("user", users);
                 req.getRequestDispatcher("UserManage/updateUser.jsp").forward(req, resp);
             }catch( Exception e)
             {
                 e.printStackTrace();
                 resp.sendRedirect("error.jsp");
             }



         }
         private void modify(HttpServletRequest req, HttpServletResponse resp) throws IOException {
             String id=req.getParameter("userid");

        try {
                 user u = getUser(req);
                 u.setUserid(Integer.parseInt(id));
                 UserManageService in = new UserManageServiceImpl();
                 in.mofifyUserById(u);

                 resp.sendRedirect("ok.jsp");


             } catch (Exception E) {


                 E.printStackTrace();
                 resp.sendRedirect("error.jsp");
             }
         }
    }
