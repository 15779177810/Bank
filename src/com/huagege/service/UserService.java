package com.huagege.service;

import com.huagege.bean.User;
import com.huagege.exception.UserException;

/**
 * 用户业务逻辑接口
 * @author wubobo
 *
 */
public interface UserService {
	
	/**
	 * 验证登录
	 * @param username		用户名
	 * @param password		密码
	 * @return 	完整的账号信息
	 * @throws UserException
	 */
	public User login(String username,String password) throws UserException;
	
	/**
	 * 注册
	 * @param username		用户名
	 * @param password		密码
	 * @return	用户信息
	 * @throws UserException
	 */
	public User regist(String username,String password) throws UserException;
	
	/**
	 * 按照用户名加载用户
	 * @param username		用户名
	 * @return	用户信息
	 * @throws UserException
	 */
	public User load(String username) throws UserException;
	
}
