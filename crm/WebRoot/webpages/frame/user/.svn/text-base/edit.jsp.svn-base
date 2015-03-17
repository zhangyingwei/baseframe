<%@ page language="java" import="java.util.*,com.fc.framework.web.entity.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
User user = (User)request.getAttribute("user");
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
           if($('#username').val() == '' || $('#password').val() == ''){
        	   $('body').alert({
            	   content: '用户名和密码不能为空!',
                   type: 'warning'
               });
               return false;
           }
           return true;
       }
    </script>
</head>
<body>
	<form method="post" action="update.do" onsubmit="return cansub()">
	    <table class="table table-striped table-bordered table-condensed list">
	        <thead>
	            <tr class="conheight">
	                <td colspan="2">用户添加<i class="tip-up"></i></td>
	            </tr>
	        </thead>
	        <tbody>
	        	<tr class="conheight">
	                <td class="span2">用户编号 </td>
	                <td>
	                    <input type="text" id="userid" name="user.userid" readonly class="span4" value="<%=user.getUserid() %>" />
	                </td>
	            </tr>
	            <tr class="conheight">
	                <td class="span2">用户名 </td>
	                <td>
	                    <input type="text" id="username" name="user.username" class="span4" value="<%=user.getUsername() %>" />
	                </td>
	            </tr>
	            <tr class="conheight">
	                <td class="span2">密码 </td>
	                <td>
	                    <input type="text" id="password" name="user.password" class="span4" readonly value="<%=user.getPassword() %>" />
	                </td>
	            </tr>
	            <tr class="conheight">
	                <td class="span2">真实姓名 </td>
	                <td>
	                    <input type="text" id="realname" name="user.realname" class="span4" value="<%=user.getRealname() %>" />
	                </td>
	            </tr>
	            <tr class="conheight">
	                <td>性别</td>
	                <td>
		                <select class="span4" name="user.sex" value="<%=user.getSex() %>">
		                    <option value="0" <%if(user.getSex().equals("0")){%>selected="selected"<%} %>>女</option>
		                    <option value="1" <%if(user.getSex().equals("1")){%>selected="selected"<%} %> >男</option>
		                </select>
	                </td>
	            </tr>
				<tr class="conheight">
	                <td>年龄 </td>
	                <td>
	                    <input type="text" name="user.age" class="span4" value="<%=user.getAge() %>" />
	                </td>
				</tr>
				<tr class="conheight">
	                <td>邮箱 </td>
	                <td>
	                    <input type="text" name="user.mail" class="span4" value="<%=user.getMail() %>" />
	                </td>
				</tr>
				<tr class="conheight">
	                <td>电话号码</td>
	                <td>
	                    <input type="text" name="user.phonenum" class="span4" value="<%=user.getPhonenum() %>" />
	                </td>
				</tr>
				<tr class="conheight">
	                <td>状态</td>
	                <td>
		                <select class="span4" name="user.state" value="<%=user.getState() %>">
		                    <option value="0" <%if(user.getState().equals("0")){%>selected="selected"<%}%>>正常</option>
		                    <option value="1" <%if(user.getState().equals("1")){%>selected="selected"<%}%>>已删除</option>
		                </select>
	                </td>
	            </tr>
				<tr class="conheight">
	                <td>创建时间</td>
	                <td>
	                    <input type="text" name="user.createdate" class="span4" readonly value="<%=user.getCreatedate() %>" />
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
