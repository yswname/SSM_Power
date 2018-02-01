package cn.com.demo.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.demo.mybatis.entity.DmRole;
import cn.com.demo.service.IRoleService;

@Controller
@RequestMapping(value="/role")
public class RoleController {
	@Autowired
	@Qualifier("roleService")
	private IRoleService roleService;
	
	@RequestMapping(value="/initRole")
    public String initRoleFrame(ModelMap model){
    	String result = "roleFrame";
    	DmRole role = new DmRole();
    	List<DmRole> list = this.roleService.searchRoles(role);
    	model.addAttribute("roleList", list);
    	return result;
    }
    // 查询角色列表
	@RequestMapping(value="/searchRoles")
    public String searchRoles(DmRole role,ModelMap model){
    	String result = "roleList";
    	List<DmRole> list = this.roleService.searchRoles(role);
    	model.addAttribute("roleList", list);
    	return result;
    }
    
    @ResponseBody// json
    @RequestMapping(value="/searchRoleById")
    public DmRole searchRole(int rlId){
    	DmRole role = null;
    	role = this.roleService.searchRoleById(rlId);
    	return role;
    }
    
    @ResponseBody// 提示信息
    @RequestMapping(value="/addRole")
    public String addRole(DmRole role){
    	String result = "添加成功";
    	try {
    		this.roleService.addRole(role);
		} catch (Exception e) {
			 e.printStackTrace();
			 result = "添加失败" + e.getMessage();
		}
    	return result;
    }
    
    @ResponseBody// 提示信息
    @RequestMapping(value="/editRole")
    public String editRole(DmRole role){
    	String result = "修改成功";
    	try {
			this.roleService.editRole(role);
		} catch (Exception e) {
			e.printStackTrace();
			result = "修改失败" + e.getMessage();
		}
    	return result;
    }
    
    @ResponseBody// 提示信息
    @RequestMapping(value="/deleteRole")
    public String deleteRole(DmRole role){
    	String result = "删除成功";
    	try {
			this.roleService.deleteRole(role);
		} catch (Exception e) {
			e.printStackTrace();
			result = "删除失败" + e.getMessage();
		}
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
