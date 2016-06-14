package com.yzx.elec.service.transdata;

public class ElecRole {
	private int roleId;
	
	private String roleName;
	
	private String popedom;
	
	public ElecRole(int roleId, String roleName, String popedom) {
		
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getPopedom() {
		return popedom;
	}

	public void setPopedom(String popedom) {
		this.popedom = popedom;
	}
}
