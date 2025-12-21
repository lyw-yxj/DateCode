package com.First.dao;

import com.First.pojo.user;

import java.util.List;

public interface UserManage {

    //事务处理类
    void AddUserMannage(user users);
    List<user>FindUserManage(user users);
    user selectUserById(int id);
    void updateUserById(user users);






}
