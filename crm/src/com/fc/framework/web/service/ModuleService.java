package com.fc.framework.web.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fc.framework.web.common.ReturnMessage;
import com.fc.framework.web.entity.Module;
import com.fc.framework.web.entity.Role;
import com.fc.framework.web.entity.RoleModule;
import com.fc.framework.web.entity.User;
import com.fc.framework.web.service.base.BaseService;
import com.fc.framework.web.service.impl.ModuleServiceImpl;

public class ModuleService extends BaseService implements ModuleServiceImpl {

	public ReturnMessage addModule(Module module) throws Exception {
		super.getHibernateTemplate().save(module);
		return null;
	}

	public ReturnMessage delModule(Module module) throws Exception {
		String sql1 = "delete from t_moduleinfo where moduleid=?";
		String sql2 = "delete from t_role_module where moduleid=?";
		String[] param = {module.getModuleid().toString()};
		super.excuteSql(sql1, param);
		super.excuteSql(sql2, param);
		return null;
	}

	public ReturnMessage getAllUserModules(User user) throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		String sql = "SELECT m.moduleid,m.modulename,m.fatherid,m.modulepath FROM t_moduleinfo m "
				+ "LEFT JOIN t_role_module t ON m.moduleid=t.moduleid "
				+ "LEFT JOIN t_roleinfo r ON t.roleid=r.roleid "
				+ "LEFT JOIN t_user_role s ON r.roleid=s.roleid "
				+ "WHERE s.userid=?";
		String[] pamares = { user.getUserid().toString() };
		List list = this.findByParams(sql, pamares);
		List<Module> modules = new ArrayList<Module>();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object[] obj = (Object[]) it.next();
			Module m = new Module();
			m.setModuleid(Integer.valueOf(obj[0].toString()));
			m.setModulename(obj[1].toString());
			m.setFatherid(obj[2].toString());
			m.setModulepath(obj[3].toString());
			modules.add(m);
		}

		rMessage.setSucc(true);
		rMessage.setListret(modules);
		return rMessage;
	}

	public ReturnMessage updateModule(Module module) throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		System.out.println("@:"+module);
		Session session = super.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.update(module);
		tx.commit();
		rMessage.setSucc(true);
		return rMessage;
	}

	public ReturnMessage findAll() throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		String hql = "from Module";
		List<Module> modules = super.getHibernateTemplate().find(hql);
		rMessage.setListret(modules);
		return rMessage;
	}

	public ReturnMessage findById(Module module) throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		String sql = "from Module where moduleid=?";
		Integer[] parames = {module.getModuleid()};
		List<Module> list = this.getHibernateTemplate().find(sql, parames);
		Module m = null;
		Iterator it = list.iterator();
		if(it.hasNext()){
			m = (Module) it.next();
		}
		rMessage.setRet(m);
		return rMessage;
	}

	public ReturnMessage findByRoleId(Role role) throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		String hql = "from RoleModule where roleid=?";
		String[] parames = {role.getRoleid().toString()};
		List list = this.getHibernateTemplate().find(hql,parames);
		rMessage.setListret(list);
		return rMessage;
	}
}
