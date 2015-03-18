package com.fc.framework.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.fc.framework.web.action.base.BaseAction;
import com.fc.framework.web.common.ActionReturn;
import com.fc.framework.web.entity.Role;
import com.fc.framework.web.service.impl.ModuleServiceImpl;
import com.fc.framework.web.service.impl.RoleServiceImpl;
import com.fc.framework.web.util.DateUtil;

public class RoleAction extends BaseAction{
	
	@Resource
	private RoleServiceImpl roleService;
	
	@Resource
	private ModuleServiceImpl moduleService;
	
	private Role role;
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}

	public String findPage() throws Exception{
		List list = roleService.findPage(super.getPageInfo()).getListret();
		Map map = super.getReturnMap();
		map.put("roles", list);
		map.put("pageInfo", super.getPageInfo());
		super.getRequest().setAttribute("map", map);
		return ActionReturn.SUCC;
	}
	
	public String findAllRole() throws Exception{
		List list = roleService.findAllRole().getListret();
		super.getRequest().setAttribute("roles", list);
		return ActionReturn.SUCC;
	}
	
	public String toRoleAdd() throws Exception{
		return ActionReturn.SUCC;
	}
	
	public String roleAdd() throws Exception{
		role.setCreateuser(super.getLogonUser().getUserid().toString());
		role.setCreatedate(DateUtil.getDateTime());
		roleService.addRole(role);
		return ActionReturn.SUCC;
	}
	
	public String toEditRole() throws Exception{
		Role role2 = (Role) roleService.findRoleByRoleid(role).getRet();
		super.getRequest().setAttribute("role", role2);
		return ActionReturn.SUCC;
	}
	
	public String editRole() throws Exception{
		roleService.updateRole(role);
		return ActionReturn.SUCC;
	}
	
	public String delRole() throws Exception{
		roleService.delRole(role);
		return ActionReturn.SUCC;
	}
	
	public String toAddModule2Role() throws Exception{
		List list = moduleService.findAll().getListret();
		List list2 = moduleService.findByRoleId(role).getListret();
		Map map = new HashMap<String, Object>();
		map.put("modules", list);
		map.put("role", role);
		map.put("mymodules", list2);
		super.getRequest().setAttribute("map", map);
		return ActionReturn.SUCC;
	}
}
