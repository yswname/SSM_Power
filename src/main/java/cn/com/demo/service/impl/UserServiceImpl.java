package cn.com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.demo.mybatis.dao.IDmUserDAO;
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

}
