package cn.com.demo.mybatis.dao;

import java.util.List;

import cn.com.demo.mybatis.entity.DmPowerItem;

public interface IDmPowerItemDAO {
    public DmPowerItem findById(int id);
    public DmPowerItem findById2(int id);
    public List<DmPowerItem> findAll();
}
