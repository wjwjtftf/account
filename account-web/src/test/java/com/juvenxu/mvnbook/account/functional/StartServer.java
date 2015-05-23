/*******************************************************************
 * Copyright (c) 2007 arvato and others
 * All rights reserved.
 *
 * Contributors:
 * arvato Systems (Shanghai) Co., Ltd.
 * 
 ******************************************************************/
package com.juvenxu.mvnbook.account.functional;

/**
 * 使用Jetty运行调试Web应用, 在Console输入回车快速重新加载应用.
 *
 * @author fan.tang
 *
 * @version 2014年11月17日
 *
 */
public class StartServer {
	
	public static final int		PORT		= 8068;
	public static final String	CONTEXT		= "/test";
	public static final String	BASE_URL	= "http://localhost:8068/test";
	
	public static void main(String[] args) {
		// 设定Spring的profile
		System.setProperty("spring.profiles.active", "development");
		
		// 启动Jetty
//		Server server = JettyFactory.createServerInSource(PORT, CONTEXT);
	}
	
}
