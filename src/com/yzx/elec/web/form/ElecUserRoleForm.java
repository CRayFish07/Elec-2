package com.yzx.elec.web.form;

public class ElecUserRoleForm {
	//�����ֶ�
	private int roleId;
	private String remark;
	
	//��ɫ���
	private Integer seqId;
	private int userId;
	
	//��ɫȨ�����
	private String popedomCode;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSeqId() {
		return seqId;
	}

	public void setSeqId(Integer seqId) {
		this.seqId = seqId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPopedomCode() {
		return popedomCode;
	}

	public void setPopedomCode(String popedomCode) {
		this.popedomCode = popedomCode;
	}
}
