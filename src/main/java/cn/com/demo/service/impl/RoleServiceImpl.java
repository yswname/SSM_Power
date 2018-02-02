package cn.com.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.demo.mybatis.dao.IDmRoleDAO;
import cn.com.demo.mybatis.entity.DmModul;
import cn.com.demo.mybatis.entity.DmPowerItem;
import cn.com.demo.mybatis.entity.DmRole;
import cn.com.demo.service.IRoleService;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private IDmRoleDAO roleDAO;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addRole(DmRole role) {
		this.roleDAO.save(role);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void editRole(DmRole role) {
		this.roleDAO.update(role);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteRole(DmRole role) {
		this.roleDAO.deleteFromRoleAndItem(role);
		this.roleDAO.deleteFromRoleAndUser(role);
		this.roleDAO.delete(role);
	}

	@Override
	public void saveDeployedPowerItems(int rlId, int[] piIds) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DmModul> searchAllModuls() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DmPowerItem> searchPowerItemsByRoleId(int rlId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
     * 通过传入的角色信息查询角色列表
     * 将角色对象封装成map，再调用DAO中的方法
     * */
	@Override
	@Transactional(readOnly=true)
	public List<DmRole> searchRoles(DmRole role) {
		List<DmRole> roles = null;
		Map<String, String> map = new HashMap<String, String>();
		map.put("rlName", null);
		map.put("rlRemark", null);
		if(role.getRlName() != null && !"".equals(role.getRlName())){
			map.put("rlName", role.getRlName());
		}
		if(role.getRlRemark() != null && !"".equals(role.getRlRemark())){
			map.put("rlRemark", role.getRlRemark());
		}
		roles = roleDAO.findAll(map);
		return roles;
	}

	/**
	 * 通过角色id查询角色（与删除和修改一起使用）
	 * */
	@Override
	@Transactional(readOnly=true)
	public DmRole searchRoleById(int rlId) {
		DmRole role = this.roleDAO.findById(rlId);
		DmRole roleTemp = new DmRole();
		roleTemp.setRlId(role.getRlId());
		roleTemp.setRlName(role.getRlName());
		roleTemp.setRlRemark(role.getRlRemark());
		return roleTemp;
	}

}
