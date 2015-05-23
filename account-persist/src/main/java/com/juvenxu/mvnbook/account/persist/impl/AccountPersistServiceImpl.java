/*******************************************************************
 * Copyright (c) 2007 arvato and others
 * All rights reserved.
 *
 * Contributors:
 * arvato Systems (Shanghai) Co., Ltd.
 * 
 ******************************************************************/
package com.juvenxu.mvnbook.account.persist.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.juvenxu.mvnbook.account.persist.Account;
import com.juvenxu.mvnbook.account.persist.AccountPersistException;
import com.juvenxu.mvnbook.account.persist.AccountPersistService;

/**
 * 账户增删改查接口实现类
 *
 * @author fan.tang
 *
 * @version 2014年11月11日
 *
 */
public class AccountPersistServiceImpl implements AccountPersistService {

	private String file;

	private SAXReader reader = new SAXReader();

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.juvenxu.mvnbook.account.persist.AccountPersistService#createAccount(com.juvenxu.mvnbook.account.persist.Account)
	 *
	 * @param account
	 * @return
	 * @throws AccountPersistException
	 */
	@Override
	public Account createAccount(Account account) throws AccountPersistException {
		Document doc = readDocument();
		
		Element accountsEle = doc.getRootElement().element(ELEMENT_ACCOUNTS);
		Element accountEle = accountsEle.addElement(ELEMENT_ACCOUNT);
		accountEle.addElement(ELEMENT_ACCOUNT_ID).addText(account.getId());
		accountEle.addElement(ELEMENT_ACCOUNT_NAME).addText(account.getName());
		accountEle.addElement(ELEMENT_ACCOUNT_EMAIL).addText(account.getEmail());
		accountEle.addElement(ELEMENT_ACCOUNT_PASSWORD).addText(account.getPassword());
		accountEle.addElement(ELEMENT_ACCOUNT_ACTIVATED).addText(String.valueOf(account.isActivated()));
		
		writeDocument(doc);
		return account;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.juvenxu.mvnbook.account.persist.AccountPersistService#readAccount(java.lang.String)
	 *
	 * @param id
	 * @return
	 * @throws AccountPersistException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Account readAccount(String id) throws AccountPersistException {
		Document doc = readDocument();
		Element accountsEle = doc.getRootElement().element(ELEMENT_ACCOUNTS);
		for (Element accountEle : (List<Element>) accountsEle.elements()) {
			if (accountEle.elementText(ELEMENT_ACCOUNT_ID).equals(id)) {
				return buildAccount(accountEle);
			}
		}
		return null;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.juvenxu.mvnbook.account.persist.AccountPersistService#updateAccount(com.juvenxu.mvnbook.account.persist.Account)
	 *
	 * @param account
	 * @return
	 * @throws AccountPersistException
	 */
	@Override
	public Account updateAccount(Account account) throws AccountPersistException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.juvenxu.mvnbook.account.persist.AccountPersistService#deleteAccount(java.lang.String)
	 *
	 * @param id
	 * @throws AccountPersistException
	 */
	@Override
	public void deleteAccount(String id) throws AccountPersistException {
		// TODO Auto-generated method stub

	}

	/**
	 * 读取所有账户信息
	 * 
	 * @return DOM格式的文档
	 * @throws AccountPersistException
	 *             账户异常
	 */
	private Document readDocument() throws AccountPersistException {
		File dataFile = new File(file);
		if (!dataFile.exists()) {
			dataFile.getParentFile().mkdirs();
			Document doc = DocumentFactory.getInstance().createDocument();
			Element rootEle = doc.addElement(ELEMENT_ROOT);
			rootEle.addElement(ELEMENT_ACCOUNTS);
			writeDocument(doc);
		}
		try {
			return reader.read(new File(file));
		} catch (DocumentException e) {
			throw new AccountPersistException("Unable to read persist data xml", e);
		}
	}

	/**
	 * 以XML格式文件存储DOM文件
	 * 
	 * @param doc
	 *            DOM文件
	 */
	private void writeDocument(Document doc) throws AccountPersistException {
		Writer out = null;
		try {
			out = new OutputStreamWriter(new FileOutputStream(file), "utf-8");

			/*
			 * OutputFormat.createPrettyPrint() 创建一个带缩进和换行的友好格式
			 */
			XMLWriter writer = new XMLWriter(out, OutputFormat.createPrettyPrint());
			writer.write(doc);
		} catch (IOException e) {
			throw new AccountPersistException("Unable to write persist data xml", e);
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				throw new AccountPersistException("Unable to close persist data xml write", e);
			}
		}
	}

	/**
	 * 将XML格式账户转换成Account对象
	 * 
	 * @param accountEle
	 *            XML格式数据
	 * @return Account对象
	 */
	private Account buildAccount(Element accountEle) {
		Account account = new Account();

		account.setId(accountEle.elementText(ELEMENT_ACCOUNT_ID));
		account.setName(accountEle.elementText(ELEMENT_ACCOUNT_NAME));
		account.setEmail(accountEle.elementText(ELEMENT_ACCOUNT_EMAIL));
		account.setPassword(accountEle.elementText(ELEMENT_ACCOUNT_PASSWORD));
		account.setActivated("true".equals(accountEle.elementText(ELEMENT_ACCOUNT_ACTIVATED)) ? true : false);

		return account;
	}

	
	
	public String getFile() {
		return file;
	}

	public void setFile(String file) throws UnsupportedEncodingException {
		this.file = new String(file.getBytes("iso-8859-1"), "utf-8");
	}
	
}
