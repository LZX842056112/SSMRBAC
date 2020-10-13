package com.atguigu.atcrowdfunding.dao;

import com.atguigu.atcrowdfunding.bean.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface RoleDao {

	//分页查询
	List<Role> pageQueryData(Map<String, Object> map);

	//总的数据条数
	int pageQueryCount(Map<String, Object> map);

	//查询全部角色
	@Select("select * from t_role")
	List<Role> queryAll();

}
