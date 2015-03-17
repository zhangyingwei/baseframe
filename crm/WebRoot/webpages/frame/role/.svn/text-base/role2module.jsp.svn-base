<%@ page language="java" import="java.util.*,com.fc.framework.web.entity.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Map map = (Map)request.getAttribute("map");
Role role = (Role)map.get("role");
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
    <script type="text/javascript">
    	function addmodule(roleid,moduleid){
    		myajax('addmodule2role.do?roleModule.roleid='+roleid+'&roleModule.moduleid='+moduleid,moduleid,roleid);
        }
        function delmodule(roleid,moduleid){
			myajax('delmodule2role.do?roleModule.roleid='+roleid+'&roleModule.moduleid='+moduleid,moduleid,roleid);
        }
        function myajax(myurl,moduleid,roleid){
            var addstr = '<input class="btn btn-primary" id="addbut'+moduleid+'" type="button" onclick="addmodule('+roleid+','+moduleid+')" value="添加" />';
            var delstr = '<input class="btn btn-primary" id="delbut'+moduleid+'" type="button" onclick="delmodule('+roleid+','+moduleid+')" value="取消" />';
			$.ajax({
					type:'POST',
					url:myurl,
					cache:false,
					success:function(data){
							if(data==0){
								$('#delbut'+moduleid).remove();
								$('#td'+moduleid).append(addstr);
							}else{
								$('#addbut'+moduleid).remove();
								$('#td'+moduleid).append(delstr);
							}
						},
					error:function(){
							alert('error');
						}
				});
        }
    </script>
</head>
<body>
	<form method="post" action="adduserrole.do">
	    <table class="table table-striped table-bordered table-condensed" id="top">
        <thead>
        	<tr class="even">
        		<td class="auto-style1" colspan="4">角色编号: &nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="roleid" name="roleModule.roleid" class="span3" readonly value="<%=role.getRoleid() %>" /></td>
        	</tr>
            <tr class="tr_detail">
                <td class="auto-style1">模块编号</td>
                <td class="auto-style1">模块名称</td>
                <td class="auto-style1">操作</td>
            </tr>
        </thead>
        <tbody>
        	<%
        		List<RoleModule> mymodules = (List<RoleModule>)map.get("mymodules");
        		List<Module> modules = (List<Module>)map.get("modules");
        		for(Module m:modules){
        			%>
		            <tr class="even">
		                <td class="span2"><%=m.getModuleid() %></td>
		                <td><%=m.getModulename() %></td>
		                <td class="span2" id="td<%=m.getModuleid() %>">
		                <%
		                	if(mymodules.size() == 0){
			                		%>
					                    <input class="btn btn-primary" id="addbut<%=m.getModuleid() %>" type="button" onclick="addmodule(<%=role.getRoleid() %>,'<%=m.getModuleid() %>')" value="添加" />
			                		<%
		                	}else{
				        		boolean flag = false;
			                	for(RoleModule m2:mymodules){
			                		if(m.getModuleid().toString().equals(m2.getModuleid().toString())){
			                			flag = true;
			                		}
			                	}
			                	if(flag){
			                		%>
					                    <input class="btn btn-primary" id="delbut<%=m.getModuleid() %>" type="button" onclick="delmodule(<%=role.getRoleid() %>,<%=m.getModuleid() %>)" value="取消" />
			                		<%
			                	}else{
			                		%>
			                			<input class="btn btn-primary" id="addbut<%=m.getModuleid() %>" type="button" onclick="addmodule(<%=role.getRoleid() %>,<%=m.getModuleid() %>)" value="添加" />
			                		<%
			                	}
		                	}
		                %>
		                </td>
		            </tr>
        			<%
        		}
        	%>
        </tbody>
    </table>
    </form>
</body>
</html>
