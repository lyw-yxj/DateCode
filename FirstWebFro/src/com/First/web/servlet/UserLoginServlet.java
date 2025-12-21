package com.First.web.servlet;

import com.First.Exception.NoUserException;
import com.First.common.Contants;
import com.First.pojo.user;
import com.First.service.UserLoginService;
import com.First.service.impl.UserLoginServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login.do")
public class UserLoginServlet extends HttpServlet {
        //这里用户只要登录一个登录页面，之后表单提交到对应的servlet中，servlet会根据给定的数据，之后跳转到其他的页面，获得返回值
        //重定向，则浏览器的地址栏需要变化，换到了主页面
        //请求转发，地址栏没有变化，只是内部请求，应为登陆不成功就要回到原登录页，在地址栏不变化
        //这里要标记一下会话，之后可以从session中获得信息，而且标记一登陆

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String username=req.getParameter("username");
    String password=req.getParameter("userpwd");
    //数据的获得
        try {
            System.out.println(password);
            UserLoginService userLoginService = new UserLoginServiceImpl();
            user u = userLoginService.UserLogin(username, password);

            //会话处理，记录获得的用户信息，主要是用于会话拦截，对于httpservlet可以用户是或否登录
           System.out.println(u);
            HttpSession session = req.getSession();
            session.setAttribute(Contants.USER_LOGIN, u);
            //设置servletContext可以实现在一个tomcat中都可以访问到键值对，用于限制用户只可以在一处登录
            ServletContext application =this.getServletContext();
             HttpSession in=(HttpSession) application.getAttribute(u.getUserid()+"");
             //替换当前的地址
            if(in!=null){
                System.out.println("ooooook");
                application.removeAttribute(u.getUserid()+"");
                //这里是移出缓存中数据，而且数据从
                in.invalidate();
                //销毁session
                //超时会导致销毁两次，lion

            }
                application.setAttribute(u.getUserid()+"",session);

//将当前的用户信息直接放在，
            //记录用户信息，如果是没有找到用户则存储的信息是null
            resp.sendRedirect("main.jsp");
            //数据的输入
//异常处理对于没有用户的话，直接抛异常到这里
        }catch(NoUserException e) {
            req.setAttribute("msg", e.getMessage());
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }catch(Exception e) {
            resp.sendRedirect("error.jsp");

        }
    }
    }

