package com.First.service.impl;

import com.First.Exception.NoUserException;
import com.First.dao.UserLoginDao;
import com.First.dao.impl.UserLoginDaoImpl;
import com.First.pojo.user;
import com.First.service.UserLoginService;

public class UserLoginServiceImpl implements UserLoginService {
//业务层用户处理业务
    @Override
    public user UserLogin(String name, String password) {
        UserLoginDao userLoginDao= new UserLoginDaoImpl();
        user u= userLoginDao.findUserByUserPwdAndUsername(name,password);
        if(u==null){
        throw new NoUserException("用户名或者密码错误");
         //向web抛出问题
        }else{
            //对于是否获得用户，登录只要输入用户名和密码。之后掺入服务器，之后查询是否有该用户，之后返回用户，若是空的则抛出异常

            return u;
        }

    }
}
