package com.qiye.action;

import java.util.ArrayList;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qiye.entity.News;
import com.qiye.entity.User;
import com.qiye.service.NewsService;
import com.qiye.service.UserService;
import com.qiye.utils.DateTime;

public class MainAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private String message;
	
	private NewsService newsservice;
	private String language;
	


	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public NewsService getNewsservice() {
		return newsservice;
	}

	@Resource(name = "newsservice")
	public void setNewsservice(NewsService newsservice) {
		this.newsservice = newsservice;
	}
	
	
	

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	
	
	public String register(){
		return "register";
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public String mainpage(){
		ArrayList<News> lists = (ArrayList<News>) newsservice.listNews(4);
		request.setAttribute("lists", lists);
		return "mainpage";
	}
	public String companyinfo(){
		return "companyinfo";
	}

}
