package com.huagege.exception;

/**
 * 自定义用户异常
 * @author wubobo
 *
 */
public class UserException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserException(){
		
	}
	public UserException(String message){
		super(message);
	}
	public UserException(Throwable cause){
		super(cause);
	}
	public UserException(String message,Throwable cause){
		super(message,cause);
	}
}
