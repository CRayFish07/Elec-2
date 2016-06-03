package com.yzx.elec.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.yzx.elec.dao.IElecUserRoleDao;
import com.yzx.elec.pojo.ElecUserRole;

@Repository(IElecUserRoleDao.DAO_NAME)
public class ElecUserRoleDaoImpl extends CommonDaoImpl<ElecUserRole> implements IElecUserRoleDao {
	
	public static String FIND_USER_SQL_BY_ROLEID = null;
	static {
		StringBuilder tempBuilder = new StringBuilder(); 
		tempBuilder = new StringBuilder();
		tempBuilder.append("select");
		tempBuilder.append(" case roleId when ? then '1' else '0' end as flag,");
		tempBuilder.append(" elec_user.UserId,");
		tempBuilder.append(" elec_user.UserName,");
		tempBuilder.append(" elec_user.LogonName");
		tempBuilder.append(" from elec_user_role");
		tempBuilder.append(" right join elec_user");
		tempBuilder.append(" on elec_user_role.userId = elec_user.UserId");
		tempBuilder.append(" AND elec_user_role.roleId = ?");
		tempBuilder.append(" AND elec_user.isDuty = '1'");
		
		FIND_USER_SQL_BY_ROLEID = tempBuilder.toString();
	}
			
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findUserListByRoleId(String roleId) {
		final ArrayList<String> params = new ArrayList<String>();
		params.add(roleId);
		params.add(roleId);
		
		List<Object[]> result = (List<Object[]>)ht.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createSQLQuery(FIND_USER_SQL_BY_ROLEID);
				setQueryParams(query, params);
				
				return query.list();
			}
		});
		
		return result;
	}

}
