/*******************************************************************
 * Copyright (c) 2007 arvato and others
 * All rights reserved.
 *
 * Contributors:
 * arvato Systems (Shanghai) Co., Ltd.
 * 
 ******************************************************************/
package com.juvenxu.mvnbook.account.util;

import java.util.Random;

/**
 * 随机生成验证码主键的工具类
 *
 * @author fan.tang
 *
 * @version 2014年11月13日
 *
 */
public class RandomGenerator {
	
	/**
	 * 验证码可选字符
	 */
	private static String range = "0123456789abcdefghijklmnopqrstuvwxyz";
	
	public static synchronized String getRandomString(){
		Random random = new Random();
		StringBuffer result = new StringBuffer();
		
		/*
		 * 开启组装8位随机验证码主键
		 */
		for(int i=0; i<8; i++){
			result.append(range.charAt(random.nextInt(range.length())));
		}
		
		return result.toString();
	}
	
}
