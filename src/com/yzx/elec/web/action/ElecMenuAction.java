package com.yzx.elec.web.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.xiang.encrypt.Md5Util;
import com.yzx.elec.container.ServiceProvider;
import com.yzx.elec.service.IElecCommonMsgService;
import com.yzx.elec.service.IElecUserService;
import com.yzx.elec.web.form.ElecCommonMsgForm;
import com.yzx.elec.web.form.ElecMenuForm;
import com.yzx.elec.web.form.ElecUserForm;

public class ElecMenuAction extends BaseAction implements ModelDriven<ElecMenuForm> {
	
	private static final long serialVersionUID = 1L;
	private ElecMenuForm form = new ElecMenuForm();
	
	private IElecUserService userService = (IElecUserService)ServiceProvider.getService(IElecUserService.SERVICE_NAME);
	
	@Override
	public ElecMenuForm getModel() {
		return form;
	}
	
	public String home() {
		ElecUserForm userForm = new ElecUserForm();
		userForm.setLogonName(form.getName());
		userForm.setLogonPassword(Md5Util.getInstance().makeMD5(form.getPassword()));
		List<ElecUserForm> forms = userService.findObjectsByConditions(userForm);
		if(forms == null || forms.get(0) == null) {
			this.addFieldError("error", "��¼ʧ�ܣ��û������������");
			return "error";
		}
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
