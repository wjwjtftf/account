/*******************************************************************
 * Copyright (c) 2015 tangfan
 * All rights reserved.
 *
 * Contributors:
 * all Programmer Pioneers
 * 
 ******************************************************************/
package com.tangfan.java8.annotation;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * 测试类型注解，被用来支持在Java的程序中做强类型检查
 *
 * @author TangFan
 *
 * @version 2015年5月24日
 *
 */
@Data
public class TestType {
	
	private List<@NonNull String> list = new ArrayList<>(0);
	
	/**
	 * 这里的注解可以重复，实际上相当于注解了
	 * @Authorities(value={@Authority(role="A"),@Authority(role="B")})
	 * value=	可以去掉
	 */
	@Authority(role="A")
	@Authority(role="B")
//	@Authorities({@Authority(role="A"),@Authority(role="B")})
	public void doSomething(){
		
	}
}
