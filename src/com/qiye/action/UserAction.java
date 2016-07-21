package com.qiye.action;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.qiye.entity.User;
import com.qiye.service.UserService;
import com.qiye.utils.DateTime;
import com.qiye.utils.Encrypt;


public class UserAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private int id;
	private String name;
	private String password;
	private String repassword;
	private String sex;
	private String email;
	private int power;
	private String message;
	
	private UserService userservice;
	
	
	public UserService getUserservice() {
		return userservice;
	}
	
	@Resource(name="userservice")
	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
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

	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public String register(){
		return "register";
	}
	
	public String save(){
		if(name==null){
			message="用户名不能为空";
			return "error";
		}
		if(!password.equals(repassword)){
			System.out.println(password);
			System.out.println(repassword);
			message="两次密码不一致";
			return "error";
		}
		if(userservice.getByName(name) !=null){
			message="用户已被注册";
			return "error";
		}
		User user = new User();
		user.setName(name);
		user.setPassword(Encrypt.encode(password));
		user.setSex(sex);
		user.setEmail(email);
		user.setPower(0);
		user.setRegtime(DateTime.getDateTime());
		userservice.save(user); //save
		
		message = "注册成功";
		return "usersaveSucc";
	}


	/*public String test(){
		
		System.out.println(request.getSession().getServletContext().getRealPath("/image/")+"image.jpg");
		System.out.println(request.getSession().getServletContext().getRealPath("/image")+"image.jpg");
		System.out.println(request.getRealPath("/image/")+"image.jpg");
		System.out.println(request.getRealPath("/image")+"image.jpg");
		System.out.println(request.getRealPath("image")+"image.jpg");
		System.out.println(request.getRealPath("image/")+"image.jpg");
		
		return "error";
	}*/

		

}
