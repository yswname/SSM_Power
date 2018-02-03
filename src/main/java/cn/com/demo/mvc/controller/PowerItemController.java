package cn.com.demo.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.demo.mybatis.entity.DmModul;
import cn.com.demo.mybatis.entity.DmPowerItem;
import cn.com.demo.service.IPowerItemService;
@Controller
@RequestMapping("/power")
public class PowerItemController {
	@Autowired
	@Qualifier("IPowerItemService")
	private IPowerItemService ipservice;
	/**
	 * 获取所有的modul集合，返回到powerItemFrame.jsp
	 * */
	@RequestMapping(value="/initPowerItem")
    public String initPowerItemFrame(ModelMap model){
    	String result = "powerItemFrame";
    	List<DmModul> modulList = this.ipservice.searchAllModuls();
    	model.addAttribute("modulList", modulList);
    	return result;
    }
    /**
     * 查询所有的权限项（Modul集合中包含PowerItem）
     * 
     * powerItem为null或者所有属性值为初始值，就查询所有
     * 否则就根据非数值的属性做条件查询
     * */
	@RequestMapping("/searchPowerItem")
    public String searchPowerItems(DmPowerItem powerItem,ModelMap model){
    	String result = "powerItemList";
    	List<DmModul> modulList = this.ipservice.searchPowerItems(powerItem);
    	model.addAttribute("modulList", modulList);
    	return result;
    }
    
    @ResponseBody
    public String addPowerItem(DmPowerItem powerItem){
    	String result = "添加成功";
    	try {
    		this.ipservice.addPowerItem(powerItem);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("添加失败！");
		}
    	
    	return result;
    }
    @ResponseBody// json
    public DmPowerItem searchPowerItem(int piId){
    	DmPowerItem item = null;
    	item = this.ipservice.searchPowerItemById(piId);
    	return item;
    }
    
    @ResponseBody
    public String editPowerItem(DmPowerItem powerItem){
    	String result = "修改成功";
    	try{
    		this.ipservice.editPowerItem(powerItem);
    	}catch(Exception e){
    		throw new RuntimeException("修改失败");
    	}
    	return result;
    }
    
    @ResponseBody
    public String deletePowerItem(DmPowerItem powerItem){
    	String result = "删除成功";
    	try{
    	this.ipservice.deletePowerItem(powerItem);
    	}catch(Exception e){
    		throw new RuntimeException("删除失败");
    	}
    	return result;
    }
}
