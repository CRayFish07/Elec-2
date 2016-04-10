package com.yzx.elec.dao;

import java.util.List;

import com.yzx.elec.pojo.ElecCommonMsg;

public interface IElecCommonMsgDao extends ICommonDao<ElecCommonMsg> {
	public static final String DAO_NAME = "com.yzx.elec.dao.impl.ElecCommonMsgDaoImpl";
	public List<Object[]> findElecCommonMsgByDate(String date);
}
