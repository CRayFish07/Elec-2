package com.yzx.elec.dao;

import java.util.List;

import com.yzx.elec.pojo.ElecSystemDDL;

public interface IElecSystemDDLDao extends ICommonDao<ElecSystemDDL> {
	public static final String DAO_NAME = "com.yzx.elec.dao.impl.ElecSystemDDLDaoImpl";

	/**
	 * ��ѯ�����ֵ��еĹؼ���
	 */
	public List<String> findKeywords();
	
}
