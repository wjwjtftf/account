/*******************************************************************
 * Copyright (c) 2015 tangfan
 * All rights reserved.
 *
 * Contributors:
 * all Programmer Pioneers
 * 
 ******************************************************************/
package com.tangfan.java8.datetime;

import java.time.MonthDay;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;

import org.junit.Test;

/**
 * TODO (description of the Class)
 *
 * @author TangFan
 *
 * @version 2015年5月24日
 *
 */
public class TestOthers {
	
	@Test
	public void testOthers(){
		Year year = Year.now();
        YearMonth yearMonth = YearMonth.now();
        MonthDay monthDay = MonthDay.now();

        System.out.println(year);//年
        System.out.println(yearMonth); //年-月
        System.out.println(monthDay); // 月-日

        //周期，如表示10天前  3年5个月前
        Period period1 = Period.ofDays(10);
        System.out.println(period1);
        Period period2 = Period.of(3, 5, 0);
        System.out.println(period2);
	}
}
