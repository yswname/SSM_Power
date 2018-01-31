package cn.com.demo.mybatis.dao;

import java.util.List;
import java.util.Set;

import cn.com.demo.mybatis.entity.DmUser;

public interface IDmUserDAO {
     public DmUser findById(int id);
     public Set<DmUser> findUsersByRoleId(int id);
     public void save(DmUser user);
     public List<DmUser> findAll();
}
