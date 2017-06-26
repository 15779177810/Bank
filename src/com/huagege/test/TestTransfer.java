package com.huagege.test;

import java.sql.Date;
import org.junit.Test;

import com.huagege.bean.User;
import com.huagege.exception.TransferException;
import com.huagege.service.TransferService;
import com.huagege.service.TransferServiceImpl;
import com.huagege.view.MainView;
/**
 * 测试类
 * @author wubobo
 *
 */
public class TestTransfer {
	
	@Test
	public void deposit(){
		User user = new User();
		user.setUsername("张三");
		user.setPassword("123");
		user.setCreateTime(new Date(System.currentTimeMillis()));
		TransferService transfer = new TransferServiceImpl(user);
		try {
			transfer.deposit(user.getUsername(), 2);
		} catch (TransferException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void draw(){
		User user = new User();
		user.setUsername("李四");
		user.setPassword("123");
		user.setCreateTime(new Date(System.currentTimeMillis()));
		TransferService transfer = new TransferServiceImpl(user);
		try {
			transfer.draw(user.getUsername(), 4);
		} catch (TransferException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void transfer(){
		User user = new User();
		user.setUsername("张三");
		user.setPassword("123");
		user.setCreateTime(new Date(System.currentTimeMillis()));
		TransferService transfer = new TransferServiceImpl(user);
		try {
			transfer.transfer(user.getUsername(), "李四", 2);
		} catch (TransferException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void data(){
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
