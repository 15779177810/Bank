package com.huagege.service;

import java.util.List;

import com.huagege.bean.Transfer;
import com.huagege.bean.User;
import com.huagege.exception.TransferException;

/**
 * 交易业务逻辑接口
 * @author wubobo
 *
 */
public interface TransferService {
	
	/**
	 * 存钱
	 * @param username		用户名
	 * @param money		金额
	 * @return		存钱金额
	 * @throws TransferException
	 */
	public Transfer deposit(String username,double money) throws TransferException;

	/**
	 * 取钱
	 * @param username 	用户名
	 * @param money		金额
	 * @return	取钱金额
	 * @throws TransferException
	 */
	public Transfer draw(String username,double money) throws TransferException;
	
	/**
	 * 转账
	 * @param username 	用户名
	 * @param target	目标账号
	 * @param money	金额
	 * @return 当次交易记录
	 * @throws TransferException
	 */
	public Transfer transfer(String username,String target,double money) throws TransferException;
	
	/**
	 * 交易记录
	 * @return	交易记录集合
	 * @throws TransferException
	 */
	public  List<Transfer> transfers() throws TransferException;

	/**
	 * 交易记录生成二位数组
	 * @return 二位数组数据
	 * @throws TransferException
	 */
	public Object[][] transferData(User user) throws TransferException;
}
