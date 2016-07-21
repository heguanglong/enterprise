package com.qiye.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
public class DownloadAction extends ActionSupport {

	private String inputPath;//struts2框架注入的原始文件保存路径
	private String fileName;//要下载的文件名
	
	
	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
	
	public String getFileName() {
		System.out.println("getFileName():"+fileName);
		return fileName;
	}

	public void setFileName(String fileName) {
		System.out.println("转码前：setFileName():"+fileName);
		try {//对接受的中文文件名进行转码，否则找不到文件所在的输出流
			this.fileName =new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//this.fileName=fileName;
		System.out.println("转码后setFileName():"+this.fileName);
	}
	
	public InputStream getTargetFile(){
		System.out.println("getTargetFile():"+fileName);
		return ServletActionContext.getServletContext().getResourceAsStream(inputPath+fileName);
	}	
	
}
