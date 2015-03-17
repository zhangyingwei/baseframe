package com.fc.framework.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fc.framework.web.common.ReturnMessage;
import com.fc.framework.web.entity.Role;
import com.fc.framework.web.service.base.BaseService;
import com.fc.framework.web.service.impl.RoleServiceImpl;

public class RoleService extends BaseService implements RoleServiceImpl {

	public ReturnMessage findAllRole() throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		String hql = "from Role";
		List list = super.getHibernateTemplate().find(hql);
		rMessage.setListret(list);
		return rMessage;
	}

	public ReturnMessage addRole(Role role) throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		Session session = super.getSession();
		Transaction ts = session.beginTransaction();
		session.save(role);
		ts.commit();
		rMessage.setSucc(true);
		return rMessage;
	}

	public ReturnMessage findRoleByRoleid(Role role) throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		String hql = "from Role where roleid=:roleid";
		Map map = new HashMap<String, Object>();
		map.put("roleid", role.getRoleid());
		Role role2 = (Role) super.findByParams(hql, map);
		rMessage.setRet(role2);
		return rMessage;
	}

	public ReturnMessage updateRole(Role role) throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		Session session = super.getSession();
		Transaction ts = session.beginTransaction();
		session.update(role);
		ts.commit();
		rMessage.setSucc(true);
		return rMessage;
	}

	public ReturnMessage delRole(Role role) throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		Session session = super.getSession();
		Transaction ts = session.beginTransaction();
		session.delete(role);
		ts.commit();
		rMessage.setSucc(true);
		return rMessage;
	}
}
