package com.yzx.elec.service;

import java.util.HashMap;
import java.util.List;

import com.yzx.elec.web.form.ElecUserForm;

public interface IElecUserService {
	public static final String SERVICE_NAME = "com.yzx.elec.service.impl.ElecUserServiceImpl";
	
	public void deleteUsers(ElecUserForm... users);

	public String checkUserExists(String logonName);

	public List<ElecUserForm> findUserByIdAndPassword(String logonName, String logonPassword);

	/**
	 * �����û�id��ѯ�û���Ӧ�Ľ�ɫ
	 * @param userId �û�id
	 * @return keyΪ��ɫid��valueΪ��ɫ��
	 */
	public HashMap<Integer, String> findUserRolesByUserId(int userId);

	public List<ElecUserForm> findObjectsByConditions(ElecUserForm form);

	public ElecUserForm findObjectByVo(ElecUserForm userForm);

	public void save(ElecUserForm form);
}
