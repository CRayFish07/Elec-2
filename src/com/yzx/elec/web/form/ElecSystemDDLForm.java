package com.yzx.elec.web.form;

/**
 * �����ֵ�
 * @author yzx
 *
 */
public class ElecSystemDDLForm {
	private int seqId;
	private String keyword;
	private int ddlCode;
	private String ddlname;
	
	/**
	 * ִ�б���ʱ�����ݵ������ֵ����ͣ���Ӧ�ؼ���(keyword)
	 */
	private String keywordname;
	/**
	 * �������ͣ�newΪ������addΪ�޸�
	 */
	private String typeflag;
	/**
	 * ����������ֵ���
	 */
	private String[] itemname;
	
	public int getSeqId() {
		return seqId;
	}
	public void setSeqId(int seqId) {
		this.seqId = seqId;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getDdlCode() {
		return ddlCode;
	}
	public void setDdlCode(int ddlCode) {
		this.ddlCode = ddlCode;
	}
	public String getDdlname() {
		return ddlname;
	}
	public void setDdlname(String ddlname) {
		this.ddlname = ddlname;
	}
	public String getKeywordname() {
		return keywordname;
	}
	public void setKeywordname(String keywordname) {
		this.keywordname = keywordname;
	}
	public String getTypeflag() {
		return typeflag;
	}
	public void setTypeflag(String typeflag) {
		this.typeflag = typeflag;
	}
	public String[] getItemname() {
		return itemname;
	}
	public void setItemname(String[] itemname) {
		this.itemname = itemname;
	}
}
