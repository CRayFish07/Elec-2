package com.yzx.elec.web.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.yan.util.xml.XmlObject;
import com.yzx.elec.container.ServiceProvider;
import com.yzx.elec.service.IElecRoleService;
import com.yzx.elec.service.IElecSystemDDlService;
import com.yzx.elec.web.form.ElecRolePopedomForm;
import com.yzx.elec.web.form.ElecSystemDDLForm;


/**
 * 
 * @author yzx<br/>
 * �������� 2016��4��29��
 */
public class ElecRoleAction extends BaseAction implements ModelDriven<ElecRolePopedomForm> {
	private static final long serialVersionUID = 1L;
	
	public static final String ROLE = "��ɫ����";
	
	private ElecRolePopedomForm form = new ElecRolePopedomForm();
	
	private IElecSystemDDlService systemDDLService = (IElecSystemDDlService)ServiceProvider.getService(IElecSystemDDlService.SERVICE_NAME);
	private IElecRoleService roleService = (IElecRoleService)ServiceProvider.getService(IElecRoleService.SERVICE_NAME);
	
	@Override
	public ElecRolePopedomForm getModel() {
		return form;
	}
	
	public String home() {
		//�����ݿ��ѯ�����еĽ�ɫ
		List<ElecSystemDDLForm> allRoles = systemDDLService.findDdlListByKeyword(ROLE);
		request.setAttribute("systemList", allRoles);
		
		//��Function.xml�ļ��в�ѯ������Ȩ��
		List<XmlObject> functionList = roleService.readRoleFunctionList();
		request.setAttribute("xmlList", functionList);
		
		return "home";
	}
	
	public String edit() {
		String roleId = form.getRole();
		List<XmlObject> xmlList = roleService.readEditXml(roleId);
		request.setAttribute("xmlList", xmlList);
		return "edit";
	}

}
