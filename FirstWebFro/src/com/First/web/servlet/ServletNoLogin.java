package com.First.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout.do")
public class ServletNoLogin extends HttpServlet {
//这里退出登录要注意原先注册的信息：servletContext对象需要手动销毁，一般在项目停止时才会停止，但是HttpSession对象不需要，因为一般可以tomcat来消除，httpSession


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session =req.getSession();
        session.invalidate();
        //销毁sesison
        resp.sendRedirect("login.jsp");

         //发送重定向

    }


}
