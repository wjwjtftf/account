/*******************************************************************
 * Copyright (c) 2015 tangfan
 * All rights reserved.
 *
 * Contributors:
 * all Programmer Pioneers
 * 
 ******************************************************************/
package com.tangfan.java8.datetime;

import java.time.Duration;
import java.time.Instant;

import org.junit.Test;

/**
 * 简单使用java.time的API 。Duration表示两个瞬时时间的时间段 
 *
 * @author TangFan
 *
 * @version 2015年5月24日
 *
 */
public class TestDuration {

	@Test
	public void testDuration() {
		// 表示两个瞬时时间的时间段
		Duration d1 = Duration.between(Instant.ofEpochMilli(System.currentTimeMillis() - 12323123), Instant.now());
		// 得到相应的时差
		System.out.println(d1.toDays());
		System.out.println(d1.toHours());
		System.out.println(d1.toMinutes());
		System.out.println(d1.toMillis());
		System.out.println(d1.toNanos());

		// 1天时差 类似的还有如ofHours()
		Duration d2 = Duration.ofDays(1);
		System.out.println(d2.toDays());
		System.out.println(Duration.ofHours(21).toDays());
	}
}
