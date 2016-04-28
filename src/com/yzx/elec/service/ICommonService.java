package com.yzx.elec.service;

import java.util.Collection;
import java.util.List;

/**
 * ͨ�÷���ӿ�
 * @author Administrator
 *
 * @param <T> po����
 * @param <V> vo����
 */
public interface ICommonService<T, V> {
	/**
	 * �洢һ��ʵ�����
	 */
	public void save(V entity);

	/**
	 * ����һ��ʵ�����
	 * @param entity
	 */
	public void update(T entity);

	/**
	 * ����id����һ��ʵ��
	 */
	public V findObjectByVo(V vo);

	/**
	 * ɾ��ʵ�弯��
	 */
	public void deleteObjects(Collection<V> entities);

	/**
	 * ����ֵ�����������������������ʵ�壬�������ת��Ϊֵ���󼯺Ϸ���
	 */
	public List<V> findObjectsByConditions(V valueObject);
}
