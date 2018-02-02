package cn.com.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.demo.mybatis.dao.IDmUserDAO;
import cn.com.demo.mybatis.entity.DmRole;
import cn.com.demo.mybatis.entity.DmUser;
import cn.com.demo.service.IUserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	//@Qualifier("DmUserDAO")
    private IDmUserDAO userDAO;
	@Override
	@Transactional(readOnly=true)
	public List<DmUser> searchUsers() {
		return this.userDAO.findAll();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addUser(DmUser user) {
		this.userDAO.save(user);
	}

	@Override
	public List<DmUser> searchUsers(String urName, String urUserName) {
	
		Map<String,String> map = new HashMap<String,String>();
		map.put("urUserName", "%"+urUserName+"%");
		map.put("urName", "%"+urName+"%");
		List<DmUser> userList = this.userDAO.findUsers(map);
		return userList;
	}

	@Override
	public DmUser searchUserById(int urId) {
		DmUser user = this.userDAO.findById(urId);
		return user;
	}

	@Override
	public List<DmRole> searchDeployedRoles(int urId) {
		List<DmRole> roleList = this.userDAO.findDeployedRoles(urId);
		return roleList;
	}

	@Override
	public List<DmRole> searchUndeployedRoles(int urId) {
		List<DmRole> roleList = this.userDAO.findUndeployedRoles(urId);
		return roleList;
	}

	@Override
	public void deployUserRoles(int urId, int[] rlIds) {
		//移除该id的用户的所有角色
		this.userDAO.removeUserRoles(urId);
		//赋予该id新角色
		Map<String,Integer> map = null;
		if(rlIds != null){
			for (int i = 0; i < rlIds.length; i++) {
				map = new HashMap<String,Integer>();
				map.put("mapUrId", urId);
				map.put("mapRlId", rlIds[i]);
				this.userDAO.addUserRole(map);
			}	
		}
	}

	
	
}
