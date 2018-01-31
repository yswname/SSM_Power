package cn.com.demo.mybatis.entity;

import org.apache.ibatis.type.Alias;

/**
 * DmOrder entity. @author MyEclipse Persistence Tools
 */
@Alias("DmOrder")
public class DmOrder implements java.io.Serializable {

	// Fields

	private Integer odId;
	private DmUser dmUser;
	private String odCode;

	// Constructors

	/** default constructor */
	public DmOrder() {
	}

	/** minimal constructor */
	public DmOrder(String odCode) {
		this.odCode = odCode;
	}

	/** full constructor */
	public DmOrder(DmUser dmUser, String odCode) {
		this.dmUser = dmUser;
		this.odCode = odCode;
	}

	// Property accessors

	public Integer getOdId() {
		return this.odId;
	}

	public void setOdId(Integer odId) {
		this.odId = odId;
	}

	public DmUser getDmUser() {
		return this.dmUser;
	}

	public void setDmUser(DmUser dmUser) {
		this.dmUser = dmUser;
	}

	public String getOdCode() {
		return this.odCode;
	}

	public void setOdCode(String odCode) {
		this.odCode = odCode;
	}

}