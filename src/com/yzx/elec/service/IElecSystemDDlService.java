package com.yzx.elec.service;

import java.util.ArrayList;

import com.yzx.elec.pojo.ElecSystemDDL;

public interface IElecSystemDDlService extends ICommonService<ElecSystemDDL> {
	public static final String SERVICE_NAME = "com.yzx.elec.service.impl.ElecSystemDDLService";

	/**
	 * ��ѯ�����ֵ�ؼ���
	 */
	public ArrayList<String> findKeyWord();
}
