package cn.com.demo.mybatis.dao;

import java.util.List;
import java.util.Map;

import cn.com.demo.mybatis.entity.DmPowerItem;

public interface IDmPowerItemDAO {
    public DmPowerItem findById(int id);
    /**
     * keys:
     *   mdId 3
     *   piName
     *   piUrl
     *   piRemark
     * */
    public List<DmPowerItem> findPowerItems(Map<String,Object> map);
    public List<DmPowerItem> findAll();
    
    public void addPowerItem(DmPowerItem item);
    public void updatePowerItem(DmPowerItem item);
    public void deletePowerItem(DmPowerItem item);
}
