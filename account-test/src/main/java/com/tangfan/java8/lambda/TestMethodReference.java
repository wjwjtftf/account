/*******************************************************************
 * Copyright (c) 2015 tangfan
 * All rights reserved.
 *
 * Contributors:
 * all Programmer Pioneers
 * 
 ******************************************************************/
package com.tangfan.java8.lambda;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 测试Lambda方法实现
 *
 * @author TangFan
 *
 * @version 2015年5月24日
 *
 */
public class TestMethodReference {

	/**
	 * main Lambda method refernce
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		jFrame.setSize(400, 300);
		int w = (Toolkit.getDefaultToolkit().getScreenSize().width - jFrame.getWidth()) / 2;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height - jFrame.getHeight()) / 2;
		jFrame.setLocation(w, h);

		jFrame.setLayout(new FlowLayout());
		JButton button1 = new JButton("点我!");
		JButton button2 = new JButton("也点我!");
		jFrame.getContentPane().add(button1);
		jFrame.getContentPane().add(button2);

		button1.addActionListener(e -> {
			System.out.println("这是Lambda的实现方式");
		});
		button2.addActionListener(TestMethodReference::doSomething);
		
		jFrame.setVisible(true);
	}

	public static void doSomething(ActionEvent e) {
		System.out.println("这里是方法引用实现方式");
	}
}
