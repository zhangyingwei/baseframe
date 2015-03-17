package com.fc.framework.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Service;

import com.fc.framework.web.common.ReturnMessage;
import com.fc.framework.web.entity.User;
import com.fc.framework.web.service.base.BaseService;
import com.fc.framework.web.service.impl.UserServiceImpl;
import com.fc.framework.web.util.MD5Util;

public class UserService extends BaseService implements UserServiceImpl{

	public ReturnMessage addUser(User user) throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		super.getHibernateTemplate().save(user);
		return rMessage;
	}

	public ReturnMessage delUser(User user) throws Exception {
		Session session = super.getSessionFactory().getCurrentSession();
		Transaction ts = session.beginTransaction();
		session.delete(user);
		ts.commit();
		return null;
	}

	public ReturnMessage findAllUser() throws Exception {
		ReturnMessage rMessage = super.getrMessage();
		String hql = "from User";
		List<User> list = super.getHibernateTemplate().find(hql);
		rMessage.setListret(list);
		return rMessage;
	}

	public ReturnMessage findByUsername(String username) throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		String hql = "from User where username=:username and state=0";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		User user2 = (User) super.findByParams(hql, map);
		rMessage.setRet(user2);
		return rMessage;
	}

	public ReturnMessage updateUser(User user) throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		Session session = super.getSessionFactory().getCurrentSession();
		Transaction ts = session.beginTransaction();
		session.update(user);
		ts.commit();
		rMessage.setSucc(true);
		return rMessage;
	}

	//ÓÃ»§µÇÂ¼Æ÷
	public ReturnMessage userLoader(User user) throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		boolean flag = false;
		User user2 = (User)(this.findByUsername(user.getUsername()).getRet());
		if(user2==(null)){
			rMessage.setSucc(false);
			return rMessage;
		}
		if((MD5Util.encoder(user.getPassword())).equals(user2.getPassword())){
			flag = true;
		}
		rMessage.setRet(user2);
		rMessage.setSucc(flag);
		return rMessage;
	}

	public ReturnMessage findByUserId(User user) throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		String hql = "from User where userid=:userid";
		Map map = new HashMap<String, String>();
		map.put("userid", user.getUserid());
		User user2 = (User) super.findByParams(hql, map);
		rMessage.setRet(user2);
		return rMessage;
	}

	public ReturnMessage delUserByChangeState(User user) throws Exception {
		ReturnMessage rMessage = new ReturnMessage();
		String hql = "update User set state=1 where userid=?";
		Object[] parames = {user.getUserid()};
		super.excuteHql(hql, parames);
		rMessage.setSucc(true);
		return rMessage;
	}
}