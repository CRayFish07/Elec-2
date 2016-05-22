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

import com.yan.util.xml.XmlObject;
import com.yzx.elec.dao.IElecRolePopedomDao;
import com.yzx.elec.dao.IElecUserRoleDao;
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

	@Override
	public List<ElecSystemDDLForm> getAllService() {
		return null;
	}

	@Override
	public List<XmlObject> readRoleFunctionList() {
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
		
		ArrayList<XmlObject> result = null;
		@SuppressWarnings("unchecked")
		Iterator<Element> functions = ele.elementIterator("Function");
		if(functions != null) {
			result = new ArrayList<XmlObject>();
			while(functions.hasNext()) {
				Element e = functions.next();
				
				XmlObject obj = new XmlObject();
				obj.setCode(e.elementText("FunctionCode"));
				obj.setName(e.elementText("FunctionName"));
				obj.setParentCode(e.elementText("ParentCode"));
				obj.setParentName(e.elementText("ParentName"));
				
				result.add(obj);
			}
		}
		return result;
	}
}
