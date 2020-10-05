package com.atguigu.atcrowdfunding.dao;

import com.atguigu.atcrowdfunding.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    @Select("select * from t_user")
    public List<User> queryAll();

    /**
     * 查询用户信息
     * @param user
     * @return
     */
    @Select("select * from t_user where loginacct = #{loginacct} and userpswd = #{userpswd}")
    public User query4Login(User user);
}
