/*******************************************************************
 * Copyright (c) 2015 tangfan
 * All rights reserved.
 *
 * Contributors:
 * all Programmer Pioneers
 * 
 ******************************************************************/
package com.tangfan.java8.datetime;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

import org.junit.Test;

/**
 * 简单使用java.time的API。 瞬时时间，计算机时间
 *
 * @author TangFan
 *
 * @version 2015年5月24日
 *
 */
public class TestInstant {

	@Test
	public void testInstant() {
		// 瞬时时间 相当于以前的System.currentTimeMillis()
		Instant instant1 = Instant.now();
		// 精确到秒 得到相对于1970-01-01 00:00:00 UTC的一个时间
		System.out.println(instant1.getEpochSecond());
		// 精确到毫秒
		System.out.println(instant1.toEpochMilli());

		// 获取系统UTC默认时钟
		Clock clock1 = Clock.systemUTC();
		// 得到时钟的瞬时时间
		Instant instant2 = Instant.now(clock1);
		System.out.println(instant2.toEpochMilli());

		// 固定瞬时时间时钟
		Clock clock2 = Clock.fixed(instant1, ZoneId.systemDefault());
		Instant instant3 = Instant.now(clock2);
		System.out.println(instant1 == instant3);
	}
}
