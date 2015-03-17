package com.fc.framework.web.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fc.framework.web.common.ReturnMessage;
import com.fc.framework.web.entity.RoleModule;
import com.fc.framework.web.service.base.BaseService;
import com.fc.framework.web.service.impl.RoleModuleServiceImpl;

public class RoleModuleService extends BaseService implements RoleModuleServiceImpl {

	public ReturnMessage addRoleModule(RoleModule roleModule) throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		Session session = super.getSession();
		Transaction ts = session.beginTransaction();
		session.save(roleModule);
		ts.commit();
		rMessage.setSucc(true);
		return rMessage;
	}

	public ReturnMessage delRoleModule(RoleModule roleModule) throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		String hql = "delete from RoleModule where roleid=? and moduleid=?";
		Object[] parameters = {roleModule.getRoleid().toString(),roleModule.getModuleid()};
		super.excuteHql(hql, parameters);
		rMessage.setSucc(true);
		return rMessage;
	}
	
}
