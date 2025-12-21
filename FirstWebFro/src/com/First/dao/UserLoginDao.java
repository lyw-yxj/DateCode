package com.First.dao;

import com.First.pojo.user;

import java.util.List;

public interface UserLoginDao {
    public user findUserByUserPwdAndUsername(String name, String pwd);

}
