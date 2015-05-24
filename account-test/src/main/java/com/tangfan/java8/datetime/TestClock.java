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
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

import org.junit.Test;

/**
 * 简单使用java.time的API 。时钟提供给我们用于访问某个特定 时区的 瞬时时间、日期 和 时间的。
 *
 * @author TangFan
 *
 * @version 2015年5月24日
 *
 */
public class TestClock {

	@Test
	public void testClock() throws InterruptedException {
		// 系统默认UTC时钟（当前瞬时时间 System.currentTimeMillis()）
		Clock c1 = Clock.systemUTC();
		// 每次调用将返回当前瞬时时间（UTC）
		System.out.println(c1.millis() + "系统默认UTC时钟\t" + c1.toString());
		System.out.println(System.currentTimeMillis() + "格林尼治时间");

		// 系统默认时区时钟（当前瞬时时间）
		Clock c2 = Clock.systemDefaultZone();
		// 每次调用将返回当前瞬时时间（UTC）
		System.out.println(c2.millis() + "系统默认时区时钟\t" + c2.toString());

		// 巴黎时区
		Clock c31 = Clock.system(ZoneId.of("Europe/Paris"));
		// 每次调用将返回当前瞬时时间（UTC）
		System.out.println(c31.millis() + "巴黎时区\t" + c31.toString());

		// 上海时区
		Clock c32 = Clock.system(ZoneId.of("Asia/Shanghai"));
		// 每次调用将返回当前瞬时时间（UTC）
		System.out.println(c32.millis() + "上海时区\t" + c32.toString());

		// 固定上海时区时钟
		Clock c4 = Clock.fixed(Instant.now(), ZoneId.of("Asia/Shanghai"));
		System.out.println(c4.millis() + "固定上海时区时钟\t" + c4.toString());

		// 不变 即时钟时钟在那一个点不动
		Thread.sleep(20);
		System.out.println(c4.millis() + "线程沉睡20微秒的上海时区时钟\t" + c4.toString());

		// 相对于系统默认时钟两秒的时钟
		Clock c5 = Clock.offset(c1, Duration.ofSeconds(1));
		System.out.println(c1.millis() + "系统默认UTC时钟\t" + c1.toString());
		System.out.println(c5.millis() + "相对于系统默认时钟一秒的时钟\t" + c5.toString());
		
		System.out.println(c1.getZone() + "\t" + c2.getZone() + "\t" + c31.getZone() + "\t" + c32.getZone());
	}
}
