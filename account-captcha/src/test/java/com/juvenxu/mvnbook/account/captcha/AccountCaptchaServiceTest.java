/*******************************************************************
 * Copyright (c) 2007 arvato and others
 * All rights reserved.
 *
 * Contributors:
 * arvato Systems (Shanghai) Co., Ltd.
 * 
 ******************************************************************/
package com.juvenxu.mvnbook.account.captcha;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 验证码服务测试类
 *
 * @author fan.tang
 *
 * @version 2014年11月13日
 *
 */
public class AccountCaptchaServiceTest {

	private AccountCaptchaService service;

	@Before
	public void prepare() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("account-captcha.xml");
		service = (AccountCaptchaService) ctx.getBean("accountCaptchaService");
	}

	@Test
	public void testGenerateCaptcha() throws AccountCaptchaException, IOException {
		/*
		 * 生成验证码主键
		 */
		String captchaKey = service.generateCaptchaKey();
		assertNotNull(captchaKey);

		/*
		 * 生成二进制图片流
		 */
		byte[] captchaImage = service.generateCaptchaImage(captchaKey);
		assertTrue(captchaImage.length > 0);

		/*
		 * 生成验证码图片保存
		 */
		File image = new File("target/" + captchaKey + ".jpg");
		if (image.exists()) {
			image.delete();
		}
		OutputStream out = null;
		try {
			out = new FileOutputStream(image);
			out.write(captchaImage);
		} finally {
			if (out != null) {
				out.close();
			}
		}
		assertTrue(image.exists() && image.length() > 0);
	}
	
	@Test
	public void testValidateCaptchaCorrent() throws AccountCaptchaException{
		List<String> preDefinedTexts = new ArrayList<String>();
		preDefinedTexts.add("12345");
		preDefinedTexts.add("abcde");
		service.setPreDefinedTexts(preDefinedTexts);
		
		String captchaKey = service.generateCaptchaKey();
		service.generateCaptchaImage(captchaKey);
		assertTrue(service.validateCaptcha(captchaKey, "12345"));
		
		captchaKey = service.generateCaptchaKey();
		service.generateCaptchaImage(captchaKey);
		assertTrue(service.validateCaptcha(captchaKey, "abcde"));
	}
	
	@Test
	public void testValidateCaptchaIncorrent() throws AccountCaptchaException{
		List<String> preDefinedTexts = new ArrayList<String>();
		preDefinedTexts.add("12345");
		service.setPreDefinedTexts(preDefinedTexts);
		
		String captchaKey = service.generateCaptchaKey();
		service.generateCaptchaImage(captchaKey);
		assertFalse(service.validateCaptcha(captchaKey, "67890"));
	}

}
