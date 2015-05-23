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
 * 邮件接口
 *
 * @author fan.tang
 *
 * @version 2014年11月7日
 *
 */
public interface AccountEmailService {

	/**
	 * 
	 * 发送邮件
	 * 
	 * @param to
	 *            接受地址
	 * @param subject
	 *            邮件主题
	 * @param htmlText
	 *            邮件内容
	 * @throws AccountEmailException
	 *             邮件异常
	 */
	void sendEmail(String to, String subject, String htmlText) throws AccountEmailException;

}
