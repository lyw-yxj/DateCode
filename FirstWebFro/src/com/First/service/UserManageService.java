package com.First.service;

import com.First.pojo.user;

import java.util.List;

public interface UserManageService {

    //用户增加的业务层
    void AddUserMannage(user users);
    List<user> findUser(user users);
    user selectUserById(int id);
    void mofifyUserById(user user);
}
