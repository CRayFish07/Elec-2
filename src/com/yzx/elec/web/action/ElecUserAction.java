package com.yzx.elec.web.action;

import com.opensymphony.xwork2.ModelDriven;
import com.yzx.elec.container.ServiceProvider;
import com.yzx.elec.service.IElecUserService;
import com.yzx.elec.web.form.ElecUserForm;

@SuppressWarnings("serial")
public class ElecUserAction extends BaseAction implements ModelDriven<ElecUserForm> {
	private IElecUserService service = (IElecUserService)ServiceProvider.getService(IElecUserService.SERVICE_NAME);
	private ElecUserForm form = new ElecUserForm();
	@Override
	public ElecUserForm getModel() {
		return form;
	}
	
	
	public String home() {
		service.findObjectsByConditions(null);
		return "home";
	}
}
