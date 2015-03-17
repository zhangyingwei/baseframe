package com.fc.framework.web.action;

import java.util.Iterator;
import java.util.List;

import com.fc.framework.web.action.base.BaseAction;
import com.fc.framework.web.common.ActionReturn;
import com.fc.framework.web.common.AppException;
import com.fc.framework.web.common.ReturnMessage;
import com.fc.framework.web.entity.Module;
import com.fc.framework.web.entity.User;
import com.fc.framework.web.service.impl.ModuleServiceImpl;
import com.fc.framework.web.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends BaseAction {
	
	@Resource
	private UserServiceImpl userService;
	
	@Resource
	private ModuleServiceImpl moduleService;
	
	private User user;

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String login() throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		System.out.println(user);
		try {
			rMessage = userService.userLoader(user);
			if(rMessage.isSucc()){
				User logonuser = (User)rMessage.getRet();
				System.out.println("logonuser:"+logonuser);
				super.setLogonUser(logonuser);
				
				List<Module> list = moduleService.getAllUserModules(logonuser).getListret();
				super.getRequest().setAttribute("modules", list);
				for(Module mo:list){
					System.out.println(mo);
				}
				
				return ActionReturn.SUCC;
			}else{
				return ActionReturn.ERR;
			}
		} catch (Exception e) {
			throw new AppException("µÇÂ¼Ê§°Ü",e);
		}
	}
}
