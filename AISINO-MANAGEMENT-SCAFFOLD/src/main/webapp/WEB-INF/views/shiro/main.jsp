<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("page", request.getContextPath());
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>AISINO-管理平台 | 主页面</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<%@include file="../globalStyles.jsp" %>

	<!-- END GLOBAL MANDATORY STYLES -->

	<!-- BEGIN PAGE LEVEL STYLES --> 
	
	<link href="${page }/static/metronic.bootstrap/media/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>

	<!-- END PAGE LEVEL STYLES -->

</head>
<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed">

	<!-- BEGIN HEADER -->

	<div class="header navbar navbar-inverse navbar-fixed-top">

		<!-- BEGIN TOP NAVIGATION BAR -->

		<div class="navbar-inner">

			<div class="container-fluid">

				<!-- BEGIN LOGO -->

				<a class="brand" href="http://www.aisino.com/">
					<img alt="Brand" src="${page }/static/pic/header.png" title="http://www.aisino.com/" class="img-responsive">
				</a>

				<!-- END LOGO -->

				<!-- BEGIN RESPONSIVE MENU TOGGLER -->

				<a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">

				<img src="${page }/static/metronic.bootstrap/media/image/menu-toggler.png" alt="" />

				</a>          

				<!-- END RESPONSIVE MENU TOGGLER -->            

				<!-- BEGIN TOP NAVIGATION MENU -->              

				<ul class="nav pull-right">

					<!-- BEGIN NOTIFICATION DROPDOWN -->   
					
					<li class="dropdown" id="header_notification_bar">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="icon-bell"></i>
						<span class="badge">4</span>
						</a>
						<ul class="dropdown-menu extended notification">
							<li><p>您有4个新提醒</p></li>
							<li>
								<a href="#">
								<span class="label label-success"><i class="icon-plus"></i></span>
								New user registered. 
								<span class="time">Just now</span>
								</a>
							</li>

							<li>
								<a href="#">
								<span class="label label-important"><i class="icon-bolt"></i></span>
								Server #12 overloaded. 
								<span class="time">15 mins</span>
								</a>
							</li>

							<li>
								<a href="#">
								<span class="label label-warning"><i class="icon-bell"></i></span>
								Server #2 not respoding.
								<span class="time">22 mins</span>
								</a>
							</li>

							<li>
								<a href="#">
								<span class="label label-info"><i class="icon-bullhorn"></i></span>
								Application error.
								<span class="time">40 mins</span>
								</a>
							</li>

							<li class="external">
								<a href="#">查看所有提醒<i class="m-icon-swapright"></i></a>
							</li>

						</ul>

					</li>

					<!-- END NOTIFICATION DROPDOWN -->

					<!-- BEGIN INBOX DROPDOWN -->

					<li class="dropdown" id="header_inbox_bar">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="icon-envelope"></i>
						<span class="badge">1</span>
						</a>
						<ul class="dropdown-menu extended inbox">
							<li>
								<p>您有1条新信息</p>
							</li>
							
							<li>
								<a href="inbox.html?a=view">
								<span class="photo"><img src="${page }/static/metronic.bootstrap/media/image/avatar2.jpg" alt="" /></span>
								<span class="subject">
								<span class="from">Lisa Wong</span>
								<span class="time">Just Now</span>
								</span>
								<span class="message">
								Vivamus sed auctor nibh congue nibh. auctor nibh...
								</span>  
								</a>
							</li>

							<li class="external">
								<a href="inbox.html">See all messages <i class="m-icon-swapright"></i></a>
							</li>

						</ul>

					</li>

					<!-- END INBOX DROPDOWN -->

					<!-- BEGIN TODO DROPDOWN -->

					<li class="dropdown" id="header_task_bar">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="icon-tasks"></i>
						<span class="badge">4</span>
						</a>
						<ul class="dropdown-menu extended tasks">
							<li>
								<p>您有4个待完成任务</p>
							</li>
							
							<li>
								<a href="#">
								<span class="task">
								<span class="desc">New release v1.2</span>
								<span class="percent">30%</span>
								</span>
								<span class="progress progress-success">
								<span style="width: 30%;" class="bar"></span>
								</span>
								</a>
							</li>

							<li>
								<a href="#">
								<span class="task">
								<span class="desc">Application deployment</span>
								<span class="percent">65%</span>
								</span>
								<span class="progress progress-danger progress-striped active">
								<span style="width: 65%;" class="bar"></span>
								</span>
								</a>
							</li>

							<li>
								<a href="#">
								<span class="task">
								<span class="desc">Mobile app release</span>
								<span class="percent">98%</span>
								</span>
								<span class="progress progress-warning progress-striped">
								<span style="width: 98%;" class="bar"></span>
								</span>
								</a>
							</li>

							<li>
								<a href="#">
								<span class="task">
								<span class="desc">Web server upgrade</span>
								<span class="percent">58%</span>
								</span>
								<span class="progress progress-info">
								<span style="width: 58%;" class="bar"></span>
								</span>
								</a>
							</li>

							<li class="external">
								<a href="#">See all tasks <i class="m-icon-swapright"></i></a>
							</li>

						</ul>

					</li>

					<!-- END TODO DROPDOWN -->

					<!-- BEGIN USER LOGIN DROPDOWN -->

					<li class="dropdown user">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<img alt="" src="${page }/static/metronic.bootstrap/media/image/avatar1_small.jpg" />
						<span class="username"> <shiro:principal/></span>
						<i class="icon-angle-down"></i>
						</a>

						<ul class="dropdown-menu">
							<li><a href="extra_profile.html"><i class="icon-user"></i> 个人信息</a></li>
							<li><a href="page_calendar.html"><i class="icon-calendar"></i> 我的日程</a></li>
							<li><a href="inbox.html"><i class="icon-envelope"></i> 我的邮件(3)</a></li>
							<li><a href="#"><i class="icon-tasks"></i> 我的任务</a></li>
							<li class="divider"></li>
							<li><a href="${page }/shiro/lock" id="lock_page"><i class="icon-lock"></i> 屏幕锁定</a></li>
							<li><a href="${page }/shiro/logout"><i class="icon-key"></i> 注销</a></li>
						</ul>
					</li>

					<!-- END USER LOGIN DROPDOWN -->

				</ul>

				<!-- END TOP NAVIGATION MENU --> 
			</div>
		</div>

		<!-- END TOP NAVIGATION BAR -->
	</div>

	<!-- END HEADER -->

	<!-- BEGIN CONTAINER -->

	<div class="page-container">

		<!-- BEGIN SIDEBAR -->

		<div class="page-sidebar nav-collapse collapse">

			<!-- BEGIN SIDEBAR MENU -->        

			<ul class="page-sidebar-menu">
				<li>
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
					<div class="sidebar-toggler hidden-phone"></div>
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
				</li>

				<li>
					<!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
					<form class="sidebar-search">
						<div class="input-box">
							<a href="javascript:;" class="remove"></a>
							<input type="text" placeholder="Search..." />
							<input type="button" class="submit" value=" " />
						</div>
					</form>
					<!-- END RESPONSIVE QUICK SEARCH FORM -->
				</li>

				<li class="start active oneLevel">
					<a href="${page }/shiro/mainPage">
					<i class="icon-home"></i> 
					<span class="title">首页</span>
					<span class="selected"></span>
					</a>
				</li>

				<li class="oneLevel">
					<a>
					<i class="icon-folder-open"></i> 
					<span class="title">四级菜单</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li>
							<a href="javascript:;">
							<i class="icon-cogs"></i> 
							Item 1
							<span class="arrow"></span>
							</a>
							<ul class="sub-menu">
								<li>
									<a href="javascript:;">
									<i class="icon-user"></i>
									Sample Link 1
									<span class="arrow"></span>
									</a>
									<ul class="sub-menu">
										<li><a href="#"><i class="icon-remove"></i> Sample Link 1</a></li>
										<li><a href="#"><i class="icon-pencil"></i> Sample Link 1</a></li>
										<li><a href="#"><i class="icon-edit"></i> Sample Link 1</a></li>
									</ul>
								</li>
								<li><a href="#"><i class="icon-user"></i>  Sample Link 1</a></li>
								<li><a href="#"><i class="icon-external-link"></i>  Sample Link 2</a></li>
								<li><a href="#"><i class="icon-bell"></i>  Sample Link 3</a></li>
							</ul>
						</li>
						<li>
							<a href="javascript:;">
							<i class="icon-globe"></i> 
							Item 2
							<span class="arrow"></span>
							</a>
							<ul class="sub-menu">
								<li><a href="#"><i class="icon-user"></i>  Sample Link 1</a></li>
								<li><a href="#"><i class="icon-external-link"></i>  Sample Link 1</a></li>
								<li><a href="#"><i class="icon-bell"></i>  Sample Link 1</a></li>
							</ul>
						</li>
						<li>
							<a href="#">
							<i class="icon-folder-open"></i>
							Item 3
							</a>
						</li>
					</ul>
				</li>
				<shiro:hasPermission name="table4:show">
				<li class="last oneLevel" id="test">
					<a href="${page }/shiro/test">
					<i class="icon-bar-chart"></i> 
					<span class="title">直接点击进入</span>
					</a>
				</li>
				</shiro:hasPermission>
			</ul>

			<!-- END SIDEBAR MENU -->

		</div>

		<!-- END SIDEBAR -->

		<!-- BEGIN PAGE -->

		<div class="page-content">

			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<div id="portlet-config" class="modal hide">
				<div class="modal-header">
					<button data-dismiss="modal" class="close" type="button"></button>
					<h3>Widget Settings</h3>
				</div>
				<div class="modal-body">
					Widget settings form goes here
				</div>
			</div>

			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<!-- BEGIN PAGE CONTAINER-->

			<div class="container-fluid">

				<!-- BEGIN PAGE HEADER-->

				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN STYLE CUSTOMIZER -->
						<div class="color-panel hidden-phone">
							<div class="color-mode-icons icon-color"></div>
							<div class="color-mode-icons icon-color-close"></div>
							<div class="color-mode">
								<p>系统主题颜色</p>
								<ul class="inline">
									<li class="color-black current color-default" data-style="default"></li>
									<li class="color-blue" data-style="blue"></li>
									<li class="color-brown" data-style="brown"></li>
									<li class="color-purple" data-style="purple"></li>
									<li class="color-grey" data-style="grey"></li>
									<li class="color-white color-light" data-style="light"></li>
								</ul>
								<label>
									<span>布局</span>
									<select class="layout-option m-wrap small">
										<option value="fluid" selected>填充全屏</option>
										<option value="boxed">窗口</option>
									</select>
								</label>
								<label>
									<span>系统头部</span>
									<select class="header-option m-wrap small">
										<option value="fixed" selected>固定</option>
										<option value="default">不固定</option>
									</select>
								</label>
								<label>
									<span>左侧边栏</span>
									<select class="sidebar-option m-wrap small">
										<option value="fixed">固定</option>
										<option value="default" selected>不固定</option>
									</select>
								</label>
								<label>
									<span>系统底部</span>
									<select class="footer-option m-wrap small">
										<option value="fixed">固定</option>
										<option value="default" selected>不固定</option>
									</select>
								</label>
							</div>

						</div>

						<!-- END BEGIN STYLE CUSTOMIZER -->    

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">
							首页 <small>一览展示</small>
						</h3>
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="${page }/shiro/main">Home</a> 
								<i class="icon-angle-right"></i>
							</li>
							<li><a href="${page }/shiro/main">首页</a></li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>

				<!-- END PAGE HEADER-->

				<div id="dashboard">

					<!-- BEGIN DASHBOARD STATS -->

					<div class="row-fluid">

						<div class="span3 responsive" data-tablet="span6" data-desktop="span3">

							<div class="dashboard-stat blue">

								<div class="visual">

									<i class="icon-comments"></i>

								</div>

								<div class="details">

									<div class="number">

										1349

									</div>

									<div class="desc">                           

										New Feedbacks

									</div>

								</div>

								<a class="more" href="#">

								View more <i class="m-icon-swapright m-icon-white"></i>

								</a>                 

							</div>

						</div>

						<div class="span3 responsive" data-tablet="span6" data-desktop="span3">

							<div class="dashboard-stat green">

								<div class="visual">

									<i class="icon-shopping-cart"></i>

								</div>

								<div class="details">

									<div class="number">549</div>

									<div class="desc">New Orders</div>

								</div>

								<a class="more" href="#">

								View more <i class="m-icon-swapright m-icon-white"></i>

								</a>                 

							</div>

						</div>

						<div class="span3 responsive" data-tablet="span6  fix-offset" data-desktop="span3">

							<div class="dashboard-stat purple">

								<div class="visual">

									<i class="icon-globe"></i>

								</div>

								<div class="details">

									<div class="number">+89%</div>

									<div class="desc">Brand Popularity</div>

								</div>

								<a class="more" href="#">

								View more <i class="m-icon-swapright m-icon-white"></i>

								</a>                 

							</div>

						</div>

						<div class="span3 responsive" data-tablet="span6" data-desktop="span3">

							<div class="dashboard-stat yellow">

								<div class="visual">

									<i class="icon-bar-chart"></i>

								</div>

								<div class="details">

									<div class="number">12,5M$</div>

									<div class="desc">Total Profit</div>

								</div>

								<a class="more" href="#">

								View more <i class="m-icon-swapright m-icon-white"></i>

								</a>                 

							</div>

						</div>

					</div>

					<!-- END DASHBOARD STATS -->

					<div class="clearfix"></div>

					<div class="row-fluid">

						<div class="span6">

							<!-- BEGIN PORTLET-->

							<div class="portlet solid bordered light-grey">

								<div class="portlet-title">

									<div class="caption"><i class="icon-bar-chart"></i>Site Visits</div>

									<div class="tools">

										<div class="btn-group pull-right" data-toggle="buttons-radio">

											<a href="" class="btn mini">Users</a>

											<a href="" class="btn mini active">Feedbacks</a>

										</div>

									</div>

								</div>

								<div class="portlet-body">

									<div id="site_statistics_loading">

										<img src="${page }/static/metronic.bootstrap/media/image/loading.gif" alt="loading" />

									</div>

									<div id="site_statistics_content" class="hide">

										<div id="site_statistics" class="chart"></div>

									</div>

								</div>

							</div>

							<!-- END PORTLET-->

						</div>

						<div class="span6">

							<!-- BEGIN PORTLET-->

							<div class="portlet solid light-grey bordered">

								<div class="portlet-title">

									<div class="caption"><i class="icon-bullhorn"></i>Activities</div>

									<div class="tools">

										<div class="btn-group pull-right" data-toggle="buttons-radio">

											<a href="" class="btn blue mini active">Users</a>

											<a href="" class="btn blue mini">Orders</a>

										</div>

									</div>

								</div>

								<div class="portlet-body">

									<div id="site_activities_loading">

										<img src="${page }/static/metronic.bootstrap/media/image/loading.gif" alt="loading" />

									</div>

									<div id="site_activities_content" class="hide">

										<div id="site_activities" style="height:100px;"></div>

									</div>

								</div>

							</div>

							<!-- END PORTLET-->

							<!-- BEGIN PORTLET-->

							<div class="portlet solid bordered light-grey">

								<div class="portlet-title">

									<div class="caption"><i class="icon-signal"></i>Server Load</div>

									<div class="tools">

										<div class="btn-group pull-right" data-toggle="buttons-radio">

											<a href="" class="btn red mini active">

											<span class="hidden-phone">Database</span>

											<span class="visible-phone">DB</span></a>

											<a href="" class="btn red mini">Web</a>

										</div>

									</div>

								</div>

								<div class="portlet-body">

									<div id="load_statistics_loading">

										<img src="${page }/static/metronic.bootstrap/media/image/loading.gif" alt="loading" />

									</div>

									<div id="load_statistics_content" class="hide">

										<div id="load_statistics" style="height:108px;"></div>

									</div>

								</div>

							</div>

							<!-- END PORTLET-->

						</div>

					</div>

					<div class="clearfix"></div>

				</div>

			</div>

			<!-- END PAGE CONTAINER-->    

		</div>

		<!-- END PAGE -->

	</div>

	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	<div class="footer">

		<div class="footer-inner">
			2017 &copy; 辽宁航天信息有限公司 by zhukaisheng.
		</div>

		<div class="footer-tools">
			<span class="go-top">
			<i class="icon-angle-up"></i>
			</span>
		</div>

	</div>

	<!-- END FOOTER -->

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN CORE PLUGINS -->

	<%@include file="../globalScripts.jsp" %>

	<!-- END CORE PLUGINS -->


	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="${page }/static/js/app.js" type="text/javascript"></script>

	<script src="${page }/static/js/index.js" type="text/javascript"></script>        

	<!-- END PAGE LEVEL SCRIPTS -->  

	<script>

		jQuery(document).ready(function() {    

		   App.init(); // initlayout and core plugins

		   Index.init();

		  /*  Index.initJQVMAP(); // init index page's custom scripts

		   Index.initCalendar(); // init index page's custom scripts

		   Index.initCharts(); // init index page's custom scripts

		   Index.initChat();

		   Index.initMiniCharts(); 

		   Index.initDashboardDaterange();

		   Index.initIntro(); */
		   
		   //锁定页
		   $("#lock_page").click(function(){
		   location.replace(this.href);
		   	return false;
		   });

		});

	</script>

	<!-- END JAVASCRIPTS -->

<script type="text/javascript">  var _gaq = _gaq || [];  _gaq.push(['_setAccount', 'UA-37564768-1']);  _gaq.push(['_setDomainName', 'keenthemes.com']);  _gaq.push(['_setAllowLinker', true]);  _gaq.push(['_trackPageview']);  (function() {    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;    ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);  })();</script></body>

<!-- END BODY -->

</html>