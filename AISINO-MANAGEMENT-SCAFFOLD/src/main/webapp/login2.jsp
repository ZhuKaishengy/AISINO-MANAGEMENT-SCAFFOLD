<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("page", request.getContextPath());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>AISINO-管理平台 | 登陆页面</title>
	
	<meta content="" name="description" />

	<meta content="" name="author" />
	
	<!-- 全局导入的css，js -->
	<%@include file="WEB-INF/views/globalStyles.jsp" %>
	
	<!-- BEGIN PAGE LEVEL STYLES -->

	<link href="${page }/static/metronic.bootstrap/media/css/login.css" rel="stylesheet" type="text/css"/>

	<!-- END PAGE LEVEL STYLES -->
	
  </head>
  
  <body class="login">
  <!-- BEGIN LOGO -->
	<div class="logo">
		<img src="${page }/static/pic/header.png" alt="" /> 
	</div>
	<!-- END LOGO -->

	<!-- BEGIN LOGIN -->
	
	<!-- BEGIN LOGIN -->

	<div class="content">

		<!-- BEGIN LOGIN FORM -->

		<form class="form-vertical login-form" action="${page }/shiro/login">

			<h3 class="form-title">登陆</h3>
		<!-- 提示框 -->
			<div class="alert alert-error hide" id="login-form-alert" >

				<button class="close" data-dismiss="alert"></button>

				<span>用户名、密码不正确，请重新输入！</span>

			</div>
			<div class="control-group">

				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->

				<label class="control-label visible-ie8 visible-ie9">用户名</label>

				<div class="controls">

					<div class="input-icon left">

						<i class="icon-user"></i>
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="用户名" name="userPrincipal" id="userPrincipal" />
					</div>

				</div>

			</div>

			<div class="control-group">

				<label class="control-label visible-ie8 visible-ie9">密码</label>

				<div class="controls">

					<div class="input-icon left">

						<i class="icon-lock"></i>
						<input class="m-wrap placeholder-no-fix" type="password" placeholder="密码" name="userCreditials" id="userCreditials" />
					</div>

				</div>

			</div>

			<div class="form-actions">

				<label class="checkbox">

				<input type="checkbox" name="remember" value="1"/> 记住我

				</label>

				<button type="submit" class="btn green pull-right" id="login-form_submit_btn" >

				登陆 <i class="m-icon-swapright m-icon-white"></i>

				</button>            

			</div>
	<!-- 重置密码功能 -->
			<div class="forget-password">

				<h4>忘记密码了？</h4>
				<p>
					点击 <a href="javascript:;" class="" id="forget-password">这里</a>
					来重置密码
				</p>

			</div>

		</form>

		<!-- END LOGIN FORM -->        

		<!-- BEGIN FORGOT PASSWORD FORM -->

		<form class="form-vertical forget-form" action="index.html">

			<h3 class="">忘记密码了？</h3>

			<p>使用手机号重置密码</p>
			
		<!-- 提示框 -->
			<div class="alert alert-error hide" id="forget-form-alert" >
				<button class="close" data-dismiss="alert"></button>
				<span></span>
			</div>
		<!-- control group  -->
			<div class="control-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9">手机号</label>

				<div class="controls">

					<div class="input-icon left">
						<i class="icon-mobile-phone"></i>
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="手机号" name="userPhone" id="userPhone" />
					</div>

				</div>

			</div>
			
		<!-- control group  -->
			<div class="control-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9">验证码</label>

				<div class="controls">

					<div class="input-icon left">
						<i class="icon-barcode"></i>
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="验证码" name="identitiCode" id="identitiCode" />
					</div>
					

				</div>
			  	<button type="button" id="sendIdentitiCode" class="btn pull-right">
					<i class=""></i>
					 发送验证码
			  	</button>
			</div>
			
			

			<div class="form-actions">

				<button type="button" id="back-btn" class="btn">

				<i class="m-icon-swapleft"></i> 返回

				</button>

				<button type="submit" class="btn green pull-right" id="forget-form_submit_btn" >

				确定 <i class="m-icon-swapright m-icon-white"></i>

				</button>            

			</div>

		</form>

		<!-- END FORGOT PASSWORD FORM -->

	</div>

	<!-- END LOGIN -->
  	<!-- BEGIN COPYRIGHT -->

	<div class="copyright">
		2017 &copy; 辽宁航天信息有限公司. 企业管理平台.
	</div>
	<!-- END COPYRIGHT -->

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN CORE PLUGINS -->

	<%@include file="WEB-INF/views/globalScripts.jsp" %>

	<!-- BEGIN PAGE LEVEL PLUGINS -->
	
	<script src="${page }/static/metronic.bootstrap/media/js/app.js" type="text/javascript"></script>

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->


	<!-- 用于登陆js -->
	<script src="${page }/static/js/login.js" type="text/javascript"></script>      

	     
	<!-- END PAGE LEVEL SCRIPTS --> 

	<script type="text/javascript">
		$(function(){
		App.init();
		LoginForm.init();
	});
		
	</script>
	<!-- END JAVASCRIPTS -->

<!-- <script type="text/javascript">  var _gaq = _gaq || [];  _gaq.push(['_setAccount', 'UA-37564768-1']);  _gaq.push(['_setDomainName', 'keenthemes.com']);  _gaq.push(['_setAllowLinker', true]);  _gaq.push(['_trackPageview']);  (function() {    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;    ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);  })();</script> -->

<!-- END BODY -->

  </body>

</html>
