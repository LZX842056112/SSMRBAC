package com.atguigu.atcrowdfunding.service.impl;

import com.atguigu.atcrowdfunding.bean.Permission;
import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.dao.PermissionDao;
import com.atguigu.atcrowdfunding.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired(required = false)
	private PermissionDao permissionDao;

	// 获取用户权限信息
	public List<Permission> queryPermissionsByUser(User dbUser) {
		return permissionDao.queryPermissionsByUser(dbUser);
	}

	// 获取当前角色已经分配的许可信息
	public List<Integer> queryPermissionidsByRoleid(Integer roleid) {
		return permissionDao.queryPermissionidsByRoleid(roleid);
	}

	//删除功能
	public void deletePermission(Permission permission) {
		permissionDao.deletePermission(permission);
	}

	//修改功能
	public void updatePermission(Permission permission) {
		permissionDao.updatePermission(permission);
	}

	//根据id查询节点
	public Permission queryById(Integer id) {
		return permissionDao.queryById(id);
	}

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
