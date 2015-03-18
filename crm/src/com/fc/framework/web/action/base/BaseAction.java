package com.fc.framework.web.action.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.fc.framework.web.common.PageInfo;
import com.fc.framework.web.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
	protected PrintWriter writer;
	
	protected PageInfo pageInfo;
	
	protected Map returnMap;
	
	public Map getReturnMap() {
		return new HashMap<String, Object>();
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	
	public HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	
	public PrintWriter getWriter() throws Exception {
		return this.getResponse().getWriter();
	}

	public User getLogonUser() {
		User logonUser = (User) this.getRequest().getSession().getAttribute("user");
		return logonUser;
	}

	public void setLogonUser(User logonUser) {
		this.getRequest().setAttribute("user", logonUser);
		this.getRequest().getSession().setAttribute("user", logonUser);
	}
}
