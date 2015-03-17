package com.fc.framework.web.action;

import java.util.List;

import javax.annotation.Resource;

import com.fc.framework.web.action.base.BaseAction;
import com.fc.framework.web.common.ActionReturn;
import com.fc.framework.web.common.AppException;
import com.fc.framework.web.entity.Module;
import com.fc.framework.web.service.impl.ModuleServiceImpl;
import com.fc.framework.web.util.DateUtil;

public class ModuleAction extends BaseAction {

	@Resource
	private ModuleServiceImpl moduleService;
	
	private Module module;

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public String findAllModule() throws Exception {
		List list = moduleService.findAll().getListret();
		super.getRequest().setAttribute("modules", list);
		super.getRequest().getSession().setAttribute("modules", list);
		return ActionReturn.SUCC;
	}
	
	public String toAddModule(){
		return ActionReturn.SUCC;
	}
	
	public String addModule()throws Exception{
		this.module.setCreatedate(DateUtil.getDateTime());
		this.module.setCreateuser(super.getLogonUser().getUserid().toString());
		moduleService.addModule(module);
		return ActionReturn.SUCC;
	}
	
	public String delModule() throws Exception{
		moduleService.delModule(module);
		return ActionReturn.SUCC;
	}
	
	public String findById() throws Exception{
		Module m = (Module) moduleService.findById(module).getRet();
		super.getRequest().setAttribute("module", m);
		return ActionReturn.SUCC;
	}
	
	public String updateModule()throws Exception{
		moduleService.updateModule(module);
		return ActionReturn.SUCC;
	}
}
