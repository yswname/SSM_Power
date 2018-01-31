package cn.com.demo.service;

import java.util.List;

import cn.com.demo.mybatis.entity.DmModul;
import cn.com.demo.mybatis.entity.DmPowerItem;
import cn.com.demo.mybatis.entity.DmRole;

public interface IRoleService {
    public void addRole(DmRole role);
    public void editRole(DmRole role);
    public void deleteRole(DmRole role);
    
    public void saveDeployedPowerItems(int rlId,int[] piIds);
    // 包含权限项--》 调用 IPowerItemService.searchPowerItems方法
    public List<DmModul> searchAllModuls();
    public List<DmPowerItem> searchPowerItemsByRoleId(int rlId);
    
    public List<DmRole> searchAllRoles();
    public DmRole searchRoleById(int rlId);
}
