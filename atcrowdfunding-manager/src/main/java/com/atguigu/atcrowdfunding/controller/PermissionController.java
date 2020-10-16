package com.atguigu.atcrowdfunding.controller;

import com.atguigu.atcrowdfunding.bean.AJAXResult;
import com.atguigu.atcrowdfunding.bean.Permission;
import com.atguigu.atcrowdfunding.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired(required = false)
    private PermissionService permissionService;

    //回显分配许可
    @ResponseBody
    @RequestMapping("/loadAssignData")
    public Object loadAssignData( Integer roleid ) {
        List<Permission> permissions = new ArrayList<Permission>();
        List<Permission> ps = permissionService.queryAll();
        // 获取当前角色已经分配的许可信息
        List<Integer> permissionids = permissionService.queryPermissionidsByRoleid(roleid);
        Map<Integer, Permission> permissionMap = new HashMap<Integer, Permission>();
        for (Permission p : ps) {
            if ( permissionids.contains(p.getId()) ) {
                p.setChecked(true);
            } else {
                p.setChecked(false);
            }
            permissionMap.put(p.getId(), p);
        }
        for ( Permission p : ps ) {
            Permission child = p;
            if ( child.getPid() == 0 ) {
                permissions.add(p);
            } else {
                Permission parent = permissionMap.get(child.getPid());
                parent.getChildren().add(child);
            }
        }
        return permissions;
    }

    //删除功能
    @ResponseBody
    @RequestMapping("/delete")
    public Object delete( Permission permission ) {
        AJAXResult result = new AJAXResult();
        try {
            permissionService.deletePermission(permission);
            result.setSuccess(true);
        } catch ( Exception e ) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    //修改功能
    @ResponseBody
    @RequestMapping("/update")
    public Object update( Permission permission ) {
        AJAXResult result = new AJAXResult();
        try {
            permissionService.updatePermission(permission);
            result.setSuccess(true);
        } catch ( Exception e ) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    //修改页面
    @RequestMapping("/edit")
    public String edit( Integer id, Model model ) {
        Permission permission = permissionService.queryById(id);
        model.addAttribute("permission", permission);
        return "permission/edit";
    }

    //新增功能
    @ResponseBody
    @RequestMapping("/insert")
    public Object insert( Permission permission ) {
        AJAXResult result = new AJAXResult();
        try {
            permissionService.insertPermission(permission);
            result.setSuccess(true);
        } catch ( Exception e ) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    //新增页面
    @RequestMapping("/add")
    public String add() {
        return "permission/add";
    }

    /**
     * 递归查询许可信息
     * 1） 方法自己调用自己
     * 2）方法一定要存在跳出逻辑
     * 3）方法调用时，参数之间应该有规律
     * 4） 递归算法，效率比较低
     */
    private void queryChildPermissions( Permission parent ) {
        List<Permission> childPermissions = permissionService.queryChildPermissions(parent.getId());
        for ( Permission permission : childPermissions ) {
            queryChildPermissions(permission);
        }
        parent.setChildren(childPermissions);
    }

    @ResponseBody
    @RequestMapping("/loadData")
    public Object loadData() {
        List<Permission> permissions = new ArrayList<Permission>();
        // 查询所有的许可数据
        List<Permission> ps = permissionService.queryAll();
        Map<Integer, Permission> permissionMap = new HashMap<Integer, Permission>();
        for (Permission p : ps) {
            permissionMap.put(p.getId(), p);
        }
        for ( Permission p : ps ) {
            Permission child = p;
            if ( child.getPid() == 0 ) {
                permissions.add(p);
            } else {
                Permission parent = permissionMap.get(child.getPid());
                parent.getChildren().add(child);
            }
        }
        return permissions;

//        List<Permission> permissions = new ArrayList<Permission>();
//		// 读取树形结构数据
//		//获取顶级节点
//		Permission root = permissionService.queryRootPermission();
//		//获取子节点
//		List<Permission> childPermissions = permissionService.queryChildPermissions(root.getId());
//		for ( Permission childPermission : childPermissions ) {
//			List<Permission> childChildPermissions = permissionService.queryChildPermissions(childPermission.getId());
//			childPermission.setChildren(childChildPermissions);
//		}
//		root.setChildren(childPermissions);
//		permissions.add(root);

//        // 递归查询数据
//		Permission parent = new Permission();
//		parent.setId(0);
//		queryChildPermissions(parent);
//		return parent.getChildren();

//        //嵌套for循环
//        List<Permission> permissions = new ArrayList<Permission>();
//        // 查询所有的许可数据
//        List<Permission> ps = permissionService.queryAll();
//        for ( Permission p : ps ) {
//            // 子节点
//            Permission child = p;
//            if ( p.getPid() == 0 ) {
//                permissions.add(p);
//            } else {
//                for ( Permission innerPermission : ps ) {
//                    if ( child.getPid().equals(innerPermission.getId()) ) {
//                        // 父节点
//                        Permission parent = innerPermission;
//                        // 组合父子节点的关系
//                        parent.getChildren().add(child);
//                        break;
//                    }
//                }
//            }
//        }
//        return permissions;
    }

    @RequestMapping("/index")
	public String index() {
		return "permission/index";
	}

}
