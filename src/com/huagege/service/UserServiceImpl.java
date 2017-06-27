package com.huagege.service;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.huagege.bean.Transfer;
import com.huagege.bean.User;
import com.huagege.dao.MyFactory;
import com.huagege.exception.UserException;
import com.huagege.util.MD5Util;

/**
 * 处理用户业务逻辑
 * @author wubobo
 *
 */
public class UserServiceImpl implements UserService {
	
	private SessionFactory factory = MyFactory.getInstance();
	
	/**
	 * 登录验证
	 */
	@Override
	public User login(String username, String password) throws UserException {
		Session session = factory.openSession();
		session.beginTransaction();
		User userFound =  (User) session.get(User.class, username);
		User user = new User(username,MD5Util.md5(password));
		if(user.equals(userFound)){
			session.close();
			return userFound;
		}
		else
			throw new UserException("账号或密码错误");
	}

	/**
	 * 注册账号
	 */
	@Override
	public User regist(String username,String password) throws UserException {
		Session session;
		User user = null;
		session = factory.openSession();
		session.beginTransaction();
		if(session.get(User.class, username)!=null)
			throw new UserException(username+"账号已存在");
		user = new User();//创建新用户
		user.setPassword(MD5Util.md5(password));
		user.setUsername(username);
		user.setCreateTime(new Date(System.currentTimeMillis()));
		Transfer transfer = new Transfer(username, 0, "开户", new Date(System.currentTimeMillis()));//创建新账户
		transfer.setBalance(0);
		session.save(user);
		session.save(transfer);
		session.getTransaction().commit();
		session.close();
		return user;
	}

	/**
	 * 加载用户（不需要）
	 */
	@Override
	public User load(String username) throws UserException {
		
		return null;
	}

	
}
