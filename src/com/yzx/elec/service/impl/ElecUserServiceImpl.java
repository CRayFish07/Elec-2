package com.yzx.elec.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yan.util.StringUtil;
import com.yzx.elec.dao.ICommonDao;
import com.yzx.elec.dao.IElecSystemDDLDao;
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
	
	@Resource(name=IElecSystemDDLDao.DAO_NAME)
	private IElecSystemDDLDao ddlDao;

	@Override
	public List<ElecUserForm> findObjectsByConditions(ElecUserForm valueObject) {
		StringBuilder sb = null;
		ArrayList<String> params = null;
		if(valueObject != null && !StringUtil.isEmpty(valueObject.getUserName())) {
			sb = new StringBuilder();
			params = new ArrayList<String>();

			sb.append(" and o.userName like ?");
			params.add("%"+valueObject.getUserName()+"%");
		}

		
		return changePo2VoList(dao.findObjectsByConditions(sb == null ? null : sb.toString(), params, null));
	}
	
	private static final String IS_DUTY = "是否在职";
	private static final String SEX = "性别";

	public List<ElecUserForm> changePo2VoList(List<ElecUser> pos) {
		if(pos == null) {
			return null;
		}
		
		ArrayList<ElecUserForm> result = new ArrayList<ElecUserForm>();
		for(ElecUser poUser : pos) {
			ElecUserForm form = new ElecUserForm();
			form.setUserId(poUser.getUserId());
			form.setUserName(poUser.getUserName());
			form.setLogonName(poUser.getLogonName());
			form.setIsDuty(ddlDao.getDDLName(IS_DUTY, poUser.getIsDuty()));
			form.setSexId(ddlDao.getDDLName(SEX, poUser.getSexId()));
			form.setContactTel(poUser.getContactTel());
			result.add(form);
		}
		
		return result;
	}

}
