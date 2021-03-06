package com.yzx.elec.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xiang.encrypt.Md5Util;
import com.yan.util.ColUtil;
import com.yan.util.StringUtil;
import com.yzx.elec.dao.IElecSystemDDLDao;
import com.yzx.elec.dao.IElecUserDao;
import com.yzx.elec.pojo.ElecUser;
import com.yzx.elec.service.IElecUserService;
import com.yzx.elec.web.form.ElecUserForm;

@Transactional(readOnly=true)
@Service(IElecUserService.SERVICE_NAME)
public class ElecUserServiceImpl implements IElecUserService {
	private static final String IS_DUTY = "是否在职";
	private static final String SEX = "性别";
	
	/**
	 * 查询用户hql语句
	 */
	private static final String FIND_USER_SQL = "FROM ElecUser WHERE logonName=? AND logonPassword=?";
	private static final String FIND_USER_ROLES_BY_ID = "SELECT a.ddlcode, a.ddlname FROM elec_systemddl a"+
														" INNER JOIN elec_user_role b ON a.ddlcode=b.roleid"+
														" INNER JOIN elec_user c ON b.userid=c.userid"+
														" WHERE c.userid=? AND a.keyword='角色类型' AND c.isDuty=1";
	
	@Resource(name=IElecUserDao.DAO_NAME)
	private IElecUserDao dao;
	
	@Resource(name=IElecSystemDDLDao.DAO_NAME)
	private IElecSystemDDLDao ddlDao;

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

	@Transactional(isolation=Isolation.DEFAULT,readOnly=false,propagation=Propagation.REQUIRED)
	public void save(ElecUserForm form) {
		if(form.isModify()) {
			form.setLogonPassword(Md5Util.getInstance().makeMD5(form.getLogonPassword()));
		}
		
		ElecUser user = vo2Po(form);
		if(user.getUserId() > 0) {
			dao.update(user);
		} else {
			dao.save(user);
		}
	}
	
	private ElecUser vo2Po(ElecUserForm form) {
		ElecUser user = new ElecUser();
		user.setUserId(form.getUserId());
		user.setJctId(form.getJctId());
		user.setUserName(form.getUserName());
		user.setLogonName(form.getLogonName());
		user.setLogonPassword(form.getLogonPassword());
		user.setSexId(form.getSexId());
		user.setBirthDay(form.getBirthDay());
		user.setAddress(form.getAddress());
		user.setContactTel(form.getContactTel());
		user.setEmail(form.getEmail());
		user.setMobile(form.getMobile());
		user.setIsDuty(form.getIsDuty());
		user.setOnDutyDate(form.getOnDutyDate());
		user.setRemark(form.getRemark());
		
		return user;
	}
	
	private ElecUserForm po2Vo(ElecUser user, ElecUserForm form) {
		if(user == null) {
			return null;
		}
//		ElecUserForm form = new ElecUserForm();
		form.setUserId(user.getUserId());
		form.setJctId(user.getJctId());
		form.setUserName(user.getUserName());
		form.setLogonName(user.getLogonName());
		form.setLogonPassword(user.getLogonPassword());
		form.setSexId(user.getSexId());
		form.setBirthDay(user.getBirthDay());
		form.setAddress(user.getAddress());
		form.setContactTel(user.getContactTel());
		form.setEmail(user.getEmail());
		form.setMobile(user.getMobile());
		form.setIsDuty(user.getIsDuty());
		form.setOnDutyDate(user.getOnDutyDate());
		form.setOffDutyDate(user.getOffDutyDate());
		form.setRemark(user.getRemark());
		return form;
	}

	public ElecUserForm findObjectByVo(ElecUserForm form) {
		ElecUser user = dao.findObjectById(form.getUserId());
		return po2Vo(user, form);
	}

	@Transactional(isolation=Isolation.DEFAULT,readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public void deleteUsers(ElecUserForm... users) {
		Serializable[] ids = new Serializable[users.length];
		for(int i=0; i<users.length; i++) {
			ids[i] = users[i].getUserId();
		}
		dao.deleteObjectByIds(ids);
	}

	@Override
	public String checkUserExists(String logonName) {
		String condition = " and logonName=?";
		ArrayList<String> params = new ArrayList<String>();
		params.add(logonName);
		List<ElecUser> users = dao.findObjectsByConditions(condition, params, null);
		if(!ColUtil.isEmpty(users)) {
			return "1";
		} else {
			return "2";
		}
	}


	@Override
	public List<ElecUserForm> findUserByIdAndPassword(String logonName, String logonPassword) {
		List<ElecUser> users = dao.findListBySql(FIND_USER_SQL, new Object[] {logonName, logonPassword});
		return changePo2VoList(users);
	}


	@Override
	public HashMap<Integer, String> findUserRolesByUserId(int userId) {
		Object[] params = new Object[] {userId};
		List<Object[]> list = dao.findObjectListBySql(FIND_USER_ROLES_BY_ID, params);
		HashMap<Integer, String> result = null;
		if(!ColUtil.isEmpty(list)) {
			result = new HashMap<Integer, String>();
			for(Object[] objes : list) {
				result.put((int)objes[0], (String)objes[1]);
			}
		}
		return result;
	}
}
