package cn.com.demo.service;

import java.util.List;

import cn.com.demo.mybatis.entity.DmUser;

public interface IUserService {
    public List<DmUser> searchUsers();
    public void addUser(DmUser user);
}
