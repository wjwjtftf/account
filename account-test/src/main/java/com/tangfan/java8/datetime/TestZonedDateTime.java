/*******************************************************************
 * Copyright (c) 2015 tangfan
 * All rights reserved.
 *
 * Contributors:
 * all Programmer Pioneers
 * 
 ******************************************************************/
package com.tangfan.java8.datetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Test;

/**
 * 简单使用java.time的API 。即带有时区的date-time 存储纳秒、时区和时差（避免与本地date-time歧义）。
 *
 * @author TangFan
 *
 * @version 2015年5月24日
 *
 */
/*
 * 这里有个问题啊ZonedDateTime.parse() 如果是10月几号，或是11、12月，Paris的时区显示+01:00 明明是东二区。。。
 */
public class TestZonedDateTime {

	@Test
	public void testZonedDateTime() {
		// API和LocalDateTime类似，只是多了时差(如2013-12-20T10:35:50.711+08:00[Asia/Shanghai])
		ZonedDateTime now1 = ZonedDateTime.now();
		System.out.println(now1 + "---默认时钟");

		ZonedDateTime now2 = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
		System.out.println(now2 + "---巴黎时区");

		ZonedDateTime z1 = ZonedDateTime.parse("2015-10-29T23:59:59Z[Europe/Paris]");
		System.out.println(z1+"---错误的巴黎时区");
	}
}
