package com.yzx.elec.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yan.util.ColUtil;
import com.yzx.elec.dao.ICommonDao;
import com.yzx.elec.dao.IElecCommonMsgDao;
import com.yzx.elec.pojo.ElecCommonMsg;
import com.yzx.elec.service.IElecCommonMsgService;
import com.yzx.elec.web.form.ElecCommonMsgForm;

@Transactional(readOnly=true)
@Service(IElecCommonMsgService.SERVICE_NAME)
public class ElecCommonMsgServiceImpl extends CommonServiceImpl<ElecCommonMsg, ElecCommonMsgForm> implements IElecCommonMsgService {

	@Override
	@Resource(name=IElecCommonMsgDao.DAO_NAME)
	protected void setDao(ICommonDao<ElecCommonMsg> dao) {
		this.dao = dao;
	}

	@Override
	public List<ElecCommonMsgForm> findObjectsByConditions(ElecCommonMsgForm valueObject) {
		return null;
	}
	
	public List<ElecCommonMsgForm> findAllObjects() {
		LinkedHashMap<String, String> orderBy = new LinkedHashMap<String, String>();
		orderBy.put("createdate", "desc");
		return changePo2VoList(dao.findObjectsByConditions(null, null, orderBy));
	}
	
	public List<ElecCommonMsgForm> findCommonMsgByCurrentDate() {
		java.sql.Date date = new java.sql.Date(new Date().getTime());
		List<Object[]> result = ((IElecCommonMsgDao)dao).findElecCommonMsgByDate(date.toString());
		
		return changeVlue2Vo(result);
	}

	private List<ElecCommonMsgForm> changeVlue2Vo(List<Object[]> result) {
		if(ColUtil.isEmpty(result)) {
			return null;
		}
		
		List<ElecCommonMsgForm> forms = new ArrayList<ElecCommonMsgForm>();
		for(Object[] os : result) {
			if(os != null && os.length != 0) {
				ElecCommonMsgForm form = new ElecCommonMsgForm();
				form.setStationRun((String)os[0]);
				form.setDevRun((String)os[1]);
				forms.add(form);
			}
		}
		
		return forms;
	}

	public List<ElecCommonMsgForm> changePo2VoList(List<ElecCommonMsg> pos) {
		if(ColUtil.isEmpty(pos)) {
			return null;
		} else {
			List<ElecCommonMsgForm> result = new ArrayList<ElecCommonMsgForm>();
			for(ElecCommonMsg msg : pos) {
				if(msg == null) {
					continue;
				}
				
				ElecCommonMsgForm form = new ElecCommonMsgForm(msg.getStationRun(), msg.getDevRun(), msg.getCreateDate());
				result.add(form);
			}
			return result;
		}
	}

	@Override
	public void save(ElecCommonMsgForm form) {
		if(form == null) {
			return;
		}
		dao.save(vo2po(form));
	}
	
	private ElecCommonMsg vo2po(ElecCommonMsgForm form1) {
		ElecCommonMsg entity = new ElecCommonMsg();
		entity.setStationRun(form1.getStationRun());
		entity.setDevRun(form1.getDevRun());
		if(form1.getCreateDate() == null) {
			entity.setCreateDate(new Date());
		} else {
			entity.setCreateDate(form1.getCreateDate());
		}
		return entity;
	}

	@Override
	public ElecCommonMsgForm findObjectByVo(ElecCommonMsgForm form) {
		return null;
	}

}
