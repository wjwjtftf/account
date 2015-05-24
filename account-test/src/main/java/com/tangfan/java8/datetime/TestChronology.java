/*******************************************************************
 * Copyright (c) 2015 tangfan
 * All rights reserved.
 *
 * Contributors:
 * all Programmer Pioneers
 * 
 ******************************************************************/
package com.tangfan.java8.datetime;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.Chronology;
import java.time.chrono.HijrahChronology;

import org.junit.Test;

/**
 * 简单使用java.time的API 。Chronology提供对java.util.Calendar的替换，提供对年历系统的支持
 *
 * @author TangFan
 *
 * @version 2015年5月24日
 *
 */
public class TestChronology {

	@Test
	public void testChronology() {
		Chronology c = HijrahChronology.INSTANCE;
		System.out.println(c.dateNow());
		ChronoLocalDateTime<?> d = c.localDateTime(LocalDateTime.now());
		System.out.println(d);
	}
}
