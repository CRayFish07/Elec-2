package com.yzx.elec.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.yzx.elec.dao.IElecCommonMsgDao;
import com.yzx.elec.pojo.ElecCommonMsg;

@Repository(IElecCommonMsgDao.DAO_NAME)
public class ElecCommonMsgDaoImpl extends CommonDaoImpl<ElecCommonMsg> implements IElecCommonMsgDao {
	/**
	 * 根据日期查找代办事宜
	 * @param date 查询日期
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> findElecCommonMsgByDate(String date) {
		final String sql = "select o.StationRun,o.DevRun"+
					" from elec_commonmsg o"+
					" where CreateDate like '"+date+"%'";
		
		List<Object[]> list = (List<Object[]>)getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createSQLQuery(sql)
						.addScalar("StationRun", Hibernate.STRING)
						.addScalar("DevRun", Hibernate.STRING);
				return query.list();
			}
		});
		
		return list;
	}
}
