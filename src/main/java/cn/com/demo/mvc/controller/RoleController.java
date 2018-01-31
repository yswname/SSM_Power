package cn.com.demo.mvc.controller;

import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.demo.mybatis.entity.DmRole;

public class RoleController {
    public String initRoleFrame(){
    	String result = "roleFrame";
    	return result;
    }
    // 查询角色列表
    public String searchRoles(DmRole role){
    	String result = "roleList";
    	return result;
    }
    
    @ResponseBody// json
    public DmRole searchRole(int rlId){
    	DmRole role = null;
    	return role;
    }
    @ResponseBody// 提示信息
    public String addRole(DmRole role){
    	String result = "添加成功";
    	return result;
    }
    @ResponseBody// 提示信息
    public String editRole(DmRole role){
    	String result = "修改成功";
    	return result;
    }
    @ResponseBody// 提示信息
    public String deleteRole(DmRole role){
    	String result = "删除成功";
    	return result;
    }
    /**
     * 包含有所有权限项的Modul List
     * 当前角色所拥有的权限项的集合
     * */
    public String initDeployPowerItem(int rlId){
    	String result = "deployList";
    	return result;
    }
    
    @ResponseBody// 提示信息
    public String deployPowerItem(int rlId, int[] piIds){
    	String result = "分配成功";
    	return result;
    }
}
