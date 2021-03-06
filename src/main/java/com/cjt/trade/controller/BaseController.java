package com.cjt.trade.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController{

	private String base;
	/**
	 * 获取项目线上根路径，并传到页面上
	 */
	@ModelAttribute
	public void initPath(HttpServletRequest request, Model model) {
		/*base = request.getScheme() + "://" + request.getServerName() + ":"
				+ request.getServerPort();*/
		base = request.getContextPath();
		model.addAttribute("base", base);
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getRequestUrl(HttpServletRequest request) {
		StringBuffer buffer = request.getRequestURL();
		return buffer.toString();
	}
}
