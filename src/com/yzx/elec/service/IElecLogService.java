package com.yzx.elec.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yzx.elec.web.form.ElecLogForm;

public interface IElecLogService {
	public static final String SERVICE_NAME = "com.yzx.elec.service.impl.ElecLogServiceImpl";
	
	public void log(HttpServletRequest request, String detail);

	public List<ElecLogForm> findAllLog();
}
