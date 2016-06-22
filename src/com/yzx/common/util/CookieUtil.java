package com.yzx.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.yan.util.ColUtil;

public class CookieUtil {
	//查找指定cookie的值
	public static String findCookie(HttpServletRequest request, String key) {
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
}	
