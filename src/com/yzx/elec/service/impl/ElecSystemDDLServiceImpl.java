package com.yzx.elec.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yan.util.ColUtil;
import com.yan.util.StringUtil;
import com.yzx.elec.dao.ICommonDao;
import com.yzx.elec.dao.IElecSystemDDLDao;
import com.yzx.elec.pojo.ElecSystemDDL;
import com.yzx.elec.service.IElecSystemDDlService;
import com.yzx.elec.web.form.ElecSystemDDLForm;

@Transactional(readOnly=true)
@Service(IElecSystemDDlService.SERVICE_NAME)
public class ElecSystemDDLServiceImpl extends CommonServiceImpl<ElecSystemDDL, ElecSystemDDLForm> implements IElecSystemDDlService {
	
	@Override
	@Resource(name=IElecSystemDDLDao.DAO_NAME)
	protected void setDao(ICommonDao<ElecSystemDDL> dao) {
		this.dao = dao;
	}

	@Override
	public List<ElecSystemDDLForm> findObjectsByConditions(ElecSystemDDLForm valueObject) {
		ElecSystemDDLForm vo = (ElecSystemDDLForm)valueObject;
		
		StringBuilder conditionHql = new StringBuilder();
		ArrayList<String> params = new ArrayList<String>();
		
		if(!StringUtil.isEmpty(vo.getKeyword())) {
			conditionHql.append(" and o.keyword=?");
			params.add(vo.getKeyword());
		}
		if(!StringUtil.isEmpty(vo.getDdlname())) {
			conditionHql.append(" and o.ddlname=?");
			params.add(vo.getDdlname());
		}
		
		if(StringUtil.isEmpty(conditionHql)) {
			return null;
		}
		
		LinkedHashMap<String, String> orderBy = new LinkedHashMap<String, String>();
		orderBy.put(" o.seqId", "asc");
		
		List<ElecSystemDDL> queryResult = dao.findObjectsByConditions(conditionHql.toString(), params, orderBy);
		return changePo2VoList(queryResult);
	}

	@Override
	public List<ElecSystemDDLForm> findKeyWord() {
		IElecSystemDDLDao ddlDao = (IElecSystemDDLDao)dao;
		
		List<String> keyWords = ddlDao.findKeywords();
		return changePo2VoListFromListString(keyWords);
	}

	@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	@Override
	public void saveSystemDDLList(ElecSystemDDLForm form) {
		String keyword = form.getKeywordname();
		String type = form.getTypeflag();
		String[] saveItems = form.getItemname();
		
		//如果为新增，先查询数据库中是否已有此项
		String s = " AND o.keyword='"+keyword+"'";
		List<ElecSystemDDL> result = dao.findObjectsByConditions(s, null, null);
		if(type.equals("new")) {
			if(!ColUtil.isEmpty(result)) {
				return;
			}
			
			int i = 1;
			for(String si : saveItems) {
				ElecSystemDDL esd = new ElecSystemDDL();
				esd.setKeyword(keyword);
				esd.setDdlCode(i++);
				esd.setDdlname(si);
				
				dao.save(esd);
			}
		}
		else if(type.equals("add")) {
			if(ColUtil.isEmpty(result)) {
				return;
			}
			
			int maxlength = result.size();
			if(saveItems.length >= result.size()) {
				maxlength = saveItems.length;
			}
			
			for(int i=0; i<maxlength; i++) {
				if(i < result.size()) {
					//当前数据存在于数据库中
					ElecSystemDDL ddl = result.get(i);
					if(i < saveItems.length) {
						//当前数据也存在于表单数据中
						//如果，当前数据中与表单中不一致，进行更改保存
						if(!ddl.getDdlname().equals(saveItems[i])) {
							ddl.setDdlname(saveItems[i]);
							dao.save(ddl);
						}
					} else {
						//数据不在表单数据中，则从数据库中删除
						dao.deleteObject(ddl);
					}
				} else {
					//已经不存在于数据中
					if(i < saveItems.length) {
						//但存在于表单数据中
						ElecSystemDDL ddl = new ElecSystemDDL();
						ddl.setKeyword(keyword);
						ddl.setDdlCode(i+1);
						ddl.setDdlname(saveItems[i]);
						
						dao.save(ddl);
					}
				}
			}
		}
		
	}

	public List<ElecSystemDDLForm> changePo2VoList(List<ElecSystemDDL> pos) {
		if(pos == null) {
			return null;
		}
		
		ArrayList<ElecSystemDDLForm> result = new ArrayList<ElecSystemDDLForm>();
		for(ElecSystemDDL ddl : pos) {
			ElecSystemDDLForm form = new ElecSystemDDLForm();
			form.setSeqId(ddl.getSeqId());
			form.setDdlCode(ddl.getDdlCode());
			form.setDdlname(ddl.getDdlname());
			form.setKeyword(ddl.getKeyword());
			result.add(form);
		}
		return result;
	}

	public List<ElecSystemDDLForm> changePo2VoListFromListString(List<String> pos) {
		if(pos == null) {
			return null;
		}
		
		ArrayList<ElecSystemDDLForm> result = new ArrayList<ElecSystemDDLForm>();
		for(String keyword : pos) {
			ElecSystemDDLForm form = new ElecSystemDDLForm();
			form.setKeyword(keyword);
			result.add(form);
		}
		return result;
	}

	@Override
	public List<ElecSystemDDLForm> findDdlListByKeyword(String keyword) {
		StringBuilder conSql = new StringBuilder();
		conSql.append(" and o.keyword=?");
		ArrayList<String> params = new ArrayList<String>(1);
//		params.add("'"+keyword+"'");
		params.add(keyword);
		
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("ddlCode", "asc");
		
		List<ElecSystemDDL> ddlList = dao.findObjectsByConditions(conSql.toString(), params, orderby);
		
		return changePo2VoList(ddlList);
	}

	@Override
	public ElecSystemDDLForm findObjectByVo(ElecSystemDDLForm form) {
		return null;
	}
}
