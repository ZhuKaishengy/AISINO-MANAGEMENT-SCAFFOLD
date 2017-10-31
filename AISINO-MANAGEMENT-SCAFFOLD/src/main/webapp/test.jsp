<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("page",path);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${page }/static/metronic.bootstrap/media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
<%-- <script src="${page }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
<link href="${page}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" /> --%>
<script src="${page }/static/metronic/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<link href="${page }/static/metronic/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="${page }/static/metronic/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="${page}/static/bootstrap-table-develop/dist/bootstrap-table.min.css" rel="stylesheet" />
<script src="${page}/static/bootstrap-table-develop/dist/bootstrap-table.min.js"></script>
<script src="${page}/static/bootstrap-table-develop/dist/locale/bootstrap-table-zh-CN.min.js"></script>
<link href="${page}/static/bootstrap3-editable-1.5.1/bootstrap3-editable/css/bootstrap-editable.css" rel="stylesheet" />
<script src="${page}/static/bootstrap-table-develop/dist/extensions/editable/bootstrap-table-editable.min.js"></script>
<script src="${page}/static/bootstrap3-editable-1.5.1/bootstrap3-editable/js/bootstrap-editable.min.js"></script>
</head>
<body>
	<div id="content">
		<script type="text/javascript">
			$(function(){
				alert("abc");
				/* $("#click").click(function(){
					$(this).ajaxify();
				}) */
			})
			
		</script>
		<a href="test.jsp" target="#wrapper" id="click">click</a>
			<div id="wrapper" ></div>
			<p>=================================</p>
			hello+<shiro:principal/>
			<shiro:hasRole name="admin">
			<h4>if you have admin role ,you can see it</h4>
			</shiro:hasRole>
			<h3>test page</h3>
			<spring:message code="i18n.test"/>
			<a href="<%=basePath %>shiro/logout">logout</a>
			
			<p>=================================</p>
			<button class="btn btn-default" type="button" title="test">
			<i class="glyphicon glyphicon-refresh icon-refresh"></i>
			</button>
			<button class="btn btn-default dropdown-toggle" type="button" title="test_dropdown">
			<i class="glyphicon glyphicon-th icon-th"></i>
			<span class="caret"></span>
			</button>
			<p>=================================</p>
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
				//MenuManage.initTable();
				//初始化bootstrap表格
				$("#table_remote").bootstrapTable({
				 	url: '${page}/shiro/menuList',		//请求后台的URL（*）
		            method: 'get',                      //请求方式（*）
		            toolbar: '#toolbar',                //工具按钮用哪个容器
		            striped: true,                      //是否显示行间隔色
		            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		            pagination: true,                   //是否显示分页（*）
		            sortable: true,                    //是否启用排序
		            sortOrder: "asc",                   //排序方式
		           /* queryParams: initQueryParams,		//传递参数（*）
		            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
		            pageNumber:1,                       //初始化加载第一页，默认第一页
		            pageSize: 10,                       //每页的记录行数（*）
		            pageList: [10, 25, 50, 100 ,ALL],  */      //可供选择的每页的行数（*）
		            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
		            strictSearch: true,
		            showColumns: true,                  //是否显示所有的列
		            showRefresh: true,                  //是否显示刷新按钮
		            minimumCountColumns: 2,             //最少允许的列数
		            clickToSelect: true,                //是否启用点击选中行
		            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		            uniqueId: "menuId",                     //每一行的唯一标识，一般为主键列
		            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
		            cardView: false,                    //是否显示详细视图
		            detailView: false,                  //是否显示父子表
		            rowStyle: function (row, index) {
		                //这里有5个取值代表5中颜色['active', 'success', 'info', 'warning', 'danger'];
		                var strclass = "";
		                if (row.status == 0) {
		                    strclass = 'danger';//还有一个active
		                }
		                else {
		                    return {};
		                }
		                return { classes: strclass }
		            },
					columns: [{
		                checkbox: true
		            }, {
		            	field: '',
	                    title: '序号',
	                    align : 'center',
			            valign : 'middle',
	                    formatter: function (value, row, index) {
	                    	return index+1;
	                   	}
		            }, {
				        field: 'menuId',
				        title: '菜单id',
				        align : 'center',
			            valign : 'middle'
				    }, {
				        field: 'menuUpid',
				        title: '上级菜单id',
				        editable:true,
				        align : 'center',
			            valign : 'middle'
				    }, {
				        field: 'iconClass',
				        title: '图标样式',
				        editable:true,
				        align : 'center',
			            valign : 'middle'
				    }, {
				        field: 'title',
				        title: '菜单名称',
				        editable:true,
				        align : 'center',
			            valign : 'middle'
				    }, {
				        field: 'haschild',
				        title: '是否有子节点',
				        editable:true,
				        align : 'center',
			            valign : 'middle',
			            sortable : true,
			            formatter : function (value, row, index){
			                return value == 1 ? "有":"没有";
			            }
				    }, {
				        field: 'href',
				        title: '链接地址',
				        editable:true,
				        align : 'center',
			            valign : 'middle'
				    }, {
				        field: 'roleNeeded',
				        title: '显示所需权限',
				        editable:true,
				        align : 'center',
			            valign : 'middle'
				    }, {
				        field: 'status',
				        title: '菜单状态',
				        align : 'center',
			            valign : 'middle',
			            sortable : true,
			            formatter : function (value, row, index){
			                return value == 1 ? "<i class='icon-ok-sign'></i>":"<i class='icon-ban-circle'></i>";
			            },
			            cellStyle : function(value, row, index){
			            	if(value == 1){
			            		return {
									css: {"color": "green"}
								}
			            	}
			            	return {
			            		css: {"color": "red"}
			            	}
			            
			            }
				    }]
				
				});
				
				//得到查询的参数
			    var initQueryParams = function (params) {
			        var temp = {   //这里的键的名字和控制器的变量名必须一致，这边改动，控制器也需要改成一样的
			            pageSize: params.pageSize,   //页面大小
			            pageNum: params.pageNum //页码
			        };
			        return temp;
			    };
			    
			    //按钮添加事件
		    	$("#btn_add").click(function(){
		    		alert("add..");
		    	});
		    	$("#btn_edit").click(function(){
		    		alert("edit..");
		    	});
		    	$("#btn_delete").click(function(){
		    		alert("delete..");
		    	});
		    	
				
	    	})
	    </script>
			
	</div>
</body>
</html>