package com.yzx.elec.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author yzx<br/>
 * 创建日期 2016年4月29日
 */
@Transactional(readOnly=true)
public interface IElecRoleService {
	public static final String SERVICE_NAME = "com.yzx.elec.service.impl.IElecRoleServiceImpl";
}
