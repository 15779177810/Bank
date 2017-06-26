package com.huagege.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * 自定义饥汉单例模式
 * 生产sessionfactory
 * @author wubobo
 *
 */
@SuppressWarnings("deprecation")
public class MyFactory {
	static Configuration cfg = new AnnotationConfiguration().configure();
	static ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
	private static SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
	public static SessionFactory getInstance(){
		return factory;
	}
}
