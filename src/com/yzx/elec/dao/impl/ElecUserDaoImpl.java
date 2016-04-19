package com.yzx.elec.dao.impl;

import org.springframework.stereotype.Repository;

import com.yzx.elec.dao.IElecUserDao;
import com.yzx.elec.pojo.ElecUser;

@Repository(IElecUserDao.DAO_NAME)
public class ElecUserDaoImpl extends CommonDaoImpl<ElecUser> implements IElecUserDao {

}
