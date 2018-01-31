package cn.com.demo.mybatis.entity;

import org.apache.ibatis.type.Alias;

/**
 * DmIdCard entity. @author MyEclipse Persistence Tools
 */
@Alias("DmIdCard")
public class DmIdCard implements java.io.Serializable {

	// Fields

	private Integer icId;
	private DmUser dmUser;
	private String icCode;
	private String icName;
	private String icAddress;

	// Constructors

	/** default constructor */
	public DmIdCard() {
	}

	/** full constructor */
	public DmIdCard(DmUser dmUser, String icCode, String icName,
			String icAddress) {
		this.dmUser = dmUser;
		this.icCode = icCode;
		this.icName = icName;
		this.icAddress = icAddress;
	}

	// Property accessors

	public Integer getIcId() {
		return this.icId;
	}

	public void setIcId(Integer icId) {
		this.icId = icId;
	}

	public DmUser getDmUser() {
		return this.dmUser;
	}

	public void setDmUser(DmUser dmUser) {
		this.dmUser = dmUser;
	}

	public String getIcCode() {
		return this.icCode;
	}

	public void setIcCode(String icCode) {
		this.icCode = icCode;
	}

	public String getIcName() {
		return this.icName;
	}

	public void setIcName(String icName) {
		this.icName = icName;
	}

	public String getIcAddress() {
		return this.icAddress;
	}

	public void setIcAddress(String icAddress) {
		this.icAddress = icAddress;
	}

}