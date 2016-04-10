package com.yzx.elec.service;

import java.util.ArrayList;

import com.yzx.elec.pojo.ElecSystemDDL;

public interface IElecSystemDDlService extends ICommonService<ElecSystemDDL> {
	public static final String SERVICE_NAME = "com.yzx.elec.service.impl.ElecSystemDDLService";

	/**
	 * 查询数据字典关键字
	 */
	public ArrayList<String> findKeyWord();
}
