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
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;

import org.junit.Test;

/**
 * 简单使用java.time的API 。提供了对java.util.Date的替代，另外还提供了新的DateTimeFormatter用于对格式化/解析的支持。
 *
 * @author TangFan
 *
 * @version 2015年5月24日
 *
 */
public class TestLocalDateTime {

	@Test
	public void testLocalDateTime() throws InterruptedException {
		// 使用默认时区时钟(本机的世界时)瞬时时间创建 Clock.systemDefaultZone() -->即相对于 ZoneId.systemDefault()默认时区
		LocalDateTime now1 = LocalDateTime.now();
		System.out.println(now1 + "---默认时钟");

		// 自定义时区
		LocalDateTime now2 = LocalDateTime.now(ZoneId.of("Europe/Paris"));
		System.out.println(now2 + "---巴黎时区");

		// 自定义时钟(协调时)
		Clock clock = Clock.systemUTC();
		LocalDateTime now3 = LocalDateTime.now(clock);
		System.out.println(now3 + "---UTC时钟");

		// 不需要写什么相对时间 如java.util.Date 年是相对于1900 月是从0开始
		LocalDateTime d1 = LocalDateTime.of(2015, 5, 24, 20, 40);
		System.out.println(d1 + "---年月日时分");

		// 年月日 时分秒 纳秒
		LocalDateTime d2 = LocalDateTime.of(2015, 5, 24, 20, 41, 59, 11);
		System.out.println(d2 + "---年月日时分秒纳秒");

		// 使用瞬时时间 + 时区
		Instant instant = Instant.now();
		LocalDateTime d3 = LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Tokyo"));
		System.out.println(d3 + "---瞬时时间和东京时区");

		// 解析String--->LocalDateTime;后面涉及[秒,毫秒,纳秒]的都不是必须的
		LocalDateTime d4 = LocalDateTime.parse("2015-05-24T21:01:22.22");
		System.out.println(d4 + "---字符串年月日时分秒毫秒");

		// 使用DateTimeFormatter API 解析 和 格式化
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime d5 = LocalDateTime.parse("2015/05/24 21:06:45", formatter);
		System.out.println(d5 + "---DateTimeFormatter格式解析");

		//时间计算
		LocalDateTime d6 = d5.minusDays(1);
		LocalDateTime d7 = d6.plus(1, IsoFields.QUARTER_YEARS);
		System.out.println(d6+"---上个时间减1天");
		System.out.println(d7+"---上个时间加1季度");
		
		// 时间获取
		System.out.println("LocalDateTime属性大家族\n年:" + d5.getYear() + "\n月:" + d5.getMonth() + "\n日/月:"
				+ d5.getDayOfMonth() + "\n日/年:" + d5.getDayOfYear() + "\n日/周:" + d5.getDayOfWeek() + "\n时:"
				+ d5.getHour() + "\n分:" + d5.getMinute() + "\n秒:" + d5.getSecond() + "\n纳秒:" + d4.getNano());
	}
}
