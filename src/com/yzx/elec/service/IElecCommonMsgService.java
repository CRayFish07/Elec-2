package com.yzx.elec.service;

import java.util.List;

import com.yzx.elec.pojo.ElecCommonMsg;
import com.yzx.elec.web.form.ElecCommonMsgForm;

public interface IElecCommonMsgService extends ICommonService<ElecCommonMsg, ElecCommonMsgForm> {
	public static final String SERVICE_NAME = "com.yzx.elec.service.impl.ElecCommonMsgServiceImpl";
	public List<ElecCommonMsgForm> findAllObjects();
	public List<ElecCommonMsgForm> findCommonMsgByCurrentDate();
}
