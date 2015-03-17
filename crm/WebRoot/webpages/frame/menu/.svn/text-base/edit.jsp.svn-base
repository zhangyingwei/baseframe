<%@ page language="java" import="java.util.*,com.fc.framework.web.entity.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Module module = (Module)request.getAttribute("module");
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
           if($('#modulename').val() == ''){
               return false;
           }
           return true;
       }
    </script>
</head>
<body>
	<form method="post" action="updatemodule.do" onsubmit="return cansub()">
	    <table class="table table-striped table-bordered table-condensed list">
	        <thead>
	            <tr class="conheight">
	                <td colspan="2">菜单添加<i class="tip-up"></i></td>
	            </tr>
	        </thead>
	        <tbody>
	       		<tr class="conheight">
	                <td class="span2">菜单编号 </td>
	                <td>
	                    <input type="text" id="moduleid" name="module.moduleid" class="span4" readonly value="<%=module.getModuleid() %>" />
	                </td>
	            </tr>
	            <tr class="conheight">
	                <td class="span2">菜单名称 </td>
	                <td>
	                    <input type="text" id="modulename" name="module.modulename" class="span4" value="<%=module.getModulename() %>" />
	                </td>
	            </tr>
	            <tr class="conheight">
	                <td>父菜单</td>
	                <td>
		                <select class="span4" name="module.fatherid" value="<%=module.getFatherid() %>">
		                    <option value="0">无父菜单</option>
		                	<%
		                	List<Module> modules = (List<Module>)request.getSession().getAttribute("modules");
		            		for(Module m:modules){
		            			String moduleid = m.getModuleid().toString();
		            			String modulename = m.getModulename();
		            			String fatherid = m.getFatherid();
		            			if(fatherid.equals("0")){
		            				%>
					                    <option value="<%=moduleid %>"><%=modulename %></option>
		            				<%
		            			}
		            		}
		                	%>
		                </select>
	                </td>
	            </tr>
				<tr class="conheight">
	                <td>菜单路径 </td>
	                <td>
	                    <input type="text" name="module.modulepath" class="span4" value="<%=module.getModulepath() %>" />
	                </td>
				</tr>
				<tr class="conheight">
	                <td>创建人 编号</td>
	                <td>
	                    <input type="text" name="module.createuser" class="span4" readonly value="<%=module.getCreateuser() %>" />
	                </td>
				</tr>
				<tr class="conheight">
	                <td>创建时间 </td>
	                <td>
	                    <input type="text" name="module.createdate" class="span4" readonly value="<%=module.getCreatedate() %>" />
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
