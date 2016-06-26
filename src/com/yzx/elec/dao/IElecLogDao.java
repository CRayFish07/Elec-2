package com.yzx.elec.dao;

import com.yzx.elec.pojo.ElecLog;

/**
 * 日志dao
 * @author yzx<br/>
 * 创建日期 2016年6月24日
 */
public interface IElecLogDao extends ICommonDao<ElecLog> {
	public static final String DAO_NAME = "com.yzx.elec.dao.impl.ElecLogDaoImpl";
}
