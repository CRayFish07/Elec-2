package com.yzx.elec.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface ICommonService<T, V> {
	public void save(T entity);

	public void update(T entity);

	public T findObjectById(Serializable id);

	public void delectObjectByIds(Serializable... ids);

	public void deleteObjects(Collection<T> entities);

	public List<V> findObjectsByConditions(V valueObject);
	
	public List<V> changePo2VoList(List<T> pos);
}
