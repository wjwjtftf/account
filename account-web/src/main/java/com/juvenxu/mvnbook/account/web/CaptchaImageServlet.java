/*******************************************************************
 * Copyright (c) 2007 arvato and others
 * All rights reserved.
 *
 * Contributors:
 * arvato Systems (Shanghai) Co., Ltd.
 * 
 ******************************************************************/
package com.juvenxu.mvnbook.account.web;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.juvenxu.mvnbook.account.exception.AccountServiceException;
import com.juvenxu.mvnbook.account.service.AccountService;

/**
 * 验证码服务的servlet类
 *
 * @author fan.tang
 *
 * @version 2014年11月17日
 *
 */
public class CaptchaImageServlet extends HttpServlet {

	/**
	 * 定义可序列版本
	 */
	private static final long serialVersionUID = 4017482534594742026L;

	private ApplicationContext context;

	/**
	 * Servlet初始化回调
	 * 
	 * @see javax.servlet.GenericServlet#init()
	 *
	 * @throws ServletException
	 */
	@Override
	public void init() throws ServletException {
		super.init();
		context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
	}

	/**
	 * GET请求回调
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * POST请求回调
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 *
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		if (key == null || key.length() == 0) {
			response.sendError(400, "No Captcha Key Found!");
		} else {
			AccountService service = (AccountService) context.getBean("accountService");
			OutputStream out = null;
			try {
				response.setContentType("image/jpeg");
				out = response.getOutputStream();
				out.write(service.generateCaptchaImage(key));
			} catch (AccountServiceException e) {
				response.sendError(404, e.getMessage());
			} finally {
				if (out != null) {
					out.close();
				}
			}
		}

	}

}
