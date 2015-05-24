/*******************************************************************
 * Copyright (c) 2015 tangfan
 * All rights reserved.
 *
 * Contributors:
 * all Programmer Pioneers
 * 
 ******************************************************************/
package com.tangfan.java8.lambda;

/**
 * Lambda表达式测试类
 *
 * @author TangFan
 *
 * @version 2015年5月24日
 *
 */
public class TestLambda {

	/**
	 * main test lambda
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestLambda.runThreadUseLambda();
	}
	
	private static void runThreadUseLambda(){
		new Thread(() -> System.out.println("lambda实现的线程")).start();
	}

}
