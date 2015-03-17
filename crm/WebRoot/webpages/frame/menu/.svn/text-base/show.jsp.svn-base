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
    <script type="text/javascript">
        function edit(id){
        	location.href="editmodule.do?module.moduleid="+id;
        }
        function del(id){
			location.href="delmodule.do?module.moduleid="+id;
        }
        function add(){
			location.href="toaddmodule.do";
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
                <td class="auto-style1">菜单编号</td>
                <td class="auto-style1">菜单名称</td>
                <td class="auto-style1">父菜单编号</td>
                <td class="auto-style1">菜单路径</td>
                <td class="auto-style1">操作 </td>
            </tr>
        </thead>
        <tbody>
        	<%
        		List<Module> modules = (List<Module>)request.getAttribute("modules");
        		for(Module m:modules){
        			String moduleid = m.getModuleid().toString();
        			String modulename = m.getModulename();
        			String fatherid = m.getFatherid();
        			String modulepath = m.getModulepath();
        			%>
		            <tr class="even">
		                <td><%=moduleid %></td>
		                <td><%=modulename %></td>
		                <td><%=fatherid %></td>
		                <td><%=modulepath %></td>
		                <td>
		                	<input type="button" class="btn btn-warning" id="edit"  name="edit" onclick="edit(<%=moduleid %>)" value="编辑" />
		                	<input type="button" class="btn btn-danger" id="del" name="del" onclick="del(<%=moduleid %>)" value="删除" />
		                </td>
		            </tr>
        			<%
        		}
        		
        	%>
             
            <tr class="tr_pagenumber">
                <td colspan="100">
                    <input class="btn btn-inverse" id="add" name="add" type="button" onclick="add()" value="添加" /></td>
            </tr>
        </tbody>
    </table>
</body>
</html>
