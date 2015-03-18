<%@ page language="java" import="java.util.*,com.fc.framework.web.entity.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Map map = (Map)request.getAttribute("map");
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
        	location.href="toedit.do?user.userid="+id;
        }
        function del(id){
			location.href="deluser.do?user.userid="+id;
        }
        function add(){
			location.href="toadd.do";
        }
        function addrole(id,name){
        	location.href="role2user.do?user.userid="+id+"&user.username="+name;
        }
		function del2(id){
			location.href="deleteuser.do?user.userid="+id;
		}
		function delclidk(id) {
            $('body').alert({
                type: 'info',
                content:'请选择删除方式',
                buttons: [{
                    id: 'yes',
                    name: '删除',
                    callback: function(){del(id)}
                }, {
                    id: 'no',
                    name: '彻底删除 ',
                    callback: function(){del2(id)}
                }]
            })
        }
		function page(i){
			location.href="getuserpage.do?pageInfo.currentPage="+i;
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
                <td class="auto-style1">用户编号</td>
                <td class="auto-style1">用户名</td>
                <td class="auto-style1">真实姓名</td>
                <td class="auto-style1">性别 </td>
                <td class="auto-style1">年龄 </td>
                <td class="auto-style1">邮箱 </td>
                <td class="auto-style1">电话号码 </td>
                <td class="auto-style1">状态 </td>
                <td class="auto-style1">创建时间 </td>
                <td class="auto-style1">操作</td>
            </tr>
        </thead>
        <tbody>
        	<%
        		List<User> users = (List<User>)map.get("users");
        		for(User u:users){
        			%>
		            <tr class="even">
		                <td><%=u.getUserid() %></td>
		                <td><%=u.getUsername()%></td>
		                <td><%=u.getRealname() %></td>
		                <td><%=u.getSex() %></td>
		                <td><%=u.getAge() %></td>
		                <td><%=u.getMail() %></td>
		                <td><%=u.getPhonenum() %></td>
		                <td><%=u.getState() %></td>
		                <td><%=u.getCreatedate() %></td>
		                <td>
		                	<input type="button" class="btn btn-warning" id="edit"  name="edit" onclick="edit(<%=u.getUserid() %>)" value="编辑" />
		                    <input class="btn btn-primary" id="addrole" name="addrole" type="button" onclick="addrole(<%=u.getUserid() %>,'<%=u.getUsername() %>')" value="角色分配" />
		                	<input type="button" class="btn btn-danger" id="del" name="del" onclick="delclidk(<%=u.getUserid() %>)" value="删除" />
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
    <%@include file="../common/fy.html" %>
</body>
</html>
