/*******************************************************************
 * Copyright (c) 2007 arvato and others
 * All rights reserved.
 *
 * Contributors:
 * arvato Systems (Shanghai) Co., Ltd.
 * 
 ******************************************************************/
package com.juvenxu.mvnbook.account.captcha;

import java.util.List;

/**
 * 验证码服务接口类
 *
 * @author fan.tang
 *
 * @version 2014年11月13日
 *
 */
public interface AccountCaptchaService {

	/**
	 * 生成随机的验证码主键
	 * 
	 * @return 验证码主键
	 * @throws AccountCaptchaException
	 *             验证码服务异常
	 */
	String generateCaptchaKey() throws AccountCaptchaException;

	/**
	 * 生成验证码图片
	 * 
	 * @param captchaKey
	 *            验证码主键
	 * @return 二进制数组
	 * @throws AccountCaptchaException
	 *             验证码服务异常
	 */
	byte[] generateCaptchaImage(String captchaKey) throws AccountCaptchaException;

	/**
	 * 验证用户反馈的主键和值
	 * 
	 * @param captchaKey
	 *            验证码主键
	 * @param captchaValue
	 *            用户反馈的值
	 * @return 比较是否相等
	 * @throws AccountCaptchaException
	 *             验证码服务异常
	 */
	boolean validateCaptcha(String captchaKey, String captchaValue) throws AccountCaptchaException;

	/**
	 * 获取人工设定的验证码字符串集合
	 * 
	 * @return 验证码字符串集合
	 */
	List<String> getPreDefinedTexts();

	/**
	 * 人工设定验证码字符串集合
	 * 
	 * @param preDefinedTexts
	 *            生成验证码主键的文本列表
	 */
	void setPreDefinedTexts(List<String> preDefinedTexts);

}
