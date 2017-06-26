/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huagege.bean;

import java.util.Date;

import javax.persistence.*;

/**
 *交易记录实体
 * @author wubobo
 */
@Entity
public class Transfer {
	
	@Id @GeneratedValue()
	@Column(name="id")
	private String id;
	
	@Column(name="username")
    private String username;
	
	@Column(name="money")
    private double money;
	
	@Column(name="orgin")
    private String origin;
	
	@Column(name="time")
    private Date time;
	
	@Column(name="balance")
    private double balance;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public Transfer setUsername(String username) {
        this.username = username;
        return this;
    }

    /**
     * @return the money
     */
    public double getMoney() {
        return money;
    }

    /**
     * @param moeny the moeny to set
     */
    public Transfer setMoney(double money) {
        this.money = money;
        return this;
    }

    /**
     * @return the origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set
     */
    public Transfer setOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    /**
     * @return the time
     */
    public Date getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public Transfer setTime(Date time) {
        this.time = time;
        return this;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public Transfer setBalance(double balance) {
        this.balance = balance;
        return this;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	public Transfer() {
		super();
	}

	public Transfer(String username, double money, String origin, Date time) {
		super();
		this.username = username;
		this.money = money;
		this.origin = origin;
		this.time = time;
	}

	@Override
	public String toString() {
		return "Transfer [id=" + id + ", username=" + username + ", money="
				+ money + ", origin=" + origin + ", time=" + time
				+ ", balance=" + balance + "]";
	}
    
	/**
	 * 将交易对象转化为对象数组
	 * @return
	 */
    public Object[] toDataArray(){
    	return new Object[]{this.username,this.money,this.origin,(Date)this.time,this.balance};
    }
}
