<%@page import="com.yan.util.ColUtil"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%!
	//查找指定cookie的值
	String findCookie(HttpServletRequest request, String key) {
		Cookie[] cookies = request.getCookies();
		if(ColUtil.isEmpty(cookies)) {
			return "";
		} else {
			for(Cookie cookie : cookies) {
				if(cookie != null) {
					if(cookie.getName().equals(key)) {
						return cookie.getValue();
					}
				}
			}
			
			return "";
		}
	}
%>
