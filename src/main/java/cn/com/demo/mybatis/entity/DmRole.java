package cn.com.demo.mybatis.entity;

import java.util.HashSet;
import java.util.Set;

import org.apache.ibatis.type.Alias;

/**
 * DmRole entity. @author MyEclipse Persistence Tools
 */
@Alias("DmRole")
public class DmRole implements java.io.Serializable {

	// Fields

	private Integer rlId;
	private String rlName;
	private String rlRemark;
	private Set dmUsers = new HashSet(0);

	private Set<DmPowerItem> dmPowerItems = new HashSet<DmPowerItem>(); 
	// Constructors

	/** default constructor */
	public DmRole() {
	}

	/** minimal constructor */
	public DmRole(String rlName) {
		this.rlName = rlName;
	}

	/** full constructor */
	public DmRole(String rlName, String rlRemark, Set dmUsers) {
		this.rlName = rlName;
		this.rlRemark = rlRemark;
		this.dmUsers = dmUsers;
	}

	// Property accessors

	public Integer getRlId() {
		return this.rlId;
	}

	public Set<DmPowerItem> getDmPowerItems() {
		return dmPowerItems;
	}

	public void setDmPowerItems(Set<DmPowerItem> dmPowerItems) {
		this.dmPowerItems = dmPowerItems;
	}

	public void setRlId(Integer rlId) {
		this.rlId = rlId;
	}

	public String getRlName() {
		return this.rlName;
	}

	public void setRlName(String rlName) {
		this.rlName = rlName;
	}

	public String getRlRemark() {
		return this.rlRemark;
	}

	public void setRlRemark(String rlRemark) {
		this.rlRemark = rlRemark;
	}

	public Set getDmUsers() {
		return this.dmUsers;
	}

	public void setDmUsers(Set dmUsers) {
		this.dmUsers = dmUsers;
	}

}