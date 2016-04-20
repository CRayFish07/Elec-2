package com.yzx.elec.web.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.yzx.elec.container.ServiceProvider;
import com.yzx.elec.service.IElecSystemDDlService;
import com.yzx.elec.web.form.ElecSystemDDLForm;

public class ElecSystemDDLAction extends BaseAction implements ModelDriven<ElecSystemDDLForm> {
	private static final long serialVersionUID = -8232321081484774787L;

	private ElecSystemDDLForm form = new ElecSystemDDLForm();
	private IElecSystemDDlService service = (IElecSystemDDlService)ServiceProvider.getService(IElecSystemDDlService.SERVICE_NAME);
	
	@Override
	public ElecSystemDDLForm getModel() {
		return form;
	}

	
	public String home() {
		List<ElecSystemDDLForm> keywords = service.findKeyWord();
		request.setAttribute("systemlist", keywords);
		return "home";
	}
	
	public String edit() {
		request.setAttribute("systemList", service.findObjectsByConditions(form));
		return "edit";
	}
	
	public String save() {
		service.saveSystemDDLList(form);
		return "save";
	}

}
