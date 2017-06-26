package com.huagege.service;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.huagege.bean.Transfer;
import com.huagege.bean.User;
import com.huagege.dao.MyFactory;
import com.huagege.exception.TransferException;

/**
 * 处理交易记录业务逻辑
 * @author wubobo
 *
 */
public class TransferServiceImpl implements TransferService {
	private User user;
	private SessionFactory factory = MyFactory.getInstance();

	
	/**
	 * 存款业务逻辑
	 */
	@Override
	public Transfer deposit(String username, double money)
			throws TransferException {
		
		if(money<=0)
			throw new TransferException("存款金额有误");
		
		Session session;
		session = factory.openSession();
		Transfer transfer = null;
		try {
			session.beginTransaction();
			String hql = "from Transfer T where T. username = "+"'"+user.getUsername()+"'";//获取最后一次交易记录
			Query query = session.createQuery(hql);
			List results = query.list();
			Transfer last = (Transfer) results.get(results.size()-1);
			transfer = new Transfer(username, money, "存款", new Date(System.currentTimeMillis()));
			transfer.setBalance(last.getBalance()+money);//余额为最后一次交易记录的月+存款
			session.save(transfer);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return transfer;
	}

	/**
	 * 取款业务逻辑
	 */
	@Override
	public Transfer draw(String username, double money) throws TransferException {
		
		if(money<=0)
			throw new TransferException("取款金额有误");
		
		Session session;
		Transfer transfer = null;
		session = factory.openSession();
		try {
			session.beginTransaction();
			String hql = "from Transfer T where T. username = "+"'"+user.getUsername()+"'";//获取最后一次交易记录
			Query query = session.createQuery(hql);
			List results = query.list();
			Transfer last = (Transfer) results.get(results.size()-1);
			if(last.getBalance()<money)
				throw new TransferException("余额不足");
			transfer = new Transfer(username, -money, "取款", new Date(System.currentTimeMillis()));
			transfer.setBalance(last.getBalance()-money);//余额为最后一次交易记录的月+存款
			session.save(transfer);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return transfer;
	}

	/**
	 * 转账业务逻辑
	 */
	@Override
	public Transfer transfer(String username, String target, double money)
			throws TransferException ,ArrayIndexOutOfBoundsException{
		if(username == target)
			throw new TransferException("不能向自己转账");
		
		if(money<=0)
			throw new TransferException("转账金额有误");
		Transfer userLast = null;
		Session session;
		session = factory.openSession();
		try {
			session.beginTransaction();
			String userHql = "from Transfer T where T. username = "+"'"+user.getUsername()+"'";//获取最后一次交易记录
			Query query = session.createQuery(userHql);
			List userResults = query.list();
			userLast = (Transfer) userResults.get(userResults.size()-1);
			if(userLast.getBalance()<money)
				throw new TransferException("余额不足");
			String targetHql = "from Transfer T where T. username = "+"'"+target+"'"; 
			query = session.createQuery(targetHql);
			List targetResults = query.list();
			Transfer targetLast = (Transfer) targetResults.get(targetResults.size()-1);
			 userLast.setMoney(-money);
			 userLast.setOrigin(target);
			 userLast.setTime(new Date(System.currentTimeMillis()));
			 userLast.setBalance(userLast.getBalance()-money);
			 targetLast.setMoney(+money);
			 targetLast.setOrigin(username);
			 targetLast.setTime(new Date(System.currentTimeMillis()));
			 targetLast.setBalance(targetLast.getBalance()+money);
			session.save(userLast);
			session.save(targetLast);
			session.getTransaction().commit();
		} finally{
			if(session!=null)
				session.close();
		}
		return userLast;
	}

	@Override
	public List<Transfer> transfers() throws TransferException {
		return null;
	}

	public TransferServiceImpl(User user ) {
		this.user = user;
	}

	/**
	 * 将转账记录转为二维对象数组
	 */
	@Override
	public Object[][] transferData(User user) throws TransferException {
		Session session = factory.openSession();
		String hql = "from Transfer where username = "+"'"+user.getUsername()+"'";
		Query query = session.createQuery(hql);
		List list = query.list();
		Object[][] data = new Object[list.size()][5];
		int i = 0;
		for(Object o :list){
			data[i][0] = ((Transfer)o).getUsername();
			data[i][1] = ((Transfer)o).getMoney();
			data[i][2] = ((Transfer)o).getOrigin();
			data[i][3] = ((Transfer)o).getTime();
			data[i][4] = ((Transfer)o).getBalance();
			i++;
		}
		return data;
	}
}
