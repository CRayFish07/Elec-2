package com.yzx.elec.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yan.util.StringUtil;
import com.yzx.elec.dao.ICommonDao;
import com.yzx.elec.dao.IElecTextDao;
import com.yzx.elec.pojo.ElecText;
import com.yzx.elec.service.IElecTextService;
import com.yzx.elec.web.form.ElecTextForm;

@Transactional(readOnly=true)
@Service(IElecTextService.SERVICE_NAME)
public class ElecTextServiceImpl extends CommonServiceImpl<ElecText, ElecTextForm> implements IElecTextService {
	@Resource(name=IElecTextDao.DAO_NAME)
	@Override
	protected void setDao(ICommonDao<ElecText> dao) {
		this.dao = dao;
	}
	
	@Override
	public List<ElecTextForm> findObjectsByConditions(ElecTextForm valueObject) {
		if(valueObject == null) {
			return null;
		}
		
		ElecTextForm etf = (ElecTextForm)valueObject;
		
		//组织条件语句
		ArrayList<String> params = new ArrayList<String>();
		StringBuilder conditionHql = new StringBuilder();
		if(!StringUtil.isEmpty(etf.getTextname())) {
			conditionHql.append(" and o.textname like ?");
			params.add("%"+etf.getTextname()+"%");
		}
		if(!StringUtil.isEmpty(etf.getTextremark())) {
			conditionHql.append(" and o.textremark like ?");
			params.add("%"+etf.getTextremark()+"%");
		}
		
		//组织排序语句
		LinkedHashMap<String, String> orderBy = new LinkedHashMap<String, String>();
		orderBy.put("o.textdate", "desc");
		orderBy.put("o.textname", "asc");
//		conditionHql.append(" order by o.textdate desc, o.textname asc");
		return changePo2VoList(dao.findObjectsByConditions(conditionHql.toString(), params, orderBy));
	}

	@Override
	public List<ElecTextForm> changePo2VoList(List<ElecText> pos) {
		// TODO 自动生成的方法存根
		return null;
	}

}
