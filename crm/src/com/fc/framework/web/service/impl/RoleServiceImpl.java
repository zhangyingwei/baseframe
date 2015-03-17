package com.fc.framework.web.service.impl;

import com.fc.framework.web.common.ReturnMessage;
import com.fc.framework.web.entity.Role;

public interface RoleServiceImpl{
	public ReturnMessage findAllRole() throws Exception;
	
	public ReturnMessage addRole(Role role) throws Exception;
	
	public ReturnMessage findRoleByRoleid(Role role) throws Exception;
	
	public ReturnMessage updateRole(Role role) throws Exception;
	
	public ReturnMessage delRole(Role role) throws Exception;
}
