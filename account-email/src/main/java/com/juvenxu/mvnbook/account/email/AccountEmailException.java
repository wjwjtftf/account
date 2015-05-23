/*******************************************************************
 * Copyright (c) 2007 arvato and others
 * All rights reserved.
 *
 * Contributors:
 * arvato Systems (Shanghai) Co., Ltd.
 * 
 ******************************************************************/
package com.juvenxu.mvnbook.account.email;

/**
 * 
 * 发送邮件的异常
 *
 * @author fan.tang
 *
 * @version 2014年11月7日
 *
 */
public class AccountEmailException extends Exception {

	/**
	 * 初始版本
	 */
	private static final long serialVersionUID = 1L;

	public AccountEmailException() {
		super();
	}

	public AccountEmailException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public AccountEmailException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public AccountEmailException(String arg0) {
		super(arg0);
	}

	public AccountEmailException(Throwable arg0) {
		super(arg0);
	}
	
}
