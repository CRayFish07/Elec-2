package com.yzx.elec.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.yan.util.xml.XmlObject;
import com.yzx.elec.web.form.ElecRolePopedomForm;
import com.yzx.elec.web.form.ElecSystemDDLForm;
import com.yzx.elec.web.form.ElecUserForm;

/**
 * 
 * @author yzx<br/>
 * 创建日期 2016年4月29日
 */
@Transactional(readOnly=true)
public interface IElecRoleService {
	public static final String SERVICE_NAME = "com.yzx.elec.service.impl.IElecRoleServiceImpl";

	/**
	 * 取得所有角色
	 */
	public List<ElecSystemDDLForm> getAllService();

	public List<XmlObject> readRoleFunctionList();
	
	/**
	 * 根据角色id查询角色拥有的权限集合
	 * @param roleId 角色id
	 */
	public List<XmlObject> readEditXml(String roleId);

	/**
	 * 根据角色id查找对应的用户列表
	 */
	public List<ElecUserForm> findElecUserListByRoleId(String roleId);

	/**
	 * 保存角色
	 */
	public void saveRole(ElecRolePopedomForm form);
}
