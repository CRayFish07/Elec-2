package com.yzx.elec.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzx.elec.dao.ICommonDao;
import com.yzx.elec.dao.IElecSystemDDLDao;
import com.yzx.elec.pojo.ElecSystemDDL;
import com.yzx.elec.service.IElecSystemDDlService;

@Service(IElecSystemDDlService.SERVICE_NAME)
public class ElecSystemDDLService extends CommonServiceImpl<ElecSystemDDL> implements IElecSystemDDlService {
	
	@Override
	@Resource(name=IElecSystemDDLDao.DAO_NAME)
	protected void setDao(ICommonDao<ElecSystemDDL> dao) {
		
	}

	@Override
	public List<ElecSystemDDL> findObjectsByConditions(Object valueObject) {
		return null;
	}

	@Override
	public ArrayList<String> findKeyWord() {
		IElecSystemDDLDao ddlDao = (IElecSystemDDLDao)dao;
		return ddlDao.findKeywords();
	}

}
