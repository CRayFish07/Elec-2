package com.yzx.elec.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.yan.util.xml.XmlObject;
import com.yzx.elec.web.form.ElecSystemDDLForm;

/**
 * 
 * @author yzx<br/>
 * 创建日期 2016年4月29日
 */
@Transactional(readOnly=true)
public interface IElecRoleService {
	public static final String SERVICE_NAME = "com.yzx.elec.service.impl.IElecRoleServiceImpl";

	/**
	 * 取得所有角色
	 */
	public List<ElecSystemDDLForm> getAllService();

	public List<XmlObject> readRoleFunctionList();
}
