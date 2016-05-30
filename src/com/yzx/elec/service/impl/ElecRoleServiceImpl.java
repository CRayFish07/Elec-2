package com.yzx.elec.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

import com.yan.util.StringUtil;
import com.yan.util.xml.XmlObject;
import com.yzx.elec.dao.IElecRolePopedomDao;
import com.yzx.elec.dao.IElecUserRoleDao;
import com.yzx.elec.pojo.ElecRolePopedom;
import com.yzx.elec.service.IElecRoleService;
import com.yzx.elec.web.form.ElecSystemDDLForm;

/**
 * 角色服务
 * @author yzx<br/>
 * 创建日期 2016年4月29日
 */
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
}
