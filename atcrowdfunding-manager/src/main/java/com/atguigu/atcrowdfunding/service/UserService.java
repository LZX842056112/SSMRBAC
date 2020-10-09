package com.atguigu.atcrowdfunding.service;

import com.atguigu.atcrowdfunding.bean.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    public List<User> queryAll();

    //查询用户信息
    public User query4Login(User user);

    //分页查询
    List<User> pageQueryData(Map<String, Object> map);

    //总的数据条数
    int pageQueryCount(Map<String, Object> map);
}
