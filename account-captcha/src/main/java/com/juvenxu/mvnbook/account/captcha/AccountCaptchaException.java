/*******************************************************************
 * Copyright (c) 2007 arvato and others
 * All rights reserved.
 *
 * Contributors:
 * arvato Systems (Shanghai) Co., Ltd.
 * 
 ******************************************************************/
package com.juvenxu.mvnbook.account.captcha;

/**
 * 验证码服务异常类
 *
 * @author fan.tang
 *
 * @version 2014年11月13日
 *
 */
public class AccountCaptchaException extends Exception {

	/**
	 * 初版
	 */
	private static final long serialVersionUID = 1L;

	public AccountCaptchaException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountCaptchaException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public AccountCaptchaException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public AccountCaptchaException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public AccountCaptchaException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
}
