package cn.com.demo.mybatis.entity;

import java.util.HashSet;
import java.util.Set;

import org.apache.ibatis.type.Alias;

/**
 * DmModul entity. @author MyEclipse Persistence Tools
 */
@Alias("DmModul")
public class DmModul implements java.io.Serializable {

	// Fields

	private Integer mdId;
	private String mdName;
	private String mdRemark;
	private Set dmPowerItems = new HashSet(0);

	// Constructors

	/** default constructor */
	public DmModul() {
	}

	/** minimal constructor */
	public DmModul(String mdName) {
		this.mdName = mdName;
	}

	/** full constructor */
	public DmModul(String mdName, String mdRemark, Set dmPowerItems) {
		this.mdName = mdName;
		this.mdRemark = mdRemark;
		this.dmPowerItems = dmPowerItems;
	}

	// Property accessors

	public Integer getMdId() {
		return this.mdId;
	}

	public void setMdId(Integer mdId) {
		this.mdId = mdId;
	}

	public String getMdName() {
		return this.mdName;
	}

	public void setMdName(String mdName) {
		this.mdName = mdName;
	}

	public String getMdRemark() {
		return this.mdRemark;
	}

	public void setMdRemark(String mdRemark) {
		this.mdRemark = mdRemark;
	}

	public Set getDmPowerItems() {
		return this.dmPowerItems;
	}

	public void setDmPowerItems(Set dmPowerItems) {
		this.dmPowerItems = dmPowerItems;
	}

}