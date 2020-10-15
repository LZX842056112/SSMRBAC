package com.atguigu.atcrowdfunding.dao;

import com.atguigu.atcrowdfunding.bean.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {

	// 查询所有的许可数据
	@Select("select * from t_permission")
	List<Permission> queryAll();

	//获取子节点
	@Select("select * from t_permission where pid = #{pid}")
	List<Permission> queryChildPermissions(Integer pid);

//	//获取顶级节点
//	@Select("select * from t_permission where pid is null")
//	Permission queryRootPermission();
}
