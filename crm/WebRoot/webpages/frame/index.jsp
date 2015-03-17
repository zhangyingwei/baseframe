<%@ page language="java" import="java.util.*,com.fc.framework.web.entity.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
User user = (User)request.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>豪洋公司客户关系管理系统</title>
    <link rel="stylesheet" type="text/css" href="Styles/admin-all.css" />
    <link rel="stylesheet" type="text/css" href="Styles/base.css" />
    <link rel="stylesheet" type="text/css" href="Styles/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
    <script type="text/javascript" src="Scripts/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="Scripts/jquery-ui-1.8.22.custom.min.js"></script>
    <script type="text/javascript" src="Scripts/index.js"></script>
</head>
<body>
    <div class="warp">
        <!--头部开始-->
        <div class="top_c">
            <div class="top-nav">欢迎您，<%=user.getRealname() %>！&nbsp;&nbsp;<a href="#">修改密码</a> | <a href="<%=path %>">安全退出</a></div>
        </div>
        <!--头部结束-->
        <!--左边菜单开始-->
        <div class="left_c left">
            <h1>菜单</h1>
            <div class="acc">
            <%
            	List<Module> list = (List<Module>)request.getAttribute("modules");
            	for(Module m:list){
            		String moduleid = m.getModuleid().toString();
            		String fatherid = m.getFatherid();
            		String modulename = m.getModulename();
            		String modulepath = m.getModulepath();
            		if(fatherid.equals("0")){
            			%>
            				<div>
                    			<a class="one"><%=modulename %></a>
                    			<ul class="kid">
                    				<%
	                    				for(Module m2:list){
	                    					String moduleid2 = m2.getModuleid().toString();
	                                		String fatherid2 = m2.getFatherid();
	                                		String modulename2 = m2.getModulename();
	                                		String modulepath2 = m2.getModulepath();
	                                		if(fatherid2.equals(moduleid)){
	                                			%>
							                        <li><b class="tip"></b><a target="Conframe" href="<%=path+modulepath2 %>"><%=modulename2%></a></li>
	                                			<%
	                                		}
	                    				}
			                        %>
			                    </ul>
                    		</div>
            			<%
            		}
            	}
            %>
                <div id="datepicker"></div>
            </div>

        </div>
        <!--左边菜单结束-->
        <!--右边框架开始-->
        <div class="right_c">
            <div class="nav-tip" onclick="javascript:void(0)">&nbsp;</div>
        </div>
        <div class="Conframe">
            <iframe name="Conframe" id="Conframe"></iframe>
        </div>
        <!--右边框架结束-->

        <!--底部开始-->
        <div class="bottom_c">Copyright &copy;2015-2035 豪洋股份有限公司 版权所有</div>
        <!--底部结束-->
    </div>
</body>
</html>
