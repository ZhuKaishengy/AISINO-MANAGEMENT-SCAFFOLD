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
<title>AISINO-管理平台 | 屏幕锁定</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<%@include file="../globalStyles.jsp" %>

	<!-- END GLOBAL MANDATORY STYLES -->

	<!-- BEGIN PAGE LEVEL STYLES --> 
	
	<link href="${page }/static/metronic.bootstrap/media/css/lock.css" rel="stylesheet" type="text/css"/>
	<!-- END PAGE LEVEL STYLES -->

</head>
<body>

	<div class="page-lock">

		<div class="page-logo">

			<a class="brand" href="http://www.aisino.com/">
				<img alt="Brand" src="${page }/static/pic/header.png" title="http://www.aisino.com/" class="img-responsive">
			</a>

		</div>

		<div class="page-body">

			<img class="page-lock-img" src="${page }/static/metronic.bootstrap/media/image/profile.jpg" alt="">

			<div class="page-lock-info">

				<h1 id="userPrincipal" ><shiro:principal/></h1>

				<span><em>Locked</em></span>

				<form class="form-search" action="shiro/main" id="lock_form" >

					<div class="control-group">
						<div class="input-append">
	
							<input type="text" class="m-wrap" placeholder="Password" id="userCreditials" name="userCreditials" >
	
							<button type="submit" class="btn blue icn-only" id="lock_submit" ><i class="m-icon-swapright m-icon-white"></i></button>
	
						</div>
					</div>
			
					<div class="relogin">

						<a href="${page }/shiro/logout">切换账号登陆 ?</a>

					</div>

				</form>

			</div>

		</div>

		<div class="page-footer">

			2017 © 辽宁航天信息有限公司. 企业管理平台. 

		</div>

	</div>

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN CORE PLUGINS -->

	<%@include file="../globalScripts.jsp" %>
	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script src="${page }/static/metronic.bootstrap/media/js/jquery.backstretch.min.js" type="text/javascript"></script>

	<!-- END PAGE LEVEL PLUGINS -->   

	<script src="${page }/static/js/app.js"></script>  

	<script src="${page }/static/js/lockSceen.js"></script>      

	<script>

		jQuery(document).ready(function() {    

		   App.init();

		   Lock.init();

		});

	</script>

	<!-- END JAVASCRIPTS -->

<script type="text/javascript">  var _gaq = _gaq || [];  _gaq.push(['_setAccount', 'UA-37564768-1']);  _gaq.push(['_setDomainName', 'keenthemes.com']);  _gaq.push(['_setAllowLinker', true]);  _gaq.push(['_trackPageview']);  (function() {    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;    ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);  })();</script></body>

<!-- END BODY -->

</html>