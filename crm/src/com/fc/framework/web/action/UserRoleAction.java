package com.fc.framework.web.action;

import javax.annotation.Resource;

import com.fc.framework.web.action.base.BaseAction;
import com.fc.framework.web.common.ActionReturn;
import com.fc.framework.web.entity.User;
import com.fc.framework.web.entity.UserRole;
import com.fc.framework.web.service.impl.UserRoleServiceImpl;

public class UserRoleAction extends BaseAction{
	
	@Resource
	private UserRoleServiceImpl userRoleService;
	
	private UserRole userRole;

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	
	public String addUserRole() throws Exception{
		User user = new User();
		user.setUserid(Integer.valueOf(userRole.getUserid()));
		UserRole userRole2 = (UserRole) userRoleService.findRoleByUserId(user).getRet();
		if(userRole2!=null){
			if(userRole.getRoleid().toString().equals("")){
				userRoleService.delUserRole(userRole2);
			}else{
				userRole2.setRoleid(userRole.getRoleid());
				userRoleService.updateUserRole(userRole2);
			}
		}else{
			userRoleService.addUserRole(userRole);
		}
		return ActionReturn.SUCC;
	}
}
