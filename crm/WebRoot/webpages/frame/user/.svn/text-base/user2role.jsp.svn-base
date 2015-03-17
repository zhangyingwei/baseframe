<%@ page language="java" import="java.util.*,com.fc.framework.web.entity.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Role> roles = (List<Role>)request.getAttribute("roles");
User user = (User)request.getAttribute("user");
String roleid = (String)request.getAttribute("roleid");
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="Styles/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="Styles/admin-all.css" />
    <script type="text/javascript" src="Scripts/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="Scripts/jquery-ui-1.8.22.custom.min.js"></script>
    <link rel="stylesheet" type="text/css" href="Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
    <script type="text/javascript" src="Scripts/ChurAlert.min.js?skin=blue"></script>
    <script type="text/javascript" src="Scripts/chur-alert.1.0.js"></script>
    <link rel="stylesheet" type="text/css" href="Styles/chur.css" />
    <style type="text/css">
    	.conheight{
    		height:30px;
    	}
    </style>
    <script type="text/javascript">
    </script>
</head>
<body>
	<form method="post" action="adduserrole.do">
	    <table class="table table-striped table-bordered table-condensed list">
	    	<thead>
	            <tr class="conheight">
	                <td colspan="2">角色分配<i class="tip-up"></i></td>
	            </tr>
	        </thead>
	        <tbody>
	        	<tr class="conheight">
	            	<td class="auto-style1">用户名</td>
	                <td>
	                	<input type="hidden" name="userRole.userid" class="span4" value="<%=user.getUserid() %>"/>
	                	<input type="text" name="username" class="span4" value="<%=user.getUsername() %>"/>
	                </td>
	            </tr>
	            <tr class="conheight">
	            	<td class="auto-style1">角色</td>
	                <td>
		                <select class="span4" name="userRole.roleid">
		                	<option value=""  <%if(roleid.equals("")){%>selected="selected"<%} %> >---没有角色---</option>
		                	<%
		                		for(Role r:roles){
		                			%>
				                    <option value="<%=r.getRoleid() %>"  <%if(r.getRoleid().toString().equals(roleid.toString())){%>selected="selected"<%} %> ><%=r.getRolename() %></option>
		                			<%
		                		}
		                	%>
		                </select>
	                </td>
	            </tr>
	            <tr class="conheight">
	            	<td class="auto-style1">操作</td>
	                <td>
	                    <input type="submit" class="btn btn-default btn-primary add" value="提交" />
	               	</td>
	            </tr>
	        </tbody>
	    </table>
    </form>
</body>
</html>
