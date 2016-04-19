package com.yzx.elec.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yan.util.StringUtil;
import com.yzx.elec.dao.ICommonDao;
import com.yzx.elec.dao.IElecUserDao;
import com.yzx.elec.pojo.ElecUser;
import com.yzx.elec.service.IElecUserService;
import com.yzx.elec.web.form.ElecUserForm;

@Service(IElecUserService.SERVICE_NAME)
public class ElecUserServiceImpl extends CommonServiceImpl<ElecUser, ElecUserForm> implements IElecUserService {

	@Override
	@Resource(name=IElecUserDao.DAO_NAME)
	protected void setDao(ICommonDao<ElecUser> dao) {
		this.dao = dao;
	}

	@Override
	public List<ElecUserForm> findObjectsByConditions(ElecUserForm valueObject) {
		StringBuilder sb = null;
		ArrayList<String> params = null;
		if(!StringUtil.isEmpty(valueObject.getUserName())) {
			sb = new StringBuilder();
			params = new ArrayList<String>();

			sb.append(" and o.userName like %?%");
			params.add(valueObject.getUserName());
		}

		
		return changePo2VoList(dao.findObjectsByConditions(sb.toString(), params, null));
	}

	@Override
	public List<ElecUserForm> changePo2VoList(List<ElecUser> pos) {
		return null;
	}

}
