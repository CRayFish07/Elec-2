package com.yzx.elec.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface ICommonService<T> {
	public void save(T entity);

	public void update(T entity);

	public T findObjectById(Serializable id);

	public void delectObjectByIds(Serializable... ids);

	public void deleteObjects(Collection<T> entities);

	public List<T> findObjectsByConditions(Object valueObject);
}
