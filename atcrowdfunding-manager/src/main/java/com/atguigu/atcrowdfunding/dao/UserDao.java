package com.atguigu.atcrowdfunding.dao;

import com.atguigu.atcrowdfunding.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserDao {

    @Select("select * from t_user")
    public List<User> queryAll();

    //查询用户信息
    @Select("select * from t_user where loginacct = #{loginacct} and userpswd = #{userpswd}")
    public User query4Login(User user);

    //分页查询
    List<User> pageQueryData(Map<String, Object> map);

    //总的数据条数
    int pageQueryCount(Map<String, Object> map);

    //添加用户
    void insertUser(User user);

    //回显修改页面
    @Select("select * from t_user where id = #{id}")
    User queryById(Integer id);

    //修改用户
    void updateUser(User user);

    //删除单个用户
    void deleteUserById(Integer id);

    //删除多个用户
    void deleteUsers(Map<String, Object> map);

    //分配角色
    void insertUserRoles(Map<String, Object> map);

    //取消分配角色
    void deleteUserRoles(Map<String, Object> map);

    //查询用户相关联的角色
    @Select("select roleid from t_user_role where userid = #{userid}")
    List<Integer> queryRoleidsByUserid(Integer id);
}