package com.atguigu.atcrowdfunding.service;

import com.atguigu.atcrowdfunding.bean.User;

import java.util.List;

public interface UserService {

    public List<User> queryAll();

    /**
     * 查询用户信息
     * @param user
     * @return
     */
    public User query4Login(User user);
}
