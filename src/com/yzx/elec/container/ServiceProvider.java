package com.yzx.elec.container;

import org.springframework.context.ApplicationContext;

import com.yan.util.StringUtil;

/**
 * 服务提供类
 * @author yzx 2016
 *
 */
public class ServiceProvider {
	private static ApplicationContext ac;
	static {
		/**
		 * 初始化spring
		 */
		ac = ServiceProviderCord.loadConfig("beans.xml");
	}
	
	/**
	 * 根据服务名取得相应的服务节点
	 * @param 服务名
	 */
	public static Object getService(String serviceName) {
		if(ac == null) {
			throw new RuntimeException("spring not initialize");
		}
		
		if(StringUtil.isEmpty(serviceName)) {
			throw new RuntimeException("未指定service");
		}
		
		Object service = null;
		if(ac.containsBean(serviceName)) {
			service = ac.getBean(serviceName);
		}
		
		if(service == null) {
			throw new RuntimeException("服务["+serviceName+"]不存在");
		}
		
		return service;
	}
}
