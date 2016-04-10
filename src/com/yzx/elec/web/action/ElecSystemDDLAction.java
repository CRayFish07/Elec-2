package com.yzx.elec.web.action;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ModelDriven;
import com.yzx.elec.service.IElecSystemDDlService;
import com.yzx.elec.web.form.ElecSystemDDLForm;

public class ElecSystemDDLAction extends BaseAction implements ModelDriven<ElecSystemDDLForm> {
	private static final long serialVersionUID = -8232321081484774787L;

	private ElecSystemDDLForm form;
	@Resource(name=IElecSystemDDlService.SERVICE_NAME)
	private IElecSystemDDlService service;
	
	@Override
	public ElecSystemDDLForm getModel() {
		return form;
	}

	
	public String home() {
		ArrayList<String> keywords = service.findKeyWord();
		return "home";
	}
}
