package com.yzx.elec.web.action;

import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.yan.util.ColUtil;
import com.yzx.elec.container.ServiceProvider;
import com.yzx.elec.service.IElecSystemDDlService;
import com.yzx.elec.service.IElecUserService;
import com.yzx.elec.web.form.ElecSystemDDLForm;
import com.yzx.elec.web.form.ElecUserForm;

@SuppressWarnings("serial")
public class ElecUserAction extends BaseAction implements ModelDriven<ElecUserForm> {
	private IElecUserService service = (IElecUserService)ServiceProvider.getService(IElecUserService.SERVICE_NAME);
	private IElecSystemDDlService ddlService = (IElecSystemDDlService)ServiceProvider.getService(IElecSystemDDlService.SERVICE_NAME);
	private ElecUserForm form = new ElecUserForm();
	
	public static final String SEX = "�Ա�";
	public static final String JCT = "������λ";
	public static final String IS_DUTY = "�Ƿ���ְ";
	
	@Override
	public ElecUserForm getModel() {
		return form;
	}
	
	
	public String home() {
		@SuppressWarnings("unchecked")
		HashMap<Integer, String> roles = (HashMap<Integer, String>)request.getSession().getAttribute("global_role");
		if(ColUtil.isEmpty(roles)) {
			this.addFieldError("error", "��¼ʧ�ܣ����κ�Ȩ��");
			return "error";
		}
		
		if(roles.containsKey(0) || roles.containsKey(1)) {
			List<ElecUserForm> list = service.findObjectsByConditions(form);
			request.setAttribute("userList", list);
			return "home";
		} else {
			ElecUserForm userForm = (ElecUserForm)request.getSession().getAttribute("global_user");
			ElecUserForm detailUser = service.findObjectByVo(userForm);
			
			ActionContext.getContext().getValueStack().push(detailUser);
			initSystemDDL();
			return "edit";
		}
		
//		List<ElecUserForm> list = service.findObjectsByConditions(form);
//		request.setAttribute("userList", list);
//		return "home";
	}
	
	public String add() {
		//��ѯ�����ֵ䣬��ѯ�Ա�������λ���Լ��Ƿ���ְ���������ֵ��еı���Լ�����
		initSystemDDL();
		return "add";
	}
	
	public String save() {
		service.save(form);
		
		return "delete";
	}
	
	public String edit() {
		service.findObjectByVo(form);
//		ActionContext.getContext().getValueStack().push(userData);
		initSystemDDL();
		request.setAttribute("viewflag", form.getViewflag());
		return "edit";
	}
	
	public String delete() {
		service.deleteUsers(form);
		return "delete";
	}


	private void initSystemDDL() {
		List<ElecSystemDDLForm> sexDdl = ddlService.findDdlListByKeyword(SEX);
		List<ElecSystemDDLForm> jctDdl = ddlService.findDdlListByKeyword(JCT);
		List<ElecSystemDDLForm> isDutyDdl = ddlService.findDdlListByKeyword(IS_DUTY);
		request.setAttribute("sexList", sexDdl);
		request.setAttribute("jctList", jctDdl);
		request.setAttribute("isDutyList", isDutyDdl);
	}
}
