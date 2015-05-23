/*******************************************************************
 * Copyright (c) 2007 arvato and others
 * All rights reserved.
 *
 * Contributors:
 * arvato Systems (Shanghai) Co., Ltd.
 * 
 ******************************************************************/
package com.juvenxu.mvnbook.account.service;

import com.juvenxu.mvnbook.account.captcha.AccountCaptchaException;
import com.juvenxu.mvnbook.account.exception.AccountServiceException;
import com.juvenxu.mvnbook.account.pojo.SignUpRequest;

/**
 * 账户service封装层接口类
 *
 * @author fan.tang
 *
 * @version 2014年11月14日
 *
 */
public interface AccountService {

	/**
	 * 生成验证码主键
	 * 
	 * @return 验证码主键
	 * @throws AccountCaptchaException
	 *             验证码异常
	 */
	String generateCaptchaKey() throws AccountServiceException;

	/**
	 * 生成验证码图片
	 * 
	 * @param captchaKey
	 *            验证码主键
	 * @return 二进制的图片流
	 * @throws AccountCaptchaException
	 *             验证码异常
	 */
	byte[] generateCaptchaImage(String captchaKey) throws AccountServiceException;

	/**
	 * 用户注册
	 * 
	 * @param signUpRequest
	 *            用户请求参数
	 * @throws AccountServiceException
	 *             服务层异常
	 */
	void signUp(SignUpRequest signUpRequest) throws AccountServiceException;

	/**
	 * 激活账户
	 * 
	 * @param activationNumber
	 *            激活码
	 * @throws AccountServiceException
	 *             账户异常
	 */
	void activate(String activationNumber) throws AccountServiceException;

	/**
	 * 用户登录
	 * 
	 * @param id
	 *            账户ID
	 * @param password
	 *            账户密码
	 * @throws AccountServiceException
	 *             账户异常
	 */
	void login(String id, String password) throws AccountServiceException;
	
}
