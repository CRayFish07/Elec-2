package com.yzx.elec.pojo;

// Generated 2016-4-29 17:14:37 by Hibernate Tools 3.4.0.CR1

/**
 * ElecRolePopedom generated by hbm2java
 */
@SuppressWarnings("serial")
public class ElecRolePopedom implements java.io.Serializable {

	private Integer roleId;
	private String popedomCode;
	private String remark;

	public ElecRolePopedom() {
	}

	public ElecRolePopedom(String popedomCode, String remark) {
		this.popedomCode = popedomCode;
		this.remark = remark;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getPopedomCode() {
		return this.popedomCode;
	}

	public void setPopedomCode(String popedomCode) {
		this.popedomCode = popedomCode;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
