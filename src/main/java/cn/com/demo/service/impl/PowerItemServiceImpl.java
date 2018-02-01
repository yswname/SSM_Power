package cn.com.demo.service.impl;

import java.util.List;

import cn.com.demo.mybatis.dao.IDmPowerItemDAO;
import cn.com.demo.mybatis.entity.DmModul;
import cn.com.demo.mybatis.entity.DmPowerItem;
import cn.com.demo.service.IPowerItemService;

public class PowerItemServiceImpl implements IPowerItemService {
	private IDmPowerItemDAO powerItemDao;
	@Override
	public List<DmModul> searchAllModuls() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DmModul> searchPowerItems(DmPowerItem powerItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DmPowerItem searchPowerItemById(int piId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPowerItem(DmPowerItem item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editPowerItem(DmPowerItem item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePowerItem(DmPowerItem item) {
		// TODO Auto-generated method stub

	}

}
