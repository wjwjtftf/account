/*******************************************************************
 * Copyright (c) 2007 arvato and others
 * All rights reserved.
 *
 * Contributors:
 * arvato Systems (Shanghai) Co., Ltd.
 * 
 ******************************************************************/
package com.juvenxu.mvnbook.account.exception;

/**
 * 账户服务层异常
 *
 * @author fan.tang
 *
 * @version 2014年11月14日
 *
 */
public class AccountServiceException extends Exception {

	/**
	 * 初版
	 */
	private static final long serialVersionUID = 1L;

	public AccountServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountServiceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public AccountServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public AccountServiceException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public AccountServiceException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
}
