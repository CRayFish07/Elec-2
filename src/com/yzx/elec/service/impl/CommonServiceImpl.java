package com.yzx.elec.service.impl;

import java.io.Serializable;
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
	public void save(T object) {
		dao.save(object);
	}

	@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	@Override
	public void update(T object) {
		dao.update(object);
	}

	@Override
	public T findObjectById(Serializable id) {
		return dao.findObjectById(id);
	}

	@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	@Override
	public void delectObjectByIds(Serializable... ids) {
		dao.deleteObjectByIds(ids);
	}

	@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	@Override
	public void deleteObjects(Collection<T> entities) {
		dao.deleteObjects(entities);
	}

	@Override
	public abstract List<V> findObjectsByConditions(V valueObject);
}
