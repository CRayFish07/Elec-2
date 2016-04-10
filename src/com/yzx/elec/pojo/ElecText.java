package com.yzx.elec.pojo;
// Generated 2016-2-7 17:34:58 by Hibernate Tools 4.3.1.Final

import java.util.Date;

/**
 * ElecText generated by hbm2java
 */
public class ElecText implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String textid;
	private String textname;
	private Date textdate;
	private String textremark;

	public ElecText() {
	}

	public ElecText(String textid) {
		this.textid = textid;
	}

	public ElecText(String textid, String textname, Date textdate, String textremark) {
		this.textid = textid;
		this.textname = textname;
		this.textdate = textdate;
		this.textremark = textremark;
	}

	public String getTextid() {
		return this.textid;
	}

	public void setTextid(String textid) {
		this.textid = textid;
	}

	public String getTextname() {
		return this.textname;
	}

	public void setTextname(String textname) {
		this.textname = textname;
	}

	public Date getTextdate() {
		return this.textdate;
	}

	public void setTextdate(Date textdate) {
		this.textdate = textdate;
	}

	public String getTextremark() {
		return this.textremark;
	}

	public void setTextremark(String textremark) {
		this.textremark = textremark;
	}

}