package com.yzx.elec.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yzx.elec.dao.ICommonDao;
import com.yzx.elec.service.ICommonService;

public abstract class CommonServiceImpl<T, V> implements ICommonService<T, V> {
	protected ICommonDao<T> dao;
	protected abstract void setDao(ICommonDao<T> dao);
	
	@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	@Override
	public void save(V object) {
		
	}

	@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	@Override
	public void update(T object) {
		dao.update(object);
	}

	@Override
	public V findObjectByVo(V vo) {
		return null;
	}

	@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	@Override
	public void deleteObjects(Collection<V> entities) {
	}

	@Override
	public abstract List<V> findObjectsByConditions(V valueObject);
}
