/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huagege.bean;

import java.util.Date;

import javax.persistence.*;

/**
 *用户实体类
 * @author wubobo
 */
@Entity
@Table(name="user")
public class User {
    
	@Id
	@Column(name="username")
    private String username;
    
	@Column(name="password")
    private String password;
    
	@Column(name="createtime")
    private Date createTime;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     * @return 
     */
    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public User setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

	@Override
	public boolean equals(Object obj) {
		if(obj == null||!(obj instanceof User))
			return false;
		User user = (User)obj;
		if(this.username.equals(user.username)&&this.password.equals(user.password))
			return true;
		return false;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
    
}
