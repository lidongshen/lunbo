package com.uek.exception;

/**
 * 每个工程基本都会定义一个运行时异常，然后从父类superclass产生构造器(5)
 * 
 * @author UEK-N
 *
 */
public class ChatException extends RuntimeException{
	
	public ChatException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ChatException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ChatException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ChatException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
