package cn.com.demo.mvc.controller;

import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.demo.mybatis.entity.DmPowerItem;

public class PowerItemController {
	/**
	 * 获取所有的modul集合，返回到powerItemFrame.jsp
	 * */
    public String initPowerItemFrame(){
    	String result = "powerItemFrame";
    	return result;
    }
    /**
     * 查询所有的权限项（Modul集合中包含PowerItem）
     * 
     * powerItem为null或者所有属性值为初始值，就查询所有
     * 否则就根据非数值的属性做条件查询
     * */
    public String searchPowerItems(DmPowerItem powerItem){
    	String result = "powerItemList";
    	return result;
    }
    
    @ResponseBody
    public String addPowerItem(DmPowerItem powerItem){
    	String result = "添加成功";
    	return result;
    }
    @ResponseBody// json
    public DmPowerItem searchPowerItem(int piId){
    	DmPowerItem item = null;
    	return item;
    }
    
    @ResponseBody
    public String editPowerItem(DmPowerItem powerItem){
    	String result = "修改成功";
    	return result;
    }
    
    @ResponseBody
    public String deletePowerItem(DmPowerItem powerItem){
    	String result = "删除成功";
    	return result;
    }
}
