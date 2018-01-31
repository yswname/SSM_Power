package cn.com.demo.mybatis.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.com.demo.mybatis.entity.DmRole;
import cn.com.demo.mybatis.entity.DmUser;

public interface IDmUserDAO {
     public DmUser findById(int id);
     public Set<DmUser> findUsersByRoleId(int id);
     public void save(DmUser user);
     public List<DmUser> findAll();
     
     public void removeUserRoles(int urId);
     /**
      * keys:
      *  urId
      *  rlId
      * */
     public void addUserRole(Map<String,Integer> map);
     
     public List<DmRole> findDeployedRoles(int urId);
     public List<DmRole> findUndeployedRoles(int urId);
     /**
      * keys :
      *   urUserName
      *   urName
      * */
     public List<DmUser> findUsers(Map<String,String> map);
}
