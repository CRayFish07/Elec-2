package com.yzx.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yan.util.ColUtil;
import com.yan.util.StringUtil;

public class CookieUtil {
	/**
	 * ����ָ��cookie��ֵ
	 */
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
	
	/**
	 * ���cookie
	 * @param response
	 * @param key
	 * @param value
	 * @throws UnsupportedEncodingException
	 */
	public static void addCookie(HttpServletResponse response, String key, String value) throws UnsupportedEncodingException {
		Cookie cook = new Cookie(key, value==null ? null : URLEncoder.encode(value, "utf-8"));
		//����cookie·��
		cook.setPath("/");
		//����cookie��Чʱ��
		if(StringUtil.isEmpty(value)) {
			cook.setMaxAge(0);
		} else {
			cook.setMaxAge(7*24*60*60);
		}
		response.addCookie(cook);
	}
}	
