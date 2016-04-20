package com.yzx.elec.service;

import java.util.List;

import com.yzx.elec.pojo.ElecSystemDDL;
import com.yzx.elec.web.form.ElecSystemDDLForm;

public interface IElecSystemDDlService extends ICommonService<ElecSystemDDL, ElecSystemDDLForm> {
	public static final String SERVICE_NAME = "com.yzx.elec.service.impl.ElecSystemDDLServiceImpl";

	/**
	 * ��ѯ�����ֵ�ؼ���
	 */
	public List<ElecSystemDDLForm> findKeyWord();

	/**
	 * ���������ֵ�
	 */
	public void saveSystemDDLList(ElecSystemDDLForm form);

	/**
	 * ���ݹؼ��ֲ����������б�
	 * @param sex �ؼ���
	 * @return �������б�
	 */
	public List<ElecSystemDDLForm> findDdlListByKeyword(String sex);
}
