package com.yzx.elec.service;

import java.util.List;

import com.yzx.elec.web.form.ElecCommonMsgForm;

public interface IElecCommonMsgService {
	public static final String SERVICE_NAME = "com.yzx.elec.service.impl.ElecCommonMsgServiceImpl";
	public List<ElecCommonMsgForm> findAllObjects();
	public List<ElecCommonMsgForm> findCommonMsgByCurrentDate();
	public void save(ElecCommonMsgForm form);
}
