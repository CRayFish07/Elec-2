package com.yzx.elec.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yan.util.ColUtil;
import com.yzx.elec.dao.IElecLogDao;
import com.yzx.elec.pojo.ElecLog;
import com.yzx.elec.service.IElecLogService;
import com.yzx.elec.stringEnum.StringEnum;
import com.yzx.elec.web.form.ElecLogForm;
import com.yzx.elec.web.form.ElecUserForm;

@Transactional(readOnly=true)
@Service(IElecLogService.SERVICE_NAME)
public class ElecLogServiceImpl implements IElecLogService {
	@Resource(name=IElecLogDao.DAO_NAME)
	private IElecLogDao logDao;

	@Override
	@Transactional(readOnly=false, isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public void log(HttpServletRequest request, String detail) {
		//取得用户名，ip地址和
		ElecLog log = new ElecLog();
		log.setIpAddress(request.getRemoteHost());
		
		//设置操作者
		ElecUserForm user = (ElecUserForm)request.getSession().getAttribute(StringEnum.GLOBAL_USER);
		log.setOpreateName(user.getLogonName());
		
		//设置操作日期
		log.setOpreateDate(new Date());
		
		log.setDetail(detail);
		
		logDao.save(log);
	}

	@Override
	public List<ElecLogForm> findAllLog() {
		List<ElecLog> logs = logDao.findObjectsByConditions(null, null, null);
		
		//po->vo
		return changePo2VoList(logs);
	}

	private List<ElecLogForm> changePo2VoList(List<ElecLog> logs) {
		if(ColUtil.isEmpty(logs)) {
			return null;
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		ArrayList<ElecLogForm> logForms = new ArrayList<ElecLogForm>();
		for(ElecLog log : logs) {
			ElecLogForm logForm = new ElecLogForm();
			logForm.setLogId(log.getLogId());
			logForm.setIpAddress(log.getIpAddress());
			logForm.setOpreateName(log.getOpreateName());
			logForm.setOpreateDate(dateFormat.format(log.getOpreateDate()));
			logForm.setDetail(log.getDetail());
			
			logForms.add(logForm);
		}
		return logForms;
	}
	
	
}
