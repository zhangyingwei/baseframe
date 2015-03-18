package com.fc.framework.web.service.impl;

import com.fc.framework.web.common.PageInfo;
import com.fc.framework.web.common.ReturnMessage;
import com.fc.framework.web.entity.Module;
import com.fc.framework.web.entity.Role;
import com.fc.framework.web.entity.User;

public interface ModuleServiceImpl {
	
	public ReturnMessage getAllUserModules(User user) throws Exception;
	
	public ReturnMessage updateModule(Module module) throws Exception;
	
	public ReturnMessage delModule(Module module) throws Exception;
	
	public ReturnMessage addModule(Module module) throws Exception;
	
	public ReturnMessage findAll() throws Exception;
	
	public ReturnMessage findById(Module module)throws Exception;
	
	public ReturnMessage findByRoleId(Role role) throws Exception;
	
	public ReturnMessage findPage(PageInfo pageInfo) throws Exception;
	
	public ReturnMessage getCounts() throws Exception;
}
