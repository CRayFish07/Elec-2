package com.yzx.elec.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 通用dao接口
 * @author yzx
 */
public interface ICommonDao<T> {
	/**
	 * 存储对象
	 */
	public void save(T entity);
	/**
	 * 更新对象数据
	 */
	public void update(T entity);
	/**
	 * 根据对象id查找对象
	 */
	public T findObjectById(Serializable id);
	/**
	 * 根据对象id删除对象
	 */
	public void deleteObjectByIds(Serializable... ids);
	/**
	 * 删除指定对象，默认根据对象id值
	 */
	public void deleteObjects(Collection<T> entities);
	/**
	 * 通过指定条件查找对象
	 * @param conditionHql 条件语句
	 * @param params 参数
	 * @param orderBy 排序参数，例如：&lt;datetime,dsc&gt;
	 * @return 查询到的对象列表
	 */
	public List<T> findObjectsByConditions(String conditionHql, ArrayList<String> params, LinkedHashMap<String, String> orderBy);
	public void deleteObject(T t);
	
	/**
	 * 存储实体集合
	 * @param userRoles
	 */
	public void saveAllEntities(List<T> entites);
	
	/**
	 * 执行hql语句查找符合条件的对象
	 * @param sql 要执行的sql语句
	 * @param params 执行语句中的参数
	 */
	public List<T> findListBySql(String hql, Object[] params);
	
	/**
	 * 根据sql语句查询对象列表
	 * @param exeSql 执行的sql语句
	 * @param params 参数
	 */
	public List<Object[]> findObjectListBySql(String exeSql, Object[] params);
}
