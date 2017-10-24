<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script src="${page }/static/metronic.bootstrap/media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
<script src="${page }/static/metronic.bootstrap/media/js/jquery.gritter.js" type="text/javascript"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	
	hello+<shiro:principal/>
	<shiro:hasRole name="admin">
	<h4>if you have admin role ,you can see it</h4>
	</shiro:hasRole>
	<h3>test page</h3>
	<spring:message code="i18n.test"/>
	<a href="<%=basePath %>shiro/logout">logout</a>
</body>
</html>