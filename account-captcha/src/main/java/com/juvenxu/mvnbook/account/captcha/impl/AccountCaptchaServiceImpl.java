/*******************************************************************
 * Copyright (c) 2007 arvato and others
 * All rights reserved.
 *
 * Contributors:
 * arvato Systems (Shanghai) Co., Ltd.
 * 
 ******************************************************************/
package com.juvenxu.mvnbook.account.captcha.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.InitializingBean;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.juvenxu.mvnbook.account.captcha.AccountCaptchaException;
import com.juvenxu.mvnbook.account.captcha.AccountCaptchaService;
import com.juvenxu.mvnbook.account.util.RandomGenerator;

/**
 * 验证码服务实现类
 *
 * @author fan.tang
 *
 * @version 2014年11月13日
 *
 */
public class AccountCaptchaServiceImpl implements AccountCaptchaService, InitializingBean {

	/*
	 * 验证码生成器
	 */
	private DefaultKaptcha producer;

	/*
	 * 保存验证码主键和验证码字符串的对应关系
	 */
	private Map<String, String> captchaMap = new HashMap<String, String>();

	/*
	 * 用户预定义的验证码字符串的值集合
	 */
	private List<String> preDefinedTexts;

	/*
	 * 当前循环的自定义验证码字符串集合下标
	 */
	private int textCount = 0;

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 *
	 * @throws Exception
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		/*
		 * 初始化producer对象
		 */
		producer = new DefaultKaptcha();
		producer.setConfig(new Config(new Properties()));
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.juvenxu.mvnbook.account.captcha.AccountCaptchaService#generateCaptchaKey()
	 *
	 * @return
	 * @throws AccountCaptchaException
	 */
	@Override
	public String generateCaptchaKey() throws AccountCaptchaException {
		String key = RandomGenerator.getRandomString();
		String value = getCaptchaText();
		captchaMap.put(key, value);
		return key;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.juvenxu.mvnbook.account.captcha.AccountCaptchaService#generateCaptchaImage(java.lang.String)
	 *
	 * @param captchaKey
	 * @return
	 * @throws AccountCaptchaException
	 */
	@Override
	public byte[] generateCaptchaImage(String captchaKey) throws AccountCaptchaException {
		/*
		 * 获取验证码字符串
		 */
		String text = captchaMap.get(captchaKey);
		if (text == null) {
			throw new AccountCaptchaException("Captcha Key '" + captchaKey + "' not found!");
		}
		/*
		 * 创建图片流
		 */
		BufferedImage image = producer.createImage(text);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			/*
			 * ImageIO工具类可以将将要生成的图片写在输出流里面
			 */
			ImageIO.write(image, "jpg", out);
		} catch (IOException e) {
			throw new AccountCaptchaException("Faild to write captcha stream!", e);
		}
		return out.toByteArray();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.juvenxu.mvnbook.account.captcha.AccountCaptchaService#validateCaptcha(java.lang.String,
	 *      java.lang.String)
	 *
	 * @param captchaKey
	 * @param captchaValue
	 * @return
	 * @throws AccountCaptchaException
	 */
	@Override
	public boolean validateCaptcha(String captchaKey, String captchaValue) throws AccountCaptchaException {
		String text = captchaMap.get(captchaKey);
		if (text == null) {
			throw new AccountCaptchaException("Captcha Key '" + captchaKey + "' not found!");
		}
		if (text.equals(captchaValue)) {
			captchaMap.remove(captchaKey);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.juvenxu.mvnbook.account.captcha.AccountCaptchaService#getPreDefinedTexts()
	 *
	 * @return
	 */
	@Override
	public List<String> getPreDefinedTexts() {
		return this.preDefinedTexts;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.juvenxu.mvnbook.account.captcha.AccountCaptchaService#setPreDefinedTexts(java.util.List)
	 *
	 * @param preDefinedTexts
	 */
	@Override
	public void setPreDefinedTexts(List<String> preDefinedTexts) {
		this.preDefinedTexts = preDefinedTexts;
	}

	/**
	 * 用来生成验证码字符串，当preDefinedTexts不存在或者为空的时候，就用验证码图片生成器创建一个随机的字符串，
	 * 否则就顺序的循环preDefinedTexts列表取值
	 * 
	 * @return 验证码字符串
	 */
	private String getCaptchaText() {
		if (preDefinedTexts != null && !preDefinedTexts.isEmpty()) {
			String text = preDefinedTexts.get(textCount);
			textCount = (textCount + 1) % preDefinedTexts.size();
			return text;
		} else {
			return producer.createText();
		}
	}
}
