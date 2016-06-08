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
 * �������� 2016��4��29��
 */
@Transactional(readOnly=true)
public interface IElecRoleService {
	public static final String SERVICE_NAME = "com.yzx.elec.service.impl.IElecRoleServiceImpl";

	/**
	 * ȡ�����н�ɫ
	 */
	public List<ElecSystemDDLForm> getAllService();

	public List<XmlObject> readRoleFunctionList();
	
	/**
	 * ���ݽ�ɫid��ѯ��ɫӵ�е�Ȩ�޼���
	 * @param roleId ��ɫid
	 */
	public List<XmlObject> readEditXml(String roleId);

	/**
	 * ���ݽ�ɫid���Ҷ�Ӧ���û��б�
	 */
	public List<ElecUserForm> findElecUserListByRoleId(String roleId);

	/**
	 * �����ɫ
	 */
	public void saveRole(ElecRolePopedomForm form);
}
