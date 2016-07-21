package com.qiye.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.qiye.bean.PageBean;
import com.qiye.entity.Message;
import com.qiye.entity.News;
import com.qiye.service.MessageService;
import com.qiye.service.NewsService;
import com.qiye.utils.DateTime;

/**
 * 
 * 自动注入
 * */
public class MessageAction extends ActionSupport implements ServletResponseAware,
		ServletRequestAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private int id;
	private String title;
	private String content;
	private String uptime;
	private String phone;
	private String mail;
	private String name;
	private int page;
	
	private MessageService messageservice;
	
	

	public MessageService getMessageservice() {
		return messageservice;
	}
	
	@Resource(name="messageservice")
	public void setMessageservice(MessageService messageservice) {
		this.messageservice = messageservice;
	}

	/* 自动注入 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/* 自动注入 */
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUptime() {
		return uptime;
	}

	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String addmessage() {
		return "addmessage";
	}
	
	public String connect(){
		return "connect";
	}
	
	public String add(){
		Message message = new Message();
		message.setId(id);
		message.setTitle(title);
		message.setContent(content);
		message.setUptime(DateTime.getDateTime());
		message.setMail(mail);
		message.setName(name);
		message.setPhone(phone);
		messageservice.addInfo(message);
		
		return "addnewsSucc";
	}
	
	public void delete() throws IOException{
		if(!messageservice.deleteByID(id)){
			
		//	return "error";
		}
		response.getWriter().print("{\"del\":\"true\"}");
//		return "deleteSucc";
	}
	
	public String listall(){
		
		ArrayList<Message> listall = (ArrayList<Message>) messageservice
				.listALL();
		request.setAttribute("listall", listall);
		
		PageBean pagebean = messageservice.queryForPage(15, page, "desc");
		request.setAttribute("pagebean", pagebean);
		return  "listmessage";
	}
	
	public String getmessage(){
		Message message = messageservice.getByID(id);
		request.setAttribute("message", message);
		return "getmessage";
	}
	

	
	
	public String demo(){
		return "demo";
	}
	
}
