package com.huagege.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.huagege.bean.Transfer;
/**
 * 测试类
 * @author wubobo
 *
 */
@SuppressWarnings("deprecation")
public class TransferDao {
	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
		Session session = factory.openSession();
		Transfer transfer = new Transfer();
		transfer.setUsername("李四");
		transfer.setTime(new java.sql.Date(System.currentTimeMillis()));
		transfer.setOrigin("开户");
		transfer.setMoney(0);
		transfer.setBalance(0);
		try {
			session.beginTransaction();
			session.save(transfer);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("请关闭已连接的数据库");
		}
		finally{
			session.close();
		}
	}
}
