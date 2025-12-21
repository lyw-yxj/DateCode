package com.First.web.filter;

import com.First.common.Contants;
import com.First.pojo.user;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//过滤一些申请，直接进入filter类，进行判断之后，才会放行输入的浏览器地址，浏览器地址
@WebFilter(urlPatterns = {"*.do","*.jsp"})
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
//此外为了实现可以只可以有同时
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
           String url=request.getRequestURI();
           if(url.indexOf("login.jsp")!=-1||url.indexOf("login.do")!=-1){
               //这里是除了访问登录页面以及登录处理，这样之后才会有数据在httpsession,会出的使用范围是整个项目，所可以直接存储
               filterChain.doFilter(servletRequest, servletResponse);
           }
           else{
               HttpSession session=request.getSession();
               user u=(user) session.getAttribute(Contants.USER_LOGIN);
              if(u==null)
              {
                  request.getRequestDispatcher("login.jsp").forward(request,response);
              }else{
                  filterChain.doFilter(servletRequest, servletResponse);
              }
           }
    }

    @Override
    public void destroy() {

    }
}
