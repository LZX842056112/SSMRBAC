package com.atguigu.atcrowdfunding.dao;

import com.atguigu.atcrowdfunding.bean.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleDao {

	//查询全部角色
	@Select("select * from t_role")
	List<Role> queryAll();

}
