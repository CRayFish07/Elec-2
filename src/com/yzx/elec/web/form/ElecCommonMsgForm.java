package com.yzx.elec.web.form;
// Generated 2016-2-12 0:14:35 by Hibernate Tools 4.3.1.Final

import java.util.Date;

/**
 * ElecCommonmsg generated by hbm2java
 */
public class ElecCommonMsgForm {
	private String stationRun;
	private String devRun;
	private Date createDate;

	public ElecCommonMsgForm() {
	}


	public ElecCommonMsgForm(String stationRun, String devRun, Date createDate) {
		this.stationRun = stationRun;
		this.devRun = devRun;
		this.createDate = createDate;
	}


	public String getStationRun() {
		return this.stationRun;
	}

	public void setStationRun(String stationRun) {
		this.stationRun = stationRun;
	}

	public String getDevRun() {
		return this.devRun;
	}

	public void setDevRun(String devRun) {
		this.devRun = devRun;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
