/*******************************************************************
 * Copyright (c) 2007 arvato and others
 * All rights reserved.
 *
 * Contributors:
 * arvato Systems (Shanghai) Co., Ltd.
 * 
 ******************************************************************/
package com.juvenxu.mvnbook.account.persist;

/**
 * 账户增删改查接口类
 *
 * @author fan.tang
 *
 * @version 2014年11月11日
 *
 */
public interface AccountPersistService {

	/**
	 * 存储账户信息的XML文件根元素
	 */
	public static final String ELEMENT_ROOT = "account-persist";
	
	/**
	 * 存储账户信息的XML文件账户信息集合
	 */
	public static final String ELEMENT_ACCOUNTS = "accounts";
	
	/**
	 * 存储账户信息的XML文件账户信息
	 */
	public static final String ELEMENT_ACCOUNT = "account";
	
	/**
	 * 存储账户信息的XML文件账户id元素
	 */
	public static final String ELEMENT_ACCOUNT_ID = "id";
	
	/**
	 * 存储账户信息的XML文件账户name元素
	 */
	public static final String ELEMENT_ACCOUNT_NAME = "name";
	
	/**
	 * 存储账户信息的XML文件账户email元素
	 */
	public static final String ELEMENT_ACCOUNT_EMAIL = "email";
	
	/**
	 * 存储账户信息的XML文件账户password元素
	 */
	public static final String ELEMENT_ACCOUNT_PASSWORD = "password";
	
	/**
	 * 存储账户信息的XML文件账户activated元素
	 */
	public static final String ELEMENT_ACCOUNT_ACTIVATED = "activated";

	
	/**
	 * 保存一个账户信息
	 * 
	 * @param account
	 *            账户对象
	 * @return 当前账户对象
	 * @throws AccountPersistException
	 *             账户异常
	 */
	Account createAccount(Account account) throws AccountPersistException;

	/**
	 * 根据ID查询账户信息
	 * 
	 * @param id
	 *            账户唯一编号
	 * @return 账户对象
	 * @throws AccountPersistException
	 *             账户异常
	 */
	Account readAccount(String id) throws AccountPersistException;

	/**
	 * 修改账户信息
	 * 
	 * @param account
	 *            新账户对象
	 * @return 新账户对象
	 * @throws AccountPersistException
	 *             账户异常
	 */
	Account updateAccount(Account account) throws AccountPersistException;

	/**
	 * 删除一个账户
	 * 
	 * @param id
	 *            账户唯一编号
	 * @throws AccountPersistException
	 *             账户异常
	 */
	void deleteAccount(String id) throws AccountPersistException;
}
