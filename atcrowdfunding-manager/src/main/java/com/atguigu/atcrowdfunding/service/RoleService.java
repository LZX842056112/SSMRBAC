package com.atguigu.atcrowdfunding.service;

import com.atguigu.atcrowdfunding.bean.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {

	//分页查询
	List<Role> pageQueryData(Map<String, Object> map);

	//总的数据条数
	int pageQueryCount(Map<String, Object> map);

	//查询全部角色
	List<Role> queryAll();

}
