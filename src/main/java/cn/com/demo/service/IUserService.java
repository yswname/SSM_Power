package cn.com.demo.service;

import java.util.List;

import cn.com.demo.mybatis.entity.DmRole;
import cn.com.demo.mybatis.entity.DmUser;

public interface IUserService {
    public List<DmUser> searchUsers();
    public void addUser(DmUser user);
    
    // 正式代码****************
    public List<DmUser> searchUsers(String urName,String urUserName);
    // 查询用户对象
    public DmUser searchUserById(int urId);
    // 查询用户已有的角色
    public List<DmRole> searchDeployedRoles(int urId);
    // 查询用户没有的角色
    public List<DmRole> searchUndeployedRoles(int urId);
    // 给用户重新分配角色
    public void deployUserRoles(int urId, int[] rlIds);
}
