<%@ page language="java" import="java.util.*,com.fc.framework.web.entity.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Role role = (Role)request.getAttribute("role");
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
       function cansub(){
           if($('#rolename').val() == ''){
        	   $('body').alert({
            	   content: '角色名称不能为空!',
                   type: 'warning'
               });
               return false;
           }
           return true;
       }
    </script>
</head>
<body>
	<form method="post" action="editrole.do" onsubmit="return cansub()">
	    <table class="table table-striped table-bordered table-condensed list">
	        <thead>
	            <tr class="conheight">
	                <td colspan="2">角色编辑<i class="tip-up"></i></td>
	            </tr>
	        </thead>
	        <tbody>
	        	<tr class="conheight">
	                <td class="span2">角色编号</td>
	                <td>
	                    <input type="text" id="roleid" name="role.roleid" class="span4" readonly value="<%=role.getRoleid() %>" />
	                </td>
	            </tr>
	            <tr class="conheight">
	                <td class="span2">角色名称</td>
	                <td>
	                    <input type="text" id="rolename" name="role.rolename" class="span4" value="<%=role.getRolename() %>"/>
	                </td>
	            </tr>
	            <tr class="conheight">
	                <td class="span2">角色描述 </td>
	                <td>
	                    <input type="text" id="roledescribe" name="role.roledescribe" class="span4" value="<%=role.getRoledescribe() %>" />
	                </td>
	            </tr>
	            <tr class="conheight">
	                <td class="span2">创建人编号 </td>
	                <td>
	                    <input type="text" id="createuser" name="role.createuser" class="span4" readonly value="<%=role.getCreateuser() %>" />
	                </td>
	            </tr>
	            <tr class="conheight">
	                <td class="span2">创建时间 </td>
	                <td>
	                    <input type="text" id="createdate" name="role.createdate" class="span4" readonly value="<%=role.getCreatedate() %>" />
	                </td>
	            </tr>
				<tr class="conheight">
	                <td>&nbsp;操作</td>
	                <td>
	                    <input type="submit" class="btn btn-default btn-primary add" value="提交" />
	               	</td>
				</tr>
	        </tbody>
	    </table>
    </form>
</body>
</html>
