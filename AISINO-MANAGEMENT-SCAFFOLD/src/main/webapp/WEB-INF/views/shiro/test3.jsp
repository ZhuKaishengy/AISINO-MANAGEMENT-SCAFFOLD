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
		<!-- 不用引用js库，js的引用都写在全局js文件中globalScripts.js --> 

  </head>
  <body>
	  <div id="content" >
	    
	   	<table data-toggle="table" id="table1">
		    <thead>
		        <tr>
		            <th>（jsp写死）Item ID</th>
		            <th>Item Name</th>
		            <th>Item Price</th>
		        </tr>
		    </thead>
		    <tbody>
		        <tr>
		            <td>1</td>
		            <td>Item 1</td>
		            <td>$1</td>
		        </tr>
		        <tr>
		            <td>2</td>
		            <td>Item 2</td>
		            <td>$2</td>
		        </tr>
		    </tbody>
		</table>
		
	    <table id="table_js"></table>
	    <table id="table_remote"></table>
		
		  <script type="text/javascript">
	    	$(function(){
	    	//注意：正常来说table1自动初始化，不需要这么手动初始化，但$.load()方法引用不加载样式，需要手动初始化
	    		$("#table1").bootstrapTable();
	    		
	    		$('#table_js').bootstrapTable({
				    columns: [{
				        field: 'id',
				        title: '（js初始化）Item ID'
				    }, {
				        field: 'name',
				        title: 'Item Name'
				    }, {
				        field: 'price',
				        title: 'Item Price'
				    }],
				    data: [{
				        id: 1,
				        name: 'Item 1',
				        price: '$1'
				    }, {
				        id: 2,
				        name: 'Item 2',
				        price: '$2'
				    }]
				});
				
				$("#table_remote").bootstrapTable({
				 	url: '${page}/shiro/menuList',
					columns: [{
				        field: 'menuId',
				        title: '（remote url）菜单id'
				    }, {
				        field: 'menuUpid',
				        title: '上级菜单id'
				    }, {
				        field: 'title',
				        title: '菜单名称'
				    }]
				
				});
	    	})
	    </script>
	  </div>
  </body>
</html>
