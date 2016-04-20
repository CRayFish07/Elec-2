package com.yzx.elec.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yzx.elec.dao.IElecSystemDDLDao;
import com.yzx.elec.pojo.ElecSystemDDL;

@Repository(IElecSystemDDLDao.DAO_NAME)
public class ElecSystemDDLDaoImpl extends CommonDaoImpl<ElecSystemDDL> implements IElecSystemDDLDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findKeywords() {
		String hql = "select distinct o.keyword from ElecSystemDDL o";
		return (List<String>)getHibernateTemplate().find(hql);
	}

	@Override
	public String getDDLName(String keyword, String ddlCode) {
		String hql = "select o.ddlname from ElecSystemDDL o";
		hql += " where o.keyword = '"+keyword+"'";
		hql += " and o.ddlCode = '"+ddlCode+"'";
		
		@SuppressWarnings("rawtypes")
		List list = ht.find(hql);
		return (String)list.get(0);
	}

}
