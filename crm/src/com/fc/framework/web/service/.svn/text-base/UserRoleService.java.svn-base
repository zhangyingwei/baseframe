package com.fc.framework.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fc.framework.web.common.ReturnMessage;
import com.fc.framework.web.entity.User;
import com.fc.framework.web.entity.UserRole;
import com.fc.framework.web.service.base.BaseService;
import com.fc.framework.web.service.impl.UserRoleServiceImpl;

public class UserRoleService extends BaseService implements UserRoleServiceImpl {

	public ReturnMessage addUserRole(UserRole userRole) throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		super.getHibernateTemplate().save(userRole);
		rMessage.setSucc(true);
		return rMessage;
	}

	public ReturnMessage findUserRole(UserRole userRole) throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		return null;
	}

	public ReturnMessage findRoleByUserId(User user) throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		String hql = "from UserRole where userid=:userid";
		Map map = new HashMap<String, String>();
		map.put("userid", user.getUserid().toString());
		UserRole userRole = (UserRole) super.findByParams(hql, map);
		rMessage.setRet(userRole);
		return rMessage;
	}

	public ReturnMessage updateUserRole(UserRole userRole) throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		Session session = super.getSessionFactory().getCurrentSession();
		Transaction ts = session.beginTransaction();
		session.update(userRole);
		ts.commit();
		rMessage.setSucc(true);
		return rMessage;
	}

	public ReturnMessage delUserRole(UserRole userRole) throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		Session session = super.getTheSession();
		Transaction ts = session.beginTransaction();
		session.delete(userRole);
		ts.commit();
		rMessage.setSucc(true);
		return rMessage;
	}

}
