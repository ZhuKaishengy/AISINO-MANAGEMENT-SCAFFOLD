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
	    
	    <div class="panel-body" style="padding-bottom:0px;">
        <div class="panel panel-default">
            <div class="panel-heading">查询条件</div>
            <div class="panel-body">
                <form id="formSearch" class="form-horizontal">
                
                    <div class="form-group" style="margin-top:15px">
                        <label class="control-label col-md-1" for="search_menuId">菜单id</label>
                        <div class="col-md-3">
                            <input type="text" class="form-control" id="search_menuId">
                        </div>
                        <label class="control-label col-md-1" for="search_menuUpid">上级菜单id</label>
                        <div class="col-md-3">
                            <input type="text" class="form-control" id="search_menuUpid">
                        </div>
                        <label class="control-label col-md-1" for="search_iconClass">图标样式</label>
                        <div class="col-md-3">
                            <input type="text" class="form-control" id="search_iconClass">
                        </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                        <label class="control-label col-md-1" for="search_title">菜单名称</label>
                        <div class="col-md-3">
                            <input type="text" class="form-control" id="search_title">
                        </div>
                        <label class="control-label col-md-1" for="search_haschild">是否有子节点（1有，0没有）</label>
                        <div class="col-md-3">
                            <input type="text" class="form-control" id="search_haschild">
                        </div>
                        <label class="control-label col-md-1" for="search_href">链接地址</label>
                        <div class="col-md-3">
                            <input type="text" class="form-control" id="search_href">
                        </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                        <label class="control-label col-md-1" for="search_roleNeeded">显示所需权限</label>
                        <div class="col-md-3">
                            <input type="text" class="form-control" id="search_roleNeeded">
                        </div>
                        <label class="control-label col-md-1" for="search_status">菜单状态（1可用，0禁用）</label>
                        <div class="col-md-3">
                            <input type="text" class="form-control" id="search_status">
                        </div>
                        <div class="col-md-4" style="text-align:left;">
                            <button type="button"  id="btn_query" class="btn btn-primary">查询</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>       

        <div id="toolbar" class="btn-group">
            <button id="btn_add" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
            </button>
            <button id="btn_edit" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
            </button>
            <button id="btn_delete" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
            </button>
        </div>
        <table id="table_remote"></table>
    </div>
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
				        title: '图标样式'
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
