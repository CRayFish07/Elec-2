package com.yzx.elec.web.action;

import com.opensymphony.xwork2.ModelDriven;
import com.yzx.elec.container.ServiceProvider;
import com.yzx.elec.pojo.ElecText;
import com.yzx.elec.service.IElecTextService;
import com.yzx.elec.web.form.ElecTextForm;

public class ElecTextFormAction extends BaseAction implements ModelDriven<ElecTextForm> {
	
	private static final long serialVersionUID = 1L;
	private ElecTextForm elecTextForm = new ElecTextForm();
	
	private IElecTextService service = (IElecTextService)ServiceProvider.getService(IElecTextService.SERVICE_NAME);
	
	@Override
	public ElecTextForm getModel() {
		return elecTextForm;
	}
	
	public String save() {
		ElecText et = new ElecText();
		et.setTextname(elecTextForm.getTextname());
		et.setTextdate(elecTextForm.getTextdate());
		et.setTextremark(elecTextForm.getTextremark());
		
		service.save(et);
		return "save";
	}
}
