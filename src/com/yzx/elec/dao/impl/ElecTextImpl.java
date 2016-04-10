package com.yzx.elec.dao.impl;

import org.springframework.stereotype.Repository;

import com.yzx.elec.dao.IElecTextDao;
import com.yzx.elec.pojo.ElecText;

@Repository(IElecTextDao.DAO_NAME)
public class ElecTextImpl extends CommonDaoImpl<ElecText> implements IElecTextDao {

}
