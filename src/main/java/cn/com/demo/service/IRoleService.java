package cn.com.demo.service;

import java.util.List;

import cn.com.demo.mybatis.entity.DmModul;
import cn.com.demo.mybatis.entity.DmPowerItem;
import cn.com.demo.mybatis.entity.DmRole;

public interface IRoleService {
    public void addRole(DmRole role);
    public void editRole(DmRole role);
    public void deleteRole(DmRole role);
    
    //保存角色的权限项
    public void saveDeployedPowerItems(int rlId,int[] piIds);
    // 包含权限项--》 调用 IPowerItemService.searchPowerItems方法
    public List<DmModul> searchAllModuls();
    public List<DmPowerItem> searchPowerItemsByRoleId(int rlId);
    /**
     * 通过传入的角色信息查询角色列表
     * 将角色对象封装成map，再调用DAO中的方法
     * */
    public List<DmRole> searchRoles(DmRole role);
    
    public DmRole searchRoleById(int rlId);
}
