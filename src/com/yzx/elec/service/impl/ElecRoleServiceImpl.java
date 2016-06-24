package com.yzx.elec.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.apache.struts2.ServletActionContext;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yan.util.ColUtil;
import com.yan.util.StringUtil;
import com.yan.util.xml.XmlObject;
import com.yzx.elec.dao.IElecRolePopedomDao;
import com.yzx.elec.dao.IElecUserRoleDao;
import com.yzx.elec.pojo.ElecRolePopedom;
import com.yzx.elec.pojo.ElecUserRole;
import com.yzx.elec.service.IElecRoleService;
import com.yzx.elec.web.form.ElecRolePopedomForm;
import com.yzx.elec.web.form.ElecSystemDDLForm;
import com.yzx.elec.web.form.ElecUserForm;

/**
 * 角色服务
 * @author yzx<br/>
 * 创建日期 2016年4月29日
 */
@Transactional(readOnly=true)
@Service(IElecRoleService.SERVICE_NAME)
public class ElecRoleServiceImpl implements IElecRoleService {
	/**
	 * 角色权限dao
	 */
	@Resource(name=IElecRolePopedomDao.DAO_NAME)
	private IElecRolePopedomDao rolePopedomDao;
	
	/**
	 * 用户角色dao
	 */
	@Resource(name=IElecUserRoleDao.DAO_NAME)
	private IElecUserRoleDao userRoleDao;
	
	private static List<XmlObject> xmlList = null;

	@Override
	public List<ElecSystemDDLForm> getAllService() {
		return null;
	}

	@Override
	public List<XmlObject> readRoleFunctionList() {
		if(xmlList != null) {
			return xmlList;
		}
		ServletContext context = ServletActionContext.getServletContext();
		String realPath = context.getRealPath("/WEB-INF/classes/Function.xml");
		
		File f = new File(realPath);
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(f);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		if(document == null) {
			return null;
		}
		
		Element ele = document.getRootElement();
		
//		ArrayList<XmlObject> result = null;
		@SuppressWarnings("unchecked")
		Iterator<Element> functions = ele.elementIterator("Function");
		if(functions != null) {
			xmlList = new ArrayList<XmlObject>();
			while(functions.hasNext()) {
				Element e = functions.next();
				
				XmlObject obj = new XmlObject();
				obj.setCode(e.elementText("FunctionCode"));
				obj.setName(e.elementText("FunctionName"));
				obj.setParentCode(e.elementText("ParentCode"));
				obj.setParentName(e.elementText("ParentName"));
				
				xmlList.add(obj);
			}
		}
		
		return xmlList;
	}

	@Override
	public List<XmlObject> readEditXml(String roleId) {
		ElecRolePopedom rolePopedom = rolePopedomDao.findObjectById(new Integer(roleId));
		String popedom = null;
		if(rolePopedom != null) {
			popedom = rolePopedom.getPopedomCode();
		}
		
		return readXmlPopedom(popedom);
	}
	
	/**
	 * 根据角色权限得到权限列表
	 */
	private List<XmlObject> readXmlPopedom(String popedom) {
		
		List<XmlObject> _xmlList = readRoleFunctionList();
	
		List<XmlObject> result = new ArrayList<XmlObject>();
		for(XmlObject obj : _xmlList) {
			if(obj == null) {
				continue;
			}
			
			//角色是否拥有此权限
			if(!StringUtil.isEmpty(popedom) && popedom.contains(obj.getCode())) {
				obj.setFlag(1);
			} else {
				obj.setFlag(0);
			}
			
			result.add(obj);
		}
		return result;
	}

	/**
	 * 拷贝权限列表
	 */
	@SuppressWarnings("unused")
	private List<XmlObject> copyFunctionList() {
		List<XmlObject> _xmlList = readRoleFunctionList();
		if(xmlList == null) {
			return null;
		}
		
		List<XmlObject> result = new ArrayList<XmlObject>();
		for(XmlObject obj : _xmlList) {
			if(obj == null) {
				result.add(null);
			} else {
				result.add(obj.copySelf());
			}
		}
		return result;
	}

	
	
	@Override
	public List<ElecUserForm> findElecUserListByRoleId(String roleId) {
		//查询到的原始数据
		List<Object[]> dataList = userRoleDao.findUserListByRoleId(roleId);
		
		List<ElecUserForm> userFormList = changeDataList2UserFormList(dataList);
		
		return userFormList;
	}

	private List<ElecUserForm> changeDataList2UserFormList(List<Object[]> dataList) {
		if(ColUtil.isEmpty(dataList)) {
			return null;
		}
		
		List<ElecUserForm> formList = new ArrayList<ElecUserForm>();
		
		for(Object[] userInfo : dataList) {
			if(ColUtil.isEmpty(userInfo)) {
				continue;
			}
			
			ElecUserForm userForm = new ElecUserForm();
			userForm.setFlag((String)userInfo[0]);
			userForm.setUserId((int)userInfo[1]);
			userForm.setUserName((String)userInfo[2]);
			userForm.setLogonName((String)userInfo[3]);
			
			formList.add(userForm);
		}
		
		return formList;
	}

	@Override
	@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	public void saveRole(ElecRolePopedomForm form) {
		int roleId = Integer.parseInt(form.getRole());
		
		ElecRolePopedom rolePopedom = rolePopedomDao.findObjectById(roleId);
		//是否只是更新
		boolean update = true;
		//角色不存在
		if(rolePopedom == null) {
			rolePopedom = new ElecRolePopedom();
			rolePopedom.setRoleId(roleId);
			update = false;
		}
		
		//设置角色权限
		String popedoms = StringUtil.strArray2OneString(form.getSelectoper(), null);
		//设置权限code
		rolePopedom.setPopedomCode(popedoms);
		if(update) {
			rolePopedomDao.update(rolePopedom);
		} else {
			rolePopedomDao.save(rolePopedom);
		}
		
		
		//移除掉所有的此角色和用户的关联
		userRoleDao.deleteObjectsByRoleId(roleId);
		String[] selectUsers = form.getSelectuser();
		List<ElecUserRole> userRoles = new ArrayList<ElecUserRole>();
		if(!ColUtil.isEmpty(selectUsers)) {
			for(String userId : selectUsers) {
				ElecUserRole userRole = new ElecUserRole();
				userRole.setRoleId(roleId);
				userRole.setUserId(Integer.parseInt(userId));
				userRoles.add(userRole);
			}
		}
		
		userRoleDao.saveAllEntities(userRoles);
	}

	@Override
	public String findRolePopedomsByRoleIds(ArrayList<Integer> roleIds) {
		if(ColUtil.isEmpty(roleIds)) {
			return null;
		}
		
		StringBuilder popedomString = new StringBuilder();
		for(int roleId : roleIds) {
			ElecRolePopedom rolePopedom = rolePopedomDao.findObjectById(roleId);
			if(rolePopedom == null) {
				continue;
			}
			
			popedomString.append(rolePopedom.getPopedomCode());
		}
		return popedomString.toString();
	}
	
}
