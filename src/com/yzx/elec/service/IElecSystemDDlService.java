package com.yzx.elec.service;

import java.util.List;

import com.yzx.elec.pojo.ElecSystemDDL;
import com.yzx.elec.web.form.ElecSystemDDLForm;

public interface IElecSystemDDlService extends ICommonService<ElecSystemDDL> {
	public static final String SERVICE_NAME = "com.yzx.elec.service.impl.ElecSystemDDLServiceImpl";

	/**
	 * 查询数据字典关键字
	 */
	public List<String> findKeyWord();

	/**
	 * 保存数据字典
	 */
	public void saveSystemDDLList(ElecSystemDDLForm form);
}
