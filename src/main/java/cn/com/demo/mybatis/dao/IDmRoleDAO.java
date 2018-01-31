package cn.com.demo.mybatis.dao;

import java.util.Set;

import cn.com.demo.mybatis.entity.DmRole;

public interface IDmRoleDAO {
    public DmRole findById(int id);
    public Set<DmRole> findRolesByUserId(int urId);
}
