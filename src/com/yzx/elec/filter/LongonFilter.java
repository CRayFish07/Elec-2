package com.yzx.elec.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yan.util.StringUtil;
import com.yzx.elec.web.form.ElecUserForm;

public class LongonFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		String pathInfo = request.getServletPath();
		
		//检查路径是否在允许路径中
		if(checkPathInAllowPath(pathInfo)) {
			chain.doFilter(arg0, arg1);
			return;
		}
		
		//如果不再放行的路径中，就检查session中是否有用户存在
		if(checkSessionHaveUser(request)) {
			chain.doFilter(arg0, arg1);
			return;
		}
		
		//如果没有用户存在，则跳转到登录界面
		response.sendRedirect("/");
	}

	private boolean checkSessionHaveUser(HttpServletRequest request) {
		Object user = request.getSession().getAttribute("global_user");
		if(user == null) {
			return false;
		} else {
			return true;
		}
	}

	private boolean checkPathInAllowPath(String pathInfo) {
		if(allowPath == null) {
			return false;
		}
		
		for(String path : allowPath) {
			if(pathInfo.equals(path)) {
				return true;
			}
		}
		return false;
	}

	private ArrayList<String> allowPath;
	@Override
	public void init(FilterConfig config) throws ServletException {
		String paramValue = config.getInitParameter("allowPath");
		if(!StringUtil.isEmpty(paramValue)) {
			allowPath = new ArrayList<String>();
			String[] pts = paramValue.split(";");
			for(String pt : pts) {
				allowPath.add(pt);
			}
		}
	}

}
