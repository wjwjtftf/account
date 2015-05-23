/*******************************************************************
 * Copyright (c) 2007 arvato and others
 * All rights reserved.
 *
 * Contributors:
 * arvato Systems (Shanghai) Co., Ltd.
 * 
 ******************************************************************/
package com.juvenxu.mvnbook.account.persist;

import java.io.Serializable;

/**
 * 账户持久化异常
 *
 * @author fan.tang
 *
 * @version 2014年11月11日
 *
 */
public class AccountPersistException extends Exception implements Serializable{

	/**
	 * 初始版本
	 */
	private static final long serialVersionUID = 1L;

	public AccountPersistException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountPersistException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public AccountPersistException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public AccountPersistException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public AccountPersistException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
}
