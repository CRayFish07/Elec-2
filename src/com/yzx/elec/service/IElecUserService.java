package com.yzx.elec.service;

import com.yzx.elec.pojo.ElecUser;
import com.yzx.elec.web.form.ElecUserForm;

public interface IElecUserService extends ICommonService<ElecUser, ElecUserForm> {
	public static final String SERVICE_NAME = "com.yzx.elec.service.impl.ElecUserServiceImpl";
	
	public void deleteUsers(ElecUserForm... users);

	public String checkUserExists(String logonName);
}
