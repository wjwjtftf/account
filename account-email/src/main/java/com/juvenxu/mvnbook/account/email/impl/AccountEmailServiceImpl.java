/*******************************************************************
 * Copyright (c) 2007 arvato and others
 * All rights reserved.
 *
 * Contributors:
 * arvato Systems (Shanghai) Co., Ltd.
 * 
 ******************************************************************/
package com.juvenxu.mvnbook.account.email.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.juvenxu.mvnbook.account.email.AccountEmailException;
import com.juvenxu.mvnbook.account.email.AccountEmailService;

/**
 * 发送邮件实现类
 *
 * @author fan.tang
 *
 * @version 2014年11月7日
 *
 */
public class AccountEmailServiceImpl implements AccountEmailService {

	private JavaMailSender javaMailSender;

	private String systemEmail;
	
	/**
	 * (non-Javadoc)
	 * 
	 * @see com.juvenxu.mvnbook.account.email.AccountEmailService#sendEmail(java.lang.String,
	 *      java.lang.String, java.lang.String)
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
	public void sendEmail(String to, String subject, String htmlText) throws AccountEmailException {

		try {
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper msgHelper = new MimeMessageHelper(msg);
			
			msgHelper.setFrom(systemEmail);
			msgHelper.setTo(to);
			msgHelper.setSubject(subject);
			msgHelper.setText(htmlText, true);
			
			javaMailSender.send(msg);
		} catch (MessagingException e) {
			throw new AccountEmailException("Faild to send email.", e);
		}
		
	}

	
	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public String getSystemEmail() {
		return systemEmail;
	}

	public void setSystemEmail(String systemEmail) {
		this.systemEmail = systemEmail;
	}
	
}
