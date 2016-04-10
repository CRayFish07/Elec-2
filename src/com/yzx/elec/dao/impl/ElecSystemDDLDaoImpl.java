package com.yzx.elec.dao.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.yzx.elec.dao.IElecSystemDDLDao;
import com.yzx.elec.pojo.ElecSystemDDL;

@Repository(IElecSystemDDLDao.DAO_NAME)
public class ElecSystemDDLDaoImpl extends CommonDaoImpl<ElecSystemDDL> implements IElecSystemDDLDao {

	@Override
	public ArrayList<String> findKeywords() {
		String hql = "select distinct o.keyword from elecsystemddl";
		getHibernateTemplate().find(hql);
		return null;
	}

}
