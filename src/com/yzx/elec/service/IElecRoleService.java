package com.yzx.elec.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author yzx<br/>
 * �������� 2016��4��29��
 */
@Transactional(readOnly=true)
public interface IElecRoleService {
	public static final String SERVICE_NAME = "com.yzx.elec.service.impl.IElecRoleServiceImpl";
}
