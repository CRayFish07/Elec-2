package com.yzx.elec.web.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.yzx.elec.container.ServiceProvider;
import com.yzx.elec.service.IElecCommonMsgService;
import com.yzx.elec.web.form.ElecCommonMsgForm;
import com.yzx.elec.web.form.ElecMenuForm;

public class ElecMenuAction extends BaseAction implements ModelDriven<ElecMenuForm> {
	
	private static final long serialVersionUID = 1L;
	private ElecMenuForm emf = new ElecMenuForm();
	
	@Override
	public ElecMenuForm getModel() {
		return emf;
	}
	
	public String home() {
		return "home";
	}
	
	public String title() {
		return "title";
	}
	
	public String left() {
		return "left";
	}
	
	public String change1() {
		return "change1";
	}
	
	public String loading() {
		return "loading";
	}
	
	public String alermYS() {
		return "alermYS";
	}
	
	public String alermSB() {
		IElecCommonMsgService service = (IElecCommonMsgService)ServiceProvider.getService(IElecCommonMsgService.SERVICE_NAME);
		List<ElecCommonMsgForm> msgs = service.findCommonMsgByCurrentDate();
		
		request.setAttribute("commonList", msgs);
		return "alermSB";
	}
	
	public String alermZD() {
		IElecCommonMsgService service = (IElecCommonMsgService)ServiceProvider.getService(IElecCommonMsgService.SERVICE_NAME);
		List<ElecCommonMsgForm> msgs = service.findCommonMsgByCurrentDate();
		
		request.setAttribute("commonList", msgs);
		return "alermZD";
	}
	
	public String alermJX() {
		return "alermJX";
	}
	
	public String alermXZ() {
		return "alermXZ";
	}
}
