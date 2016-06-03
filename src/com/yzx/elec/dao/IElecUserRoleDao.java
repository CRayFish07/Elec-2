package com.yzx.elec.dao;

import java.util.List;

import com.yzx.elec.pojo.ElecUserRole;

public interface IElecUserRoleDao extends ICommonDao<ElecUserRole> {
	public static final String DAO_NAME = "com.yzx.elec.dao.impl.ElecUserRoleDaoImpl";

	public List<Object[]> findUserListByRoleId(String roleId);
	
}
