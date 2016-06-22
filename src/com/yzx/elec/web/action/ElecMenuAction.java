package com.yzx.elec.web.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.opensymphony.xwork2.ModelDriven;
import com.xiang.encrypt.Md5Util;
import com.yan.util.ColUtil;
import com.yan.util.StringUtil;
import com.yzx.common.util.CookieUtil;
import com.yzx.elec.container.ServiceProvider;
import com.yzx.elec.service.IElecCommonMsgService;
import com.yzx.elec.service.IElecRoleService;
import com.yzx.elec.service.IElecUserService;
import com.yzx.elec.web.form.ElecCommonMsgForm;
import com.yzx.elec.web.form.ElecMenuForm;
import com.yzx.elec.web.form.ElecUserForm;

public class ElecMenuAction extends BaseAction implements ModelDriven<ElecMenuForm> {
	
	private static final long serialVersionUID = 1L;
	private ElecMenuForm form = new ElecMenuForm();
	
	private IElecUserService userService = (IElecUserService)ServiceProvider.getService(IElecUserService.SERVICE_NAME);
	
	private IElecRoleService roleService = (IElecRoleService)ServiceProvider.getService(IElecRoleService.SERVICE_NAME);
	
	@Override
	public ElecMenuForm getModel() {
		return form;
	}
	
	public String home() throws UnsupportedEncodingException {
		if(form.getRemeberMe() != null && form.getRemeberMe().equals("yes")) {
			//添加帐号的cookie
			addCookie(form.getName(), "account");
		} else {
			//添加帐号的cookie
			addCookie(null, "account");
		}
		
		String cook = CookieUtil.findCookie(request, "account");
		
		//检查校验码
		if(!checkWord(form.getCheckWord())) {
			this.addFieldError("error", "请输入正确的验证码");
			return "error";
		}
		
		//查询用户
		List<ElecUserForm> users = userService.findUserByIdAndPassword(form.getName(), Md5Util.getInstance().makeMD5(form.getPassword()));
		if(ColUtil.isEmpty(users) || users.get(0) == null) {
			this.addFieldError("error", "登录失败，用户名或密码错误");
			return "error";
		}
		ElecUserForm user = users.get(0);
		
		//查询用户的角色
		HashMap<Integer, String> roles = userService.findUserRolesByUserId(user.getUserId());
		if(ColUtil.isEmpty(roles)) {
			this.addFieldError("error", "登录失败，无可用角色");
			return "error";
		}
		
		ArrayList<Integer> roleIds = new ArrayList<Integer>();
		Iterator<Entry<Integer, String>> roleIdEntries = roles.entrySet().iterator();
		while(roleIdEntries.hasNext()) {
			Entry<Integer, String> roleId = roleIdEntries.next();
			roleIds.add(roleId.getKey());
		}
		String popedoms = roleService.findRolePopedomsByRoleIds(roleIds);
		if(StringUtil.isEmpty(popedoms)) {
			this.addFieldError("error", "登录失败，无任何权限");
			return "error";
		}
		
		request.getSession().setAttribute("global_user", user);
		request.getSession().setAttribute("global_role", roles);
		request.getSession().setAttribute("global_popedom", popedoms);
		return "home";
	}
	
	private boolean checkWord(String checkWord) {
		String sessionCheckWord = (String)request.getSession().getAttribute("checkWord");
		if(sessionCheckWord == null) {
			return false;
		} else {
			return sessionCheckWord.equals(checkWord);
		}
	}

	public String title() {
		return "title";
	}
	
	public String left() {
		return "left";
	}
	
	public String change1() {
		return "change1";
	}
	
	public String loading() {
		return "loading";
	}
	
	public String alermYS() {
		return "alermYS";
	}
	
	public String alermSB() {
		IElecCommonMsgService service = (IElecCommonMsgService)ServiceProvider.getService(IElecCommonMsgService.SERVICE_NAME);
		List<ElecCommonMsgForm> msgs = service.findCommonMsgByCurrentDate();
		
		request.setAttribute("commonList", msgs);
		return "alermSB";
	}
	
	public String alermZD() {
		IElecCommonMsgService service = (IElecCommonMsgService)ServiceProvider.getService(IElecCommonMsgService.SERVICE_NAME);
		List<ElecCommonMsgForm> msgs = service.findCommonMsgByCurrentDate();
		
		request.setAttribute("commonList", msgs);
		return "alermZD";
	}
	
	public String alermJX() {
		return "alermJX";
	}
	
	public String alermXZ() {
		return "alermXZ";
	}
	
	public String logout() {
		request.getSession().invalidate();
		return "logout";
	}
}
