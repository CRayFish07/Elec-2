package com.yzx.elec.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yzx.elec.dao.IElecLogDao;
import com.yzx.elec.service.IElecLogService;

@Transactional(readOnly=true)
@Service(IElecLogService.SERVICE_NAME)
public class ElecLogServiceImpl implements IElecLogService {
	@Resource(name=IElecLogDao.DAO_NAME)
	private IElecLogDao logDao;

	@Override
	public void log(HttpServletRequest request, String detail) {
	}
	
	
}
