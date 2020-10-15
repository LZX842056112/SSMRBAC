package com.atguigu.atcrowdfunding.service.impl;

import com.atguigu.atcrowdfunding.bean.Permission;
import com.atguigu.atcrowdfunding.dao.PermissionDao;
import com.atguigu.atcrowdfunding.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired(required = false)
	private PermissionDao permissionDao;

	//新增功能
	public void insertPermission(Permission permission) {
		permissionDao.insertPermission(permission);
	}

	// 查询所有的许可数据
	public List<Permission> queryAll() {
		return permissionDao.queryAll();
	}

	//获取子节点
	public List<Permission> queryChildPermissions(Integer pid) {
		return permissionDao.queryChildPermissions(pid);
	}

//	//获取顶级节点
//	public Permission queryRootPermission() {
//		return permissionDao.queryRootPermission();
//	}
}
