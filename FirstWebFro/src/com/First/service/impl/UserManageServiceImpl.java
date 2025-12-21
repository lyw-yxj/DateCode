package com.First.service.impl;

import com.First.dao.UserManage;
import com.First.dao.impl.UserManageImpl;
import com.First.pojo.user;
import com.First.service.UserManageService;

import java.util.List;

public class UserManageServiceImpl  implements UserManageService {

    @Override
    public void AddUserMannage(user users) {
        UserManage add=new UserManageImpl();
        add.AddUserMannage(users);

    }

    @Override
    public List<user> findUser(user users) {
        UserManage add=new UserManageImpl();
       return  add.FindUserManage(users);
    }
    public user selectUserById(int id)
    {
        UserManage add=new UserManageImpl();
        return add.selectUserById(id);
    }

    @Override
    public void mofifyUserById(user user) {
        UserManage add=new UserManageImpl();
        add.updateUserById(user);
    }
}
