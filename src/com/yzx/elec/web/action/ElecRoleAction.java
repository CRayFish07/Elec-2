package com.yzx.elec.web.action;

import com.yzx.elec.service.IElecRoleService;

/**
 * 
 * @author yzx<br/>
 * �������� 2016��4��29��
 */
@SuppressWarnings("serial")
public class ElecRoleAction extends BaseAction {
	private IElecRoleService service;
	
	public String home() {
		
		return "home";
	}
}
