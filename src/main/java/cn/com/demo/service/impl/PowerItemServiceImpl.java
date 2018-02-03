package cn.com.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.demo.mybatis.dao.IDmModulDAO;
import cn.com.demo.mybatis.dao.IDmPowerItemDAO;
import cn.com.demo.mybatis.entity.DmModul;
import cn.com.demo.mybatis.entity.DmPowerItem;
import cn.com.demo.service.IPowerItemService;
import cn.com.demo.util.DAOFactroy;
@Service("IPowerItemService")
@Transactional
public class PowerItemServiceImpl implements IPowerItemService {
	@Autowired
	//@Qualifier("powerItemDao")
	private IDmPowerItemDAO powerItemDao;
	@Autowired
	//@Qualifier("modulDao")
	private IDmModulDAO modulDao;
	@Override
	@Transactional(readOnly=true)
	public List<DmModul> searchAllModuls() {
		// TODO Auto-generated method stub
		List<DmModul> list = null;
		list =modulDao.findAll();
		return list;
	}

	@Override
	@Transactional(readOnly=true)
	public List<DmModul> searchPowerItems(DmPowerItem powerItem){
		List<DmModul> list = null;
		Map<String,Object> map = new HashMap<String,Object>();
		
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public DmPowerItem searchPowerItemById(int piId) {
		// TODO Auto-generated method stub
		DmPowerItem powerItem = null;
		powerItem = this.powerItemDao.findById(piId);
		return powerItem;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public void addPowerItem(DmPowerItem item) {
		// TODO Auto-generated method stub
		this.powerItemDao.addPowerItem(item);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void editPowerItem(DmPowerItem item) {
		// TODO Auto-generated method stub
		this.powerItemDao.updatePowerItem(item);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deletePowerItem(DmPowerItem item) {
		// TODO Auto-generated method stub
		this.powerItemDao.deletePowerItem(item);
	}

}
