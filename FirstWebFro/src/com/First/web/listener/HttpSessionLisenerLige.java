package com.First.web.listener;

import com.First.common.Contants;
import com.First.pojo.user;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionLisenerLige implements HttpSessionListener {


    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        //当同一个浏览器端该session对象要销毁时，监听
           HttpSession session= httpSessionEvent.getSession();
        //获得session对象,使用的是servletContext来处理，主要目的是销毁servletContext中的记录
        //
          ServletContext contextin= session.getServletContext();
           user us  =(user)session.getAttribute(Contants.USER_LOGIN);
       //获得用户
        contextin.removeAttribute(Contants.USER_LOGIN);

    }
}
