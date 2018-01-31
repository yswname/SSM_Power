package cn.com.demo.mybatis.dao;

import java.util.Set;

import cn.com.demo.mybatis.entity.DmOrder;

public interface IDmOrderDAO {
    public DmOrder findById(int id);
    public Set<DmOrder> findOrdersByUserId(int urId);
}
