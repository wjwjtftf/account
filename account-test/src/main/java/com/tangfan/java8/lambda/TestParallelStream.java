/*******************************************************************
 * Copyright (c) 2015 tangfan
 * All rights reserved.
 *
 * Contributors:
 * all Programmer Pioneers
 * 
 ******************************************************************/
package com.tangfan.java8.lambda;

import java.util.stream.IntStream;

/**
 * 顺序流和并行流
 *
 * @author TangFan
 *
 * @version 2015年5月24日
 *
 */
public class TestParallelStream {

	/**
	 * main 性能比较
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		long t0 = System.nanoTime();
		// 初始化100万整数流，用顺序流来求能被2整除的数
		IntStream.range(0, 1_000_000).filter(p -> p % 2 == 0).toArray();
		long t1 = System.nanoTime();
		//用并行流流来求能被2整除的数
		IntStream.range(0, 1_000_000).parallel().filter(i -> i % 2 == 0).toArray();
		long t2 = System.nanoTime();
		System.out.printf("serial: %.2fs, parallel %.2fs%n", (t1 - t0) * 1e-9, (t2 - t1) * 1e-9);
	}
}
