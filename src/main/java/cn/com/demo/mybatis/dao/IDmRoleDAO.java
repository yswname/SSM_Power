package cn.com.demo.mybatis.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.com.demo.mybatis.entity.DmPowerItem;
import cn.com.demo.mybatis.entity.DmRole;

public interface IDmRoleDAO {
    public DmRole findById(int id);
    public List<DmRole> findAll();
    public void save(DmRole role);
    public void update(DmRole role);
    public void delete(DmRole role);
    /**
     * 移除指定角色的所有权限项
     * */
    public void removePowerItemsByRoleId(int rlId);
    /**
     * keys:
     *   rlId
     *   piId
     * */
    public void deployPowerItem(Map<String,Integer> map);
    // 查询出角色的所有权限项
    public List<DmPowerItem> findPowerItemsByRoleId(int rlId);
    
    
    public Set<DmRole> findRolesByUserId(int urId);
}
