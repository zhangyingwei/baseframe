package com.fc.framework.web.service.base;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.fc.framework.web.common.AppException;
import com.fc.framework.web.common.PageInfo;
import com.fc.framework.web.common.ReturnMessage;

public class BaseService extends HibernateDaoSupport{
	
	private Session session;
	
	private ReturnMessage rMessage;
	
	public ReturnMessage getrMessage() {
		return new ReturnMessage();
	}
	
	public Session getTheSession() {
		return getSessionFactory().getCurrentSession();
	}

	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	/**
	 * 执行hql语句
	 * @param hql
	 * @param parameters
	 * @return
	 */
	public int excuteHql(String hql, Object[] parameters) {
		int n = getHibernateTemplate().bulkUpdate(hql, parameters);
		return n;
	}
	
	/**
	 * 执行sql语句
	 * @param sql
	 * @param parameters
	 * @return
	 */
	public int excuteSql(String sql, Object[] parameters) {
		Query q = this.getSessionFactory().getCurrentSession().createSQLQuery(sql);
		for (int i = 0; i < parameters.length; i++) {
			q.setParameter(i, parameters[i]);
		}
		return q.executeUpdate();
	}
	
	/**
	 * sql查询结果集
	 * @param sql
	 * @param params
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public List findByParams(String sql,String[] params) throws Exception{
		SQLQuery query = this.getSessionFactory().getCurrentSession().createSQLQuery(sql);
		for(int i = 0; i<params.length;i++){
			query.setParameter(i,params[i]);
		}
		return query.list();
	}
	
	/**
	 * 执行hql查询
	 * @param hql
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Object findByParams(String hql,Map map) throws Exception{
		Object obj = null;
		try {
			Set set = map.keySet();
			Object[] setobj = set.toArray();
			int length = setobj.length;
			String[] keys = new String[length];
			Object[] values = new Object[length];
			for(int i = 0;i<length;i++){
				keys[i] = (String) setobj[i];
				values[i] = map.get(keys[i]);
			}
			List<Object> objs = this.getHibernateTemplate().findByNamedParam(hql, keys, values);
			Iterator it = objs.iterator();
			if(it.hasNext()){
				obj = it.next();
			}
		} catch (Exception e) {
			throw new AppException("findByParams 出错！",e);
		}
		return obj;
	}
	
	/**
	 * 获取总条数
	 * @param hql
	 * @return
	 * @throws Exception
	 */
	public Integer getCounts(String hql) throws Exception{
		Integer count = 0;
		List list = this.getHibernateTemplate().find(hql);
		if(list.size()!=0){
			Iterator it = list.iterator();
			while(it.hasNext()){
				it.next();
				count++;
			}
		}
		return count;
	}
	
	public List findPageInfo(PageInfo pageInfo,String hql) throws Exception{
		pageInfo.setTotal(this.getCounts(hql));
		Query query = super.getSession().createQuery(hql);
		query.setMaxResults(pageInfo.getPageLimit());
		query.setFirstResult(pageInfo.getStart());
		List list = query.list();
		return list;
	}
}
