package com.yzx.elec.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzx.elec.dao.IElecRolePopedomDao;
import com.yzx.elec.dao.IElecUserRoleDao;
import com.yzx.elec.service.IElecRoleService;

/**
 * ��ɫ����
 * @author yzx<br/>
 * �������� 2016��4��29��
 */
@Service(IElecRoleService.SERVICE_NAME)
public class ElecRoleServiceImpl implements IElecRoleService {
	/**
	 * ��ɫȨ��dao
	 */
	@Resource(name=IElecRolePopedomDao.DAO_NAME)
	private IElecRolePopedomDao rolePopedomDao;
	
	/**
	 * �û���ɫdao
	 */
	@Resource(name=IElecUserRoleDao.DAO_NAME)
	private IElecUserRoleDao userRoleDao;
}
