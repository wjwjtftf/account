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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.juvenxu.mvnbook.account.exception.AccountServiceException;
import com.juvenxu.mvnbook.account.pojo.SignUpRequest;
import com.juvenxu.mvnbook.account.service.AccountService;

/**
 * 账户注册服务的servlet类
 *
 * @author fan.tang
 *
 * @version 2014年11月17日
 *
 */
public class SignUpServlet extends HttpServlet {

	/**
	 * 定义可序列版本
	 */
	private static final long serialVersionUID = -2669747783389815165L;

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
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirm_password");
		String captchaKey = request.getParameter("captcha_key");
		String captchaValue = request.getParameter("captcha_value");
		if (id == null || id.length() == 0 || email == null || email.length() == 0 || name == null || name.length() == 0
				|| password == null || password.length() == 0 || confirmPassword == null || confirmPassword.length() == 0
				|| captchaKey == null || captchaKey.length() == 0 || captchaValue == null || captchaValue.length() == 0) {
			response.sendError(400, "Parameter Incomplete.");
			return;
		}

		AccountService service = (AccountService) context.getBean("accountService");

		SignUpRequest singUpRequest = new SignUpRequest();

		singUpRequest.setId(id);
		singUpRequest.setEmail(email);
		singUpRequest.setName(name);
		singUpRequest.setPassword(password);
		singUpRequest.setConfirmPassword(confirmPassword);
		singUpRequest.setCaptchaKey(captchaKey);
		singUpRequest.setCaptchaValue(captchaValue);

		singUpRequest.setActivateServiceUrl(getServletContext().getRealPath("/") + "activate");

		try {
			service.signUp(singUpRequest);
			response.getWriter().print("Account is created, please check your mail box for activation link.");
		} catch (AccountServiceException e) {
			response.sendError(400, e.getMessage());
			return;
		}
	}

}
