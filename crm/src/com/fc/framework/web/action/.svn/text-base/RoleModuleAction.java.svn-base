package com.fc.framework.web.action;

import javax.annotation.Resource;
import javax.xml.ws.Response;

import com.fc.framework.web.action.base.BaseAction;
import com.fc.framework.web.common.ActionReturn;
import com.fc.framework.web.entity.RoleModule;
import com.fc.framework.web.service.impl.RoleModuleServiceImpl;

public class RoleModuleAction extends BaseAction {
	
	@Resource
	private RoleModuleServiceImpl roleModuleService;
	
	private RoleModule roleModule;

	public RoleModule getRoleModule() {
		return roleModule;
	}

	public void setRoleModule(RoleModule roleModule) {
		this.roleModule = roleModule;
	}
	
	public String addRoleModule() throws Exception{
		roleModuleService.addRoleModule(roleModule);
		super.getWriter().print(1);
		return null;
	}
	
	public String delRoleModule() throws Exception{
		roleModuleService.delRoleModule(roleModule);
		super.getResponse().getWriter().print(0);
		return null;
	}
}
