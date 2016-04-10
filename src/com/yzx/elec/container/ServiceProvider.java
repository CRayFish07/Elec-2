package com.yzx.elec.container;

import org.springframework.context.ApplicationContext;

import com.yan.util.StringUtil;

/**
 * �����ṩ��
 * @author yzx 2016
 *
 */
public class ServiceProvider {
	private static ApplicationContext ac;
	static {
		/**
		 * ��ʼ��spring
		 */
		ac = ServiceProviderCord.loadConfig("beans.xml");
	}
	
	/**
	 * ���ݷ�����ȡ����Ӧ�ķ���ڵ�
	 * @param ������
	 */
	public static Object getService(String serviceName) {
		if(ac == null) {
			throw new RuntimeException("spring not initialize");
		}
		
		if(StringUtil.isEmpty(serviceName)) {
			throw new RuntimeException("δָ��service");
		}
		
		Object service = null;
		if(ac.containsBean(serviceName)) {
			service = ac.getBean(serviceName);
		}
		
		if(service == null) {
			throw new RuntimeException("����["+serviceName+"]������");
		}
		
		return service;
	}
}
