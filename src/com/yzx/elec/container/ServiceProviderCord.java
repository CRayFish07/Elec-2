package com.yzx.elec.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceProviderCord {
	public static ApplicationContext loadConfig(String file) {
		return new ClassPathXmlApplicationContext(file);
	}
}
