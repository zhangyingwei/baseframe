package com.fc.framework.web.service.impl;

import com.fc.framework.web.common.PageInfo;
import com.fc.framework.web.common.ReturnMessage;
import com.fc.framework.web.entity.User;

public interface UserServiceImpl {
	public ReturnMessage findPage(PageInfo pageInfo) throws Exception;
	
	public ReturnMessage addUser(User user) throws Exception;
	
	public ReturnMessage updateUser(User user) throws Exception;

	public ReturnMessage delUser(User user) throws Exception;
	
	public ReturnMessage delUserByChangeState(User user) throws Exception;

	public ReturnMessage findAllUser() throws Exception;
	
	public ReturnMessage findByUsername(String username) throws Exception;
	
	public ReturnMessage findByUserId(User user) throws Exception;
	
	public ReturnMessage userLoader(User user) throws Exception;
}
