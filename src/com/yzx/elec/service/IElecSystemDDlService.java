package com.yzx.elec.service;

import java.util.List;

import com.yzx.elec.pojo.ElecSystemDDL;

public interface IElecSystemDDlService extends ICommonService<ElecSystemDDL> {
	public static final String SERVICE_NAME = "com.yzx.elec.service.impl.ElecSystemDDLServiceImpl";

	/**
	 * ��ѯ�����ֵ�ؼ���
	 */
	public List<String> findKeyWord();
}
