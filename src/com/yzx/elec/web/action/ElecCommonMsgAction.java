package com.yzx.elec.web.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.yzx.elec.container.ServiceProvider;
import com.yzx.elec.service.IElecCommonMsgService;
import com.yzx.elec.web.form.ElecCommonMsgForm;

@SuppressWarnings("serial")
public class ElecCommonMsgAction extends BaseAction implements ModelDriven<ElecCommonMsgForm> {
	private ElecCommonMsgForm form = new ElecCommonMsgForm();
	
	@Override
	public ElecCommonMsgForm getModel() {
		return form;
	}

	public String actingIndex() {
		IElecCommonMsgService commonMsg = (IElecCommonMsgService)ServiceProvider.getService(IElecCommonMsgService.SERVICE_NAME);
		List<ElecCommonMsgForm> msgList = commonMsg.findAllObjects();
		request.setAttribute("commonList", msgList);
		return "actingIndex";
	}
	
	public String saveMsg() {
		IElecCommonMsgService service = (IElecCommonMsgService)ServiceProvider.getService(IElecCommonMsgService.SERVICE_NAME);
		service.save(form);
		return "saveMsg";
	}
}
