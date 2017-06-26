package com.huagege.dao;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.huagege.bean.User;
import com.huagege.exception.TransferException;
import com.huagege.view.MainView;

/**
 * 测试类
 * @author wubobo
 *
 */
@SuppressWarnings("deprecation")
public class UserDao {
	public void add(){
		User user = new User();
		user.setUsername("李四");
		user.setPassword("123");
		user.setCreateTime(new java.sql.Date(System.currentTimeMillis()));
		Configuration cfg = new AnnotationConfiguration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
	public static void main(String[] args) {
//		new UserDao().add();

		User user = new User();
		user.setUsername("张三");
		user.setPassword("123");
		user.setCreateTime(new Date(System.currentTimeMillis()));
		try {
			new MainView(user).setVisible(true);
		} catch (TransferException e) {
			e.printStackTrace();
		}
			

	
	}
}
