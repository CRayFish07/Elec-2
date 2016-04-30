package com.yzx.elec.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzx.elec.dao.IElecRolePopedomDao;
import com.yzx.elec.dao.IElecUserRoleDao;
import com.yzx.elec.service.IElecRoleService;

/**
 * 角色服务
 * @author yzx<br/>
 * 创建日期 2016年4月29日
 */
@Service(IElecRoleService.SERVICE_NAME)
public class ElecRoleServiceImpl implements IElecRoleService {
	/**
	 * 角色权限dao
	 */
	@Resource(name=IElecRolePopedomDao.DAO_NAME)
	private IElecRolePopedomDao rolePopedomDao;
	
	/**
	 * 用户角色dao
	 */
	@Resource(name=IElecUserRoleDao.DAO_NAME)
	private IElecUserRoleDao userRoleDao;
}
