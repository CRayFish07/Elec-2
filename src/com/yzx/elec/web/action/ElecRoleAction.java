package com.yzx.elec.web.action;

import com.yzx.elec.service.IElecRoleService;

/**
 * 
 * @author yzx<br/>
 * 创建日期 2016年4月29日
 */
@SuppressWarnings("serial")
public class ElecRoleAction extends BaseAction {
	private IElecRoleService service;
	
	public String home() {
		
		return "home";
	}
}
