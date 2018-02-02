package cn.com.demo.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.demo.mybatis.entity.DmRole;
import cn.com.demo.mybatis.entity.DmUser;
import cn.com.demo.service.IUserService;

@Controller
@RequestMapping("/power")
public class UserController {
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	//@RequestMapping("/searchUsers")
    public String searchUsers(ModelMap model){
    	model.addAttribute("userList", this.userService.searchUsers());
    	return "userList";
    }
	@RequestMapping("/addUser")
	public String addUser(DmUser user){
		this.userService.addUser(user);
		return "redirect:/user/searchUsers";
	}
	
	// 正式的方法******************
	@RequestMapping("/initDeployUserRoleFrame")
	public String initDeployUserRoleFrame(){
		
		return "deployUserRoleFrame";
	}
	
	@RequestMapping("/searchUsers")
	public String searchUsers(DmUser user,ModelMap model){
		List<DmUser> userList = this.userService.searchUsers(user.getUrUserName(),user.getUrUserName());
		model.addAttribute("userList", userList);
		return "userList";
	}
	/**
	 * 用户已有的角色集合
	 * 用户没有的角色集合
	 * */
	@RequestMapping("/initDeployRole")
	public String initDeployRole(int urId,ModelMap model){
		DmUser user = this.userService.searchUserById(urId);
		model.addAttribute("user", user);
		List<DmRole> deployedRoles = this.userService.searchDeployedRoles(urId);
		
		List<DmRole> unDeployedRoles = this.userService.searchUndeployedRoles(urId);
		model.addAttribute("deployedRoles", deployedRoles);
		
		model.addAttribute("unDeployedRoles", unDeployedRoles);
		return "newDeployRole";
	}
	
	@RequestMapping("/saveDeployedRoles")
	@ResponseBody// 提示信息
	public String saveDeployedRoles(int urId, int[] rlIds){
		String result = "分配成功";
		try{
		   this.userService.deployUserRoles(urId, rlIds);
		}catch(Exception e){
			e.printStackTrace();
			result = "分配失败";
		}
		
		return result;
	}
}
