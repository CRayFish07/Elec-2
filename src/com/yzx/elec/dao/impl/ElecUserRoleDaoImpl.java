package com.yzx.elec.dao.impl;

import org.springframework.stereotype.Repository;

import com.yzx.elec.dao.IElecUserRoleDao;
import com.yzx.elec.pojo.ElecUserRole;

@Repository(IElecUserRoleDao.DAO_NAME)
public class ElecUserRoleDaoImpl extends CommonDaoImpl<ElecUserRole> implements IElecUserRoleDao {

}
