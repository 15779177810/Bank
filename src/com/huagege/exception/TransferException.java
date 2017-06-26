package com.huagege.exception;

/**
 * 自定义交易异常
 * @author wubobo
 *
 */
public class TransferException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TransferException(){
		
	}
	
	public TransferException(String message){
		super(message);
	}
	
	public TransferException(Throwable cause){
		super(cause);
	}
	public TransferException(String message,Throwable cause){
		super(message,cause);
	}

}
