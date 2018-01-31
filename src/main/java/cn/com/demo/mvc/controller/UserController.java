package cn.com.demo.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.demo.mybatis.entity.DmUser;
import cn.com.demo.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@RequestMapping("/searchUsers")
    public String searchUsers(ModelMap model){
    	model.addAttribute("userList", this.userService.searchUsers());
    	return "userList";
    }
	@RequestMapping("/addUser")
	public String addUser(DmUser user){
		this.userService.addUser(user);
		return "redirect:/user/searchUsers";
	}
}
