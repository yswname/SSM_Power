package cn.com.demo.mybatis.entity;

import java.util.HashSet;
import java.util.Set;

import org.apache.ibatis.type.Alias;


/**
 * DmPowerItem entity. @author MyEclipse Persistence Tools
 */
@Alias("DmPowerItem")
public class DmPowerItem implements java.io.Serializable {

	// Fields

	private Integer piId;
	private DmModul dmModul;
	private String piName;
	private String piUrl;
	private String piRemark;
    
	private Set<DmRole> dmRoles = new HashSet<DmRole>();
	// Constructors

	/** default constructor */
	public DmPowerItem() {
	}

	/** minimal constructor */
	public DmPowerItem(String piName, String piUrl) {
		this.piName = piName;
		this.piUrl = piUrl;
	}

	/** full constructor */
	public DmPowerItem(DmModul dmModul, String piName, String piUrl,
			String piRemark) {
		this.dmModul = dmModul;
		this.piName = piName;
		this.piUrl = piUrl;
		this.piRemark = piRemark;
	}

	// Property accessors

	public Set<DmRole> getDmRoles() {
		return dmRoles;
	}

	public void setDmRoles(Set<DmRole> dmRoles) {
		this.dmRoles = dmRoles;
	}

	public Integer getPiId() {
		return this.piId;
	}

	public void setPiId(Integer piId) {
		this.piId = piId;
	}

	public DmModul getDmModul() {
		return this.dmModul;
	}

	public void setDmModul(DmModul dmModul) {
		this.dmModul = dmModul;
	}

	public String getPiName() {
		return this.piName;
	}

	public void setPiName(String piName) {
		this.piName = piName;
	}

	public String getPiUrl() {
		return this.piUrl;
	}

	public void setPiUrl(String piUrl) {
		this.piUrl = piUrl;
	}

	public String getPiRemark() {
		return this.piRemark;
	}

	public void setPiRemark(String piRemark) {
		this.piRemark = piRemark;
	}

}