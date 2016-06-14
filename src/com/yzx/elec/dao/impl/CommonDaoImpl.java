package com.yzx.elec.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yan.util.ColUtil;
import com.yan.util.GenericSuperClassUtil;
import com.yzx.elec.dao.ICommonDao;

public class CommonDaoImpl<T> extends HibernateDaoSupport implements ICommonDao<T> {
	/**
	 * 泛型的类型参数
	 */
	@SuppressWarnings("rawtypes")
	private Class c = GenericSuperClassUtil.getActualTypeClass4One(this.getClass());
	protected HibernateTemplate ht = null;
	
	@Override
	public void save(T entity) {
		ht.save(entity);
	}

	@Override
	public void update(T entity) {
		ht.update(entity);
	}
	
	@Resource(name="sessionFactory")
	public final void setSessionFactoryDiy(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
		ht = getHibernateTemplate();
	}

	@SuppressWarnings({"unchecked"})
	@Override
	public T findObjectById(Serializable id) {
		return (T)ht.get(c, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteObjectByIds(Serializable... ids) {
		if(ids == null) {
			return;
		}
		
		HibernateTemplate ht = getHibernateTemplate();
		for(Serializable id : ids) {
			T object = (T)ht.get(c, id);
			ht.delete(object);
		}
	}

	@Override
	public void deleteObjects(Collection<T> entities) {
		ht.deleteAll(entities);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findObjectsByConditions(String conditionHql, final ArrayList<String> params,
			LinkedHashMap<String, String> orderBy) {
		
		StringBuilder hql = new StringBuilder(" FROM "+c.getSimpleName()+" o WHERE 1=1");
		if(conditionHql != null) {
			hql.append(conditionHql);
		}
		String orderHql = getOrderByHql(orderBy);
		if(orderHql != null) {
			hql.append(orderHql);
		}
		
		final String hqlStr = hql.toString();
		List<T> result = (List<T>)executeSelectHql(hqlStr, params);
		return result;
	}

	private Object executeSelectHql(final String hqlStr, final ArrayList<String> params) {
		return ht.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hqlStr);
				setQueryParams(query, params);
				
				return query.list();
			}
		});
	}

	protected void setQueryParams(Query query, ArrayList<String> params) {
		if(!ColUtil.isEmpty(params)) {
			for(int i=0; i<params.size(); i++) {
				query.setParameter(i, params.get(i));
			}
		}
	}
	
	protected void setQueryParams(SQLQuery query, Object[] params) {
		if(!ColUtil.isEmpty(params)) {
			for(int i=0; i<params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
	}

	private String getOrderByHql(LinkedHashMap<String, String> orderBy) {
		if(ColUtil.isEmpty(orderBy)) {
			return null;
		}
		StringBuilder hql = new StringBuilder(" ORDER BY");
		Iterator<Entry<String, String>> orderFields = orderBy.entrySet().iterator();
		while(orderFields.hasNext()) {
			Entry<String, String> entry = orderFields.next();
			hql.append(" "+entry.getKey()+" "+entry.getValue()+",");
		}
		hql.deleteCharAt(hql.length()-1);
		
		return hql.toString();
	}

	@Override
	public void deleteObject(T t) {
		ht.delete(t);
	}

	@Override
	public void saveAllEntities(List<T> entites) {
		ht.saveOrUpdateAll(entites);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findListBySql(String sql, Object[] params) {
		return ht.find(sql, params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findObjectListBySql(final String exeSql, final Object[] params) {
		return (List<Object[]>)ht.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				SQLQuery sql = session.createSQLQuery(exeSql);
				setQueryParams(sql, params);
				return sql.list();
			}
		});
	}

}
