/*******************************************************************
 * Copyright (c) 2007 arvato and others
 * All rights reserved.
 *
 * Contributors:
 * arvato Systems (Shanghai) Co., Ltd.
 * 
 ******************************************************************/
package com.juvenxu.mvnbook.account.persist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 账户增删改查测试类
 *
 * @author fan.tang
 *
 * @version 2014年11月11日
 *
 */
public class AccountPersistServiceTest {
	
	private AccountPersistService service;
	
	@Before
	public void prepare() throws AccountPersistException{
		File persistDataFile = new File("target/test-classes/persist-data.xml");
		if(persistDataFile.exists()){
			persistDataFile.delete();
		}
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("account-persist.xml");
		service = (AccountPersistService) ctx.getBean("accountPersistService");
		
		Account account = new Account();
		account.setId("juven");
		account.setName("Juven Xu");
		account.setEmail("juven@changeme.com");
		account.setPassword("this_should_be_encrypted");
		account.setActivated(true);
		
		service.createAccount(account);
	}
	
	/**
	 * 测试readAccount(String id)方法
	 * 
	 * @throws AccountPersistException
	 */
	@Test
	public void testReadAccount() throws AccountPersistException{
		Account account = service.readAccount("juven");
		
		assertNotNull(account);
		assertEquals("juven", account.getId());
		assertEquals("Juven Xu", account.getName());
		assertEquals("juven@changeme.com", account.getEmail());
		assertEquals("this_should_be_encrypted", account.getPassword());
		assertTrue(account.isActivated());
	}
}
