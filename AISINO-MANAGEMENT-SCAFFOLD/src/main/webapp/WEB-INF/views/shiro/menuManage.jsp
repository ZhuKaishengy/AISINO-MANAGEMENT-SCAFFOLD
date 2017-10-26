<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("page",path);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    	<base href="<%=basePath%>">
<script src="${page}/static/bootstrap-table-develop/dist/bootstrap-table.min.js"></script>
  </head>
  <body>
	  <div id="content" >
	    
	    <table id="table_remote"></table>
		
		  <script type="text/javascript">
	    	$(function(){
				
				$("#table_remote").bootstrapTable({
				 	url: '${page}/shiro/menuList',
					columns: [{
				        field: 'menuId',
				        title: '菜单id'
				    }, {
				        field: 'menuUpid',
				        title: '上级菜单id'
				    }, {
				        field: 'iconClass',
				        title: '菜单前的小图标'
				    }, {
				        field: 'title',
				        title: '菜单名称'
				    }, {
				        field: 'haschild',
				        title: '是否有子节点（1有，0没有）'
				    }, {
				        field: 'href',
				        title: '链接地址'
				    }, {
				        field: 'roleNeeded',
				        title: '显示所需权限'
				    }, {
				        field: 'status',
				        title: '菜单状态（1可用，0禁用）'
				    }]
				
				});
	    	})
	    </script>
	  </div>
  </body>
</html>
