package com.huagege.test;

import org.junit.Test;

import com.huagege.exception.UserException;
import com.huagege.service.UserService;
import com.huagege.service.UserServiceImpl;
/**
 * 测试类
 * @author wubobo
 *
 */
public class TestUser {
	
	@Test
	public void regist(){
		UserService userService = new UserServiceImpl();
		try {
			userService.regist("王五", "5556");
		} catch (UserException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void login(){
		UserService userService = new UserServiceImpl();
		try {
			System.out.println(userService.login("王五", "5556"));
		} catch (UserException e) {
			e.printStackTrace();
		}
	}
}
