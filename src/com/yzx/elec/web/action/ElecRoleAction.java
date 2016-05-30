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
 * 创建日期 2016年4月29日
 */
public class ElecRoleAction extends BaseAction implements ModelDriven<ElecRolePopedomForm> {
	private static final long serialVersionUID = 1L;
	
	public static final String ROLE = "角色类型";
	
	private ElecRolePopedomForm form = new ElecRolePopedomForm();
	
	private IElecSystemDDlService systemDDLService = (IElecSystemDDlService)ServiceProvider.getService(IElecSystemDDlService.SERVICE_NAME);
	private IElecRoleService roleService = (IElecRoleService)ServiceProvider.getService(IElecRoleService.SERVICE_NAME);
	
	@Override
	public ElecRolePopedomForm getModel() {
		return form;
	}
	
	public String home() {
		//从数据库查询到所有的角色
		List<ElecSystemDDLForm> allRoles = systemDDLService.findDdlListByKeyword(ROLE);
		request.setAttribute("systemList", allRoles);
		
		//从Function.xml文件中查询到所有权限
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
