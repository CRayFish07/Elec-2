package com.yzx.elec.service;

import javax.servlet.http.HttpServletRequest;

public interface IElecLogService {
	public static final String SERVICE_NAME = "com.yzx.elec.service.impl.ElecLogServiceImpl";
	
	public void log(HttpServletRequest request, String detail);
}
