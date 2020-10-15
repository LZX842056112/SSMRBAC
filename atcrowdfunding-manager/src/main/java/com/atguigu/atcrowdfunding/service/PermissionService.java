package com.atguigu.atcrowdfunding.service;

import com.atguigu.atcrowdfunding.bean.Permission;

import java.util.List;

public interface PermissionService {

	//修改功能
	void updatePermission(Permission permission);

	//根据id查询节点
	Permission queryById(Integer id);

	//新增功能
	void insertPermission(Permission permission);

	// 查询所有的许可数据
	List<Permission> queryAll();

	//获取子节点
	List<Permission> queryChildPermissions(Integer pid);

//	//获取顶级节点
//	Permission queryRootPermission();
}
