package com.yzx.elec.web.form;

public class ElecRolePopedomForm {
	/**
	 * 角色id
	 */
	private String role;
	
	/**
	 * 权限集合
	 */
	private String[] selectoper;
	
	/**
	 * 用户集合
	 */
	private String[] selectuser;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String[] getSelectoper() {
		return selectoper;
	}

	public void setSelectoper(String[] selectoper) {
		this.selectoper = selectoper;
	}

	public String[] getSelectuser() {
		return selectuser;
	}

	public void setSelectuser(String[] selectuser) {
		this.selectuser = selectuser;
	}

}
