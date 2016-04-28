package com.yzx.elec.web.form;

import java.util.Date;

public class ElecUserForm {
	private int userId;
	private String jctId;
	private String userName;
	private String logonName;
	private String logonPassword;
	private String sexId;
	private Date birthDay;
	private String address;
	private String contactTel;
	private String email;
	private String mobile;
	private String isDuty;
	private Date onDutyDate;
	private Date offDutyDate;
	private String remark;
	
	/**
	 * =1时，只是查看明细，并不修改保存
	 * =null时，修改保存
	 */
	private String viewflag;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getJctId() {
		return jctId;
	}
	public void setJctId(String jctId) {
		this.jctId = jctId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLogonName() {
		return logonName;
	}
	public void setLogonName(String logonName) {
		this.logonName = logonName;
	}
	public String getLogonPassword() {
		return logonPassword;
	}
	public void setLogonPassword(String logonPassword) {
		this.logonPassword = logonPassword;
	}
	public String getSexId() {
		return sexId;
	}
	public void setSexId(String sexId) {
		this.sexId = sexId;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactTel() {
		return contactTel;
	}
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getIsDuty() {
		return isDuty;
	}
	public void setIsDuty(String isDuty) {
		this.isDuty = isDuty;
	}
	public Date getOnDutyDate() {
		return onDutyDate;
	}
	public void setOnDutyDate(Date onDutyDate) {
		this.onDutyDate = onDutyDate;
	}
	public Date getOffDutyDate() {
		return offDutyDate;
	}
	public void setOffDutyDate(Date offDutyDate) {
		this.offDutyDate = offDutyDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getViewflag() {
		return viewflag;
	}
	public void setViewflag(String viewflag) {
		this.viewflag = viewflag;
	}
}
