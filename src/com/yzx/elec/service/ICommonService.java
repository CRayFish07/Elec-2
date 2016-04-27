package com.yzx.elec.service;

import java.util.Collection;
import java.util.List;

/**
 * 通用服务接口
 * @author Administrator
 *
 * @param <T> po类型
 * @param <V> vo类型
 */
public interface ICommonService<T, V> {
	/**
	 * 存储一个实体对象
	 */
	public void save(V entity);

	/**
	 * 更新一个实体对象
	 * @param entity
	 */
	public void update(T entity);

	/**
	 * 根据id查找一个实体
	 */
	public V findObjectByVo(V vo);

	/**
	 * 删除实体集合
	 */
	public void deleteObjects(Collection<V> entities);

	/**
	 * 根据值对象的条件查找满足条件的实体，并将结果转化为值对象集合返回
	 */
	public List<V> findObjectsByConditions(V valueObject);
}
