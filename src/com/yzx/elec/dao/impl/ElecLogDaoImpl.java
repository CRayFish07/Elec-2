package com.yzx.elec.dao.impl;

import org.springframework.stereotype.Repository;

import com.yzx.elec.dao.IElecLogDao;
import com.yzx.elec.pojo.ElecLog;

@Repository(IElecLogDao.DAO_NAME)
public class ElecLogDaoImpl extends CommonDaoImpl<ElecLog> implements IElecLogDao {

}
