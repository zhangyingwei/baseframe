<%@ page language="java" import="java.util.*,com.fc.framework.web.entity.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
    <script type="text/javascript">
        function edit(id){
        	location.href="toeditrole.do?role.roleid="+id;
        }
        function del(id){
			location.href="delrole.do?role.roleid="+id;
        }
        function add(){
			location.href="toroleadd.do";
        }
        function addmodule(id){
        	location.href="toaddmodule2role.do?role.roleid="+id;
        }
    </script>
    <style type="text/css">
        .auto-style1 {
            height: 26px;
        }
    </style>
</head>
<body>
    <table class="table table-striped table-bordered table-condensed" id="top">
        <thead>
            <tr class="tr_detail">
                <td class="auto-style1">角色编号</td>
                <td class="auto-style1">角色名称</td>
                <td class="auto-style1">角色描述</td>
                <td class="auto-style1">创建人编号 </td>
                <td class="auto-style1">创建时间 </td>
                <td class="auto-style1">操作</td>
            </tr>
        </thead>
        <tbody>
        	<%
        		List<Role> roles = (List<Role>)request.getAttribute("roles");
        		for(Role r:roles){
        			%>
		            <tr class="even">
		                <td><%=r.getRoleid() %></td>
		                <td><%=r.getRolename()%></td>
		                <td><%=r.getRoledescribe() %></td>
		                <td><%=r.getCreateuser() %></td>
		                <td><%=r.getCreatedate() %></td>
		                <td>
		                	<input type="button" class="btn btn-warning" id="edit"  name="edit" onclick="edit(<%=r.getRoleid() %>)" value="编辑" />
		                    <input class="btn btn-primary" id="addrole" name="addrole" type="button" onclick="addmodule(<%=r.getRoleid() %>,'<%=r.getRoleid() %>')" value="功能分配" />
		                	<input type="button" class="btn btn-danger" id="del" name="del" onclick="del(<%=r.getRoleid() %>)" value="删除" />
		                </td>
		            </tr>
        			<%
        		}
        		
        	%>
             
            <tr class="tr_pagenumber">
                <td colspan="100">
                    <input class="btn btn-inverse" id="add" name="add" type="button" onclick="add()" value="添加" />
                </td>
            </tr>
        </tbody>
    </table>
</body>
</html>
