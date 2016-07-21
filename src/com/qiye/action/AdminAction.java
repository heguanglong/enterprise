package com.qiye.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;


import com.qiye.bean.PageBean;
import com.qiye.entity.News;
import com.qiye.entity.Picture;
import com.qiye.entity.User;
import com.qiye.service.MessageService;
import com.qiye.service.NewsService;
import com.qiye.service.PictureService;
import com.qiye.service.UserService;
import com.qiye.utils.Encrypt;

public class AdminAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private String message;
	
	private NewsService newsservice;
	private UserService userservice;
	private MessageService messageservice;
	private PictureService pictureservice;
	

	private String name;
	private String password;
	private int page;
	private int id;
	private String title;
	private String info;
	private String email;
	private String sex;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public NewsService getNewsservice() {
		return newsservice;
	}

	@Resource(name = "newsservice")
	public void setNewsservice(NewsService newsservice) {
		this.newsservice = newsservice;
	}
	
	
	public UserService getUserservice() {
		return userservice;
	}
	
	@Resource(name = "userservice")
	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	public MessageService getMessageservice() {
		return messageservice;
	}
	
	@Resource(name = "messageservice")
	public void setMessageservice(MessageService messageservice) {
		this.messageservice = messageservice;
	}

	public PictureService getPictureservice() {
		return pictureservice;
	}
	
	@Resource(name = "pictureservice")
	public void setPictureservice(PictureService pictureservice) {
		this.pictureservice = pictureservice;
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

	
	
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String login(){
		return "adminlogin";
	}
	public String mainpage(){
		return "adminloginSucc";
	}
	
	public String logincheck(){	
		System.out.println(name);
		System.out.println(password);
		User u2 = new User();
		u2.setName(name);
		request.getSession().setAttribute("loginadmin", u2);
		User user = userservice.getByName(name);
		if(user ==null){
			System.out.println("用户为空");
			message = "用户为空";
			return "adminlogin";
		}
		if(!user.getPassword().equalsIgnoreCase(Encrypt.encode(password))){
			System.out.println("用户密码为错误");
			message = "用户密码为错误";
			return "adminlogin";
		}
		if(user.getPower()==0){
			System.out.println("用户权限不够");
			message = "用户权限不够";
			return "adminlogin";
		}
		request.getSession().setAttribute("admin", user);
		return "adminloginSucc";
			
	}
	
	
	public String listnews(){
		
		PageBean pagebean = newsservice.queryForPage(15, page, "desc");
		request.setAttribute("pagebean", pagebean);
		return  "adminlistnews";
	}
	
	public String listmessages(){
		
		PageBean pagebean = messageservice.queryForPage(15, page, "desc");
		request.setAttribute("pagebean", pagebean);
		return "adminlistmessages";
	}
	
	public String listusers(){
		PageBean pagebean = userservice.queryForPage(15, page, "desc");
		request.setAttribute("pagebean", pagebean);
		return "adminlistusers";
	}
	
	
	public String listpictures(){
		PageBean pagebean = pictureservice.queryForPage(5, page, "desc");
		request.setAttribute("pagebean", pagebean);
		return "adminlistpictures";
	}	
	public String addnews(){
		return "adminaddnews";
	}	
	
	public String upload(){
		return "pictureupload";
	}
	
	public String autoupload(){
		return "autoupload";
	}
	
	public String getnews(){
		News news = newsservice.getNewsByID(id);
		request.setAttribute("news", news);
		return "admingetnews";
	}
	
	public String updatepictureinput(){
		Picture picture = pictureservice.findById(Picture.class, id);
		request.setAttribute("picture", picture);
		return "updatepictureinput";
	}
	
	public String pictureupdate(){
		Picture picture = pictureservice.findById(Picture.class, id);
		picture.setTitle(title);
		picture.setInfo(info);
		pictureservice.update(picture);
		message="更新成功";
		return "pictureupdateSucc";
	}
	

	
	public String getuser(){
		User user = userservice.getByID(id);
		request.setAttribute("user", user);
		return "getuser";
	}
	
	public String addadmin(){
		User admin = (User)request.getSession().getAttribute("admin");
		User user = userservice.getByID(id);
		if(!admin.getName().equals(user.getName())){
			user.setPower(2);
			userservice.update(user);
			message="成功将"+user.getName()+"提升为管理员";
		}else
			message="不能对自己进行操作";
		
		return "addadminSucc";
	}
	
	public String deleteadmin(){
		User admin = (User)request.getSession().getAttribute("admin");
		User user = userservice.getByID(id);
		if(!admin.getName().equals(user.getName())){
			user.setPower(0);
			userservice.update(user);
			message="成功将"+user.getName()+"取消管理员";
		}else
			message="不能对自己进行操作";
		
		
		return "deleteadminSucc";
	}
	
	public String deleteuser(){
		User admin = (User)request.getSession().getAttribute("admin");
		User user = userservice.getByID(id);
		if(admin.getPower()<=user.getPower()){
			message="您的权限不够，不能删除改用户";
			return "Succ";
		}else{
			userservice.deleteById(id);
			message="删除成功";
		}
		
		return "Succ";
	}
	public String updateuser(){
		
		User user = userservice.getByID(id);
		if(user==null){
			message="不存在该用户！";
			return "updateSucc";
		}else{
			user.setEmail(email);
			user.setSex(sex);
			user.setName(name);
			userservice.update(user);
			message="更新成功";
		}
		
		return "updateSucc";
	}
	
	public String logout(){
		request.getSession().removeAttribute("admin");
		return "adminlogin";
	}
	public String getpassword(){
		request.setAttribute("id", id);
		return "getpassword";
	}
	public String password(){
		User user=userservice.getByID(id);
		if(user!=null){
			user.setPassword(Encrypt.encode(password));
			userservice.update(user);
			message="修改成功！";
		}else{
			message="修改失败，没有该用户！";
		}
		return "password";
		
	}
}
