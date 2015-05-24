/*******************************************************************
 * Copyright (c) 2015 tangfan
 * All rights reserved.
 *
 * Contributors:
 * all Programmer Pioneers
 * 
 ******************************************************************/
package com.tangfan.java8.annotation;

import java.lang.annotation.Repeatable;

/**
 * 储存元素
 *	@Repeatable注解是指向容器
 *
 * @author TangFan
 *
 * @version 2015年5月24日
 *
 */
@Repeatable(Authorities.class)
public @interface Authority {
	String role();
}
