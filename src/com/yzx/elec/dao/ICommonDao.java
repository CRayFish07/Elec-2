package com.yzx.elec.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * ͨ��dao�ӿ�
 * @author yzx
 */
public interface ICommonDao<T> {
	/**
	 * �洢����
	 */
	public void save(T entity);
	/**
	 * ���¶�������
	 */
	public void update(T entity);
	/**
	 * ���ݶ���id���Ҷ���
	 */
	public T findObjectById(Serializable id);
	/**
	 * ���ݶ���idɾ������
	 */
	public void deleteObjectByIds(Serializable... ids);
	/**
	 * ɾ��ָ������Ĭ�ϸ��ݶ���idֵ
	 */
	public void deleteObjects(Collection<T> entities);
	/**
	 * ͨ��ָ���������Ҷ���
	 * @param conditionHql �������
	 * @param params ����
	 * @param orderBy ������������磺&lt;datetime,dsc&gt;
	 * @return ��ѯ���Ķ����б�
	 */
	public List<T> findObjectsByConditions(String conditionHql, ArrayList<String> params, LinkedHashMap<String, String> orderBy);
}