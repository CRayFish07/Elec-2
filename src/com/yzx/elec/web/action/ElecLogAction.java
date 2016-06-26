package com.yzx.elec.web.action;

import java.util.List;

import com.yzx.elec.container.ServiceProvider;
import com.yzx.elec.service.IElecLogService;
import com.yzx.elec.web.form.ElecLogForm;

public class ElecLogAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	
	private IElecLogService logService = (IElecLogService)ServiceProvider.getService(IElecLogService.SERVICE_NAME);
	
	public String home() {
		//取得所有的日志记录
		List<ElecLogForm> logForms = logService.findAllLog();
		request.setAttribute("logList", logForms);
		return "home";
	}
}
