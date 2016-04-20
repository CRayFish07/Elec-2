package com.yzx.elec.dao;

import java.util.List;

import com.yzx.elec.pojo.ElecSystemDDL;

public interface IElecSystemDDLDao extends ICommonDao<ElecSystemDDL> {
	public static final String DAO_NAME = "com.yzx.elec.dao.impl.ElecSystemDDLDaoImpl";

	/**
	 * 查询数据字典中的关键字
	 */
	public List<String> findKeywords();

	/**
	 * 根据关键字(keyword)以及操作码(ddlCode)得到数据字典名称
	 */
	public String getDDLName(String keyword, String ddlCode);
	
}
