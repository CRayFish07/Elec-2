package com.yzx.elec.web.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.yan.util.StringUtil;

public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	private static final long serialVersionUID = 1L;
	protected HttpServletResponse response;
	protected HttpServletRequest request;
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * 添加cookie
	 * @param value value==null,则删除指定的key的cookie
	 * @param key cookie的key
	 * @throws UnsupportedEncodingException 
	 */
	protected void addCookie(String value, String key) throws UnsupportedEncodingException {
		Cookie cook = new Cookie(key, value==null ? null : URLEncoder.encode(value, "utf-8"));
		//设置cookie路径
		cook.setPath("/");
		//设置cookie有效时长
		if(StringUtil.isEmpty(value)) {
			cook.setMaxAge(0);
		} else {
			cook.setMaxAge(7*24*60*60);
		}
		response.addCookie(cook);
	}
}
