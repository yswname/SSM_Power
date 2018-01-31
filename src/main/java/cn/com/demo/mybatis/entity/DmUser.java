package cn.com.demo.mybatis.entity;

import java.util.HashSet;
import java.util.Set;

import org.apache.ibatis.type.Alias;

/**
 * DmUser entity. @author MyEclipse Persistence Tools
 */
@Alias("DmUser")
public class DmUser implements java.io.Serializable {

	// Fields

	private Integer urId;
	private String urUserName;
	private String urPassword;
	private Integer urAge;
	private DmIdCard dmIdCard;
	private Set dmOrders = new HashSet(0);
	private Set dmRoles = new HashSet(0);

	// Constructors

	/** default constructor */
	public DmUser() {
	}

	/** minimal constructor */
	public DmUser(String urUserName) {
		this.urUserName = urUserName;
	}

	

	// Property accessors

	public Integer getUrId() {
		return this.urId;
	}

	public void setUrId(Integer urId) {
		this.urId = urId;
	}

	public String getUrUserName() {
		return this.urUserName;
	}

	public void setUrUserName(String urUserName) {
		this.urUserName = urUserName;
	}

	public String getUrPassword() {
		return this.urPassword;
	}

	public void setUrPassword(String urPassword) {
		this.urPassword = urPassword;
	}

	public Integer getUrAge() {
		return this.urAge;
	}

	public void setUrAge(Integer urAge) {
		this.urAge = urAge;
	}

	public DmIdCard getDmIdCard() {
		return this.dmIdCard;
	}

	public void setDmIdCard(DmIdCard dmIdCard) {
		this.dmIdCard = dmIdCard;
	}

	public Set getDmOrders() {
		return this.dmOrders;
	}

	public void setDmOrders(Set dmOrders) {
		this.dmOrders = dmOrders;
	}

	public Set getDmRoles() {
		return this.dmRoles;
	}

	public void setDmRoles(Set dmRoles) {
		this.dmRoles = dmRoles;
	}

}