var LoginForm = function(){
	
	return {
		init:function(){
			
			$.validator.addMethod("validate_username_method",function(value,element,params){  
				var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
				return regName.test(value);
			});
			$.validator.addMethod("validate_password_method",function(value,element,params){  
				var regName = /^[a-zA-Z0-9_-]{6,18}$/;
				return regName.test(value);
			});
			
			$('.login-form').validate({
				errorElement: 'span', //default input error message container
	            errorClass: 'help-inline', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
			    rules: {
			    	userPrincipal: {
			        required: true,
			        validate_username_method: ""
			
			      },
			      userCreditials: {
				      required: true,
				      validate_password_method: ""
			      }
			      
			    	  
			    },
			    messages: {
			    	userPrincipal: {
			        required: "用户名不能为空！",
			        validate_username_method: "用户名必须是2~5位中文和6~16位字母和数字的组合！"
			      },
			      userCreditials: {
			        required: "密码不能为空！",
			        validate_password_method: "密码必须是6~18位字母和数字的组合！"
			      }
			    },
			    
			    invalidHandler: function (event, validator) { //display error alert on form submit   
	                $('.alert-error', $('.login-form')).show();
	            },

	            highlight: function (element) { // hightlight error inputs
	            	$(element).closest('.form-group').removeClass('success');
	                $(element)
	                    .closest('.form-group').addClass('error'); // set error class to the control group
	            },
	            unhightlight:function(element){
	            	 $(element)
	                    .closest('.form-group').addClass('has-success'); // set success class to the control group
	            },
	            success: function (label) {
	            	label.closest('.form-group').removeClass('error');
	            	label.closest('.form-group').addClass('success');
	            	label.remove();
	            },

	            errorPlacement: function (error, element) {
	                error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
	            },
	            submitHandler: function(){
	            	validate_before_submit();
	            	
	            }

			});
			
			//定义键盘回车
			$(document).keypress(function (e) {
	            if (e.which == 13) {
	            	validate_before_submit();
	            }
	        });
			
			//提交前的验证
			function validate_before_submit(){
				var validator = $('.login-form').validate();
				//1.判断表单验证是否通过
				if(validator.form()){
					//2.判断ajax的返回值
					if(validate_principal_ajax_return){
						//3.为真提交表单
						login();
						//4.为假，从新显示错误信息
					}else if (!validate_principal_ajax_return){
				    	validator.showErrors({
							"userPrincipal": error_msg
						});
				    };
				}
			};
			
			//userPrincipal的触发事件
			$("#userPrincipal").change(function(){
				var validator = $('.login-form').validate();
				if(validator.element("#userPrincipal")){
					validate_principal_ajax(validator);
				}
			});
			
			//定义页面跳转的方法
			function to_page_main(){
				location.href = "shiro/main";
			};
			
			var validate_principal_ajax_return,error_msg;
			
			//ajax后端验证 userPrincipal是否可用
			function validate_principal_ajax(validator){
				var value = $('#userPrincipal').val();
				$.ajax({
					dataType: "json",
//					url: "http://localhost:8080/AISINO-MANAGEMENT-SCAFFOLD/shiro/validatePrincipalAjax?userPrincipal=zks",
					url: "shiro/validatePrincipalAjax",
					type: "GET",
					data:{userPrincipal:value},
					success: function(result){
						if(result.code=="9999"){
							error_msg = result.extendMap.errorInfo;
							validator.showErrors({
								"userPrincipal": result.extendMap.errorInfo
							});
							validate_principal_ajax_return = false;
						}else if (result.code = "1001") {
							validate_principal_ajax_return = true;
						}
					}
				});
				
			};
			//用于登陆ajax，包括跳转
			function login(){
				$.ajax({
//					url: "http://localhost:8080/AISINO-MANAGEMENT-SCAFFOLD/shiro/login?userPrincipal=1121111&userCreditials=2",
					url: "shiro/login",
					type: "get",
					data:$('.login-form').serialize(),
					success:function(result){
						if(result.code == "9999"){
							var resultMap = result.extendMap.resultMap;
							var userPrincipal ;
							(resultMap.userPrincipal == undefined)? userPrincipal = "":userPrincipal = resultMap.userPrincipal;
							var userCreditials;
							(resultMap.userCreditials == undefined)? userCreditials="":userCreditials=resultMap.userCreditials;
							var exception = resultMap.Exception == undefined? "":resultMap.Exception;
							$('#login-form-alert').show().find('span').text(userPrincipal+userCreditials+exception);
							
						}else if (result.code == "1001"){
							to_page_main();
						}
						
					}
				});
			};
			
			//form主体菜单切换
			$('#forget-password').click(function () {
	            $('.login-form').hide();
	            $('.forget-form').show();
	        });

	        $('#back-btn').click(function () {
	            $('.login-form').show();
	            $('.forget-form').hide();
	        });
	        
	        //自定义校验phone的方法
	        $.validator.addMethod("isMobile", function(value, element) {
	        	var regName = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
	        	return regName.test(value);
	        });
	        //自定义校验identitiCode的方法
	        $.validator.addMethod("isIdentitiCode", function(value, element) {
	        	var regName = /^([0-9]{6})$/;
	        	return regName.test(value);
	        });
	        
	        //forget-form校验
	        $('.forget-form').validate({
	            errorElement: 'span', //default input error message container
	            errorClass: 'help-inline', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            ignore: "",
	            rules: {
	            	userPhone: {
	                    required: true,
	                    isMobile: true
	                },
	                identitiCode:{
	                	required:true,
	                	isIdentitiCode:true
	                }
	            },

	            messages: {
	            	userPhone: {
	                    required: "请填写您的手机号！",
	                    isMobile:"请填写正确的手机号！"
	                },
	                identitiCode:{
	                	required:"请输入验证码！",
	                	isIdentitiCode:"验证码为六位数！"
	                }
	            },

	            invalidHandler: function (event, validator) { //display error alert on form submit   

	            },

	            highlight: function (element) { // hightlight error inputs
	                $(element)
	                    .closest('.form-group').addClass('has-error'); // set error class to the control group
	            },

	            success: function (label) {
	                label.closest('.form-group').removeClass('has-error');
	                label.remove();
	            },

	            errorPlacement: function (error, element) {
	                error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
	            },

	            submitHandler: function (form) {
	            	validate_before_forgetForm_submit();
	            }
	        });
	        
	        //发送验证码，点击事件
	        $("#sendIdentitiCode").click(function(){
	        	var userPhone = $("#userPhone").val();
	        	//1.验证手机号
	        	if ($('.forget-form').validate().element("#userPhone")) {
	        		
	        		settime(this);
	        		//2.发送ajax
	        		sendIdentitiCode_ajax(userPhone);
	        		//3.页面显示变化
//	        		$(this).attr("disabled","disabled").find("i").addClass("fa fa-spinner fa-spin");
	        	}
	        	
	        });
            var countdown=60;
            
            function settime(obj) {
              if (countdown == 0) {
                obj.removeAttribute("disabled");
                obj.innerHTML="获取验证码";
                countdown = 60;
                return;
              } else {
                obj.setAttribute("disabled", "disabled");
                obj.innerHTML= countdown + "秒后再获取";
                countdown--;
              }
            setTimeout(function() {
              settime(obj) }
              ,1000)
            };
            
	        $(document).keypress(function (e) {
	            if (e.which == 13) {
	            	validate_before_forgetForm_submit();
	            }
	        });
	        
	        function validate_before_forgetForm_submit(){
	        	var validator = $('.forget-form').validate();
	        	if(validator.form()){
	        		$.ajax({
//						url: "http://localhost:8080/AISINO-MANAGEMENT-SCAFFOLD/shiro/login?userPrincipal=1121111&userCreditials=2",
						url: "shiro/login",
						type: "get",
						data:$('.forget-form').serialize(),
						success:function(result){
							if(result.code == "9999"){
								$("#forget-form-alert").show().find('span').text("验证码不正确！");
								
							}else if (result.code == "1001"){
								to_page_main();
							}
							
						}
					});
	        	}
	        };
	        
			function sendIdentitiCode_ajax(userPhone){
				$.ajax({
					url:"shiro/sendIdentitiCode",
					type:"Get",
					data:{
						userPhone:userPhone
					},
					dataType: "json",
					success:function(result){
						if(result.code == "1001"){
							$("#forget-form-alert").removeClass('alert-error').addClass('alert-success').show().find('span').text("短信发送成功！");
						}
						if(result.code == "9999"){
							$("#forget-form-alert").show().find('span').text("短信发送失败！");
						}
						
					}
						
				});
			};
		}
	};
}();