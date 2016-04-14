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

}
