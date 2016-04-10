package com.yzx.elec.dao;

import java.util.ArrayList;

import com.yzx.elec.pojo.ElecSystemDDL;

public interface IElecSystemDDLDao extends ICommonDao<ElecSystemDDL> {
	public static final String DAO_NAME = "com.yzx.elec.dao.impl.ElecSystemDDLDaoImpl";

	/**
	 * 查询数据字典中的关键字
	 */
	public ArrayList<String> findKeywords();
	
}
