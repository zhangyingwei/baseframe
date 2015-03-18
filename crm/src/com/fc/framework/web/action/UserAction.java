package com.fc.framework.web.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.fc.framework.web.action.base.BaseAction;
import com.fc.framework.web.common.ActionReturn;
import com.fc.framework.web.entity.User;
import com.fc.framework.web.entity.UserRole;
import com.fc.framework.web.service.impl.RoleServiceImpl;
import com.fc.framework.web.service.impl.UserRoleServiceImpl;
import com.fc.framework.web.service.impl.UserServiceImpl;
import com.fc.framework.web.util.DateUtil;
import com.fc.framework.web.util.MD5Util;

public class UserAction extends BaseAction{
	@Resource
	private UserServiceImpl userService;
	
	@Resource
	private RoleServiceImpl roleService;
	
	@Resource
	private UserRoleServiceImpl userRoleService;
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String findPage() throws Exception {
		List list = userService.findPage(super.getPageInfo()).getListret();
		Map map = super.getReturnMap();
		map.put("users", list);
		map.put("pageInfo", super.getPageInfo());
		super.getRequest().setAttribute("map", map);
		return ActionReturn.SUCC;
	}
	
	public String findAllUser() throws Exception{
		List list = (List<User>) userService.findAllUser().getListret();
		System.out.println("@:"+list.iterator().next());
		super.getRequest().setAttribute("users", list);
		return ActionReturn.SUCC;
	}
	
	public String toAdd(){
		return ActionReturn.SUCC;
	}
	
	public String addUser() throws Exception{
		String password = user.getPassword();
		user.setPassword(MD5Util.encoder(password));
		user.setCreatedate(DateUtil.getDateTime());
		user.setState("0");
		userService.addUser(user);
		return ActionReturn.SUCC;
	}
	
	public String toEditUser() throws Exception{
		User user2 = (User) userService.findByUserId(user).getRet();
		super.getRequest().setAttribute("user", user2);
		return ActionReturn.SUCC;
	}
	
	public String editUser() throws Exception{
		userService.updateUser(user);
		return ActionReturn.SUCC;
	}
	
	public String delUser() throws Exception{
		userService.delUser(user);
		return ActionReturn.SUCC;
	}
	
	public String delUserByChangeState() throws Exception{
		userService.delUserByChangeState(user);
		return ActionReturn.SUCC;
	}
	
	public String role2User() throws Exception{
		List list = roleService.findAllRole().getListret();
		UserRole userRole = (UserRole) userRoleService.findRoleByUserId(user).getRet();
		super.getRequest().setAttribute("roles", list);
		super.getRequest().setAttribute("user", user);
		super.getRequest().setAttribute("roleid", userRole==null?"":userRole.getRoleid());
		
		return ActionReturn.SUCC;
	}
	
	public String userAddRole() throws Exception{
		
		return ActionReturn.SUCC;
	}
}
