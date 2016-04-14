package com.yzx.elec.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzx.elec.dao.ICommonDao;
import com.yzx.elec.dao.IElecSystemDDLDao;
import com.yzx.elec.pojo.ElecSystemDDL;
import com.yzx.elec.service.IElecSystemDDlService;

@Service(IElecSystemDDlService.SERVICE_NAME)
public class ElecSystemDDLServiceImpl extends CommonServiceImpl<ElecSystemDDL> implements IElecSystemDDlService {
	
	@Override
	@Resource(name=IElecSystemDDLDao.DAO_NAME)
	protected void setDao(ICommonDao<ElecSystemDDL> dao) {
		this.dao = dao;
	}

	@Override
	public List<ElecSystemDDL> findObjectsByConditions(Object valueObject) {
		return null;
	}

	@Override
	public List<String> findKeyWord() {
		IElecSystemDDLDao ddlDao = (IElecSystemDDLDao)dao;
		
		List<String> keyWords = ddlDao.findKeywords();
		return keyWords;
	}

}
