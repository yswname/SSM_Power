package cn.com.demo.service;

import java.util.List;

import cn.com.demo.mybatis.entity.DmModul;
import cn.com.demo.mybatis.entity.DmPowerItem;

public interface IPowerItemService {
    public List<DmModul> searchAllModuls();
    public List<DmModul> searchPowerItems(DmPowerItem powerItem);
    public DmPowerItem searchPowerItemById(int piId);
    public void addPowerItem(DmPowerItem item);
    public void editPowerItem(DmPowerItem item);
    public void deletePowerItem(DmPowerItem item);
}
