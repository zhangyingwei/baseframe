package com.fc.framework.web.filter;

import java.util.Map;

import com.fc.framework.web.action.RoleAction;
import com.fc.framework.web.common.AppException;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class MyInterceptor implements Interceptor{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		Map sessionMap = invocation.getInvocationContext().getSession();
		String username = (String)sessionMap.get("username");
		
		if (username != null) {
			return invocation.invoke();
		}
		return "error";
	}


}