var Lock = function () {

    return {
        //main function to initiate the module
        init: function () {
        	//切换背景图片
             $.backstretch([
		        "../static/pic/bg/1.jpg",
		        "../static/pic/bg/2.jpg",
		        "../static/pic/bg/3.jpg",
		        "../static/pic/bg/4.jpg"
		        ], {
		          fade: 1000,
		          duration: 3000
		      });
            
            //表单验证 
             $.validator.addMethod("validate_password_method",function(value,element,params){  
 				var regName = /^[a-zA-Z0-9_-]{6,18}$/;
 				return regName.test(value);
 			});
             
             $('#lock_form').validate({
 				errorElement: 'label', //default input error message container
 	            errorClass: 'help-inline', // default input error message class
 	            focusInvalid: true, // do not focus the last invalid input
 			    rules: {
	 			      userCreditials: {
	 				      required: true,
	 				      validate_password_method: ""
	 			      }
 			    	  
 			    },
 			    messages: {
	 			      userCreditials: {
	 			        required: "密码不能为空！",
	 			        validate_password_method: "密码必须是6~18位字母和数字的组合！"
	 			      }
 			    },
 			    
 			    invalidHandler: function (event, validator) { //display error alert on form submit   
 	             
 	            },

 	            highlight: function (element) { // hightlight error inputs
 	            	$(element).closest('.control-group').removeClass('success');
 	                $(element)
 	                    .closest('.control-group').addClass('error'); // set error class to the control group
 	            },
 	            unhightlight:function(element){
 	            	 $(element)
 	                    .closest('.control-group').addClass('has-success'); // set success class to the control group
 	            },
 	            success: function (label) {
 	            	label.closest('.control-group').removeClass('error');
 	            	label.closest('.control-group').addClass('success');
 	            	label.remove();
 	            },

 	            errorPlacement: function (error, element) {
 	                error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-append'));
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
				debugger;
				var validator = $('#lock_form').validate();
				//1.判断表单验证是否通过
				if(validator.form()){
					login();
					//2.判断ajax的返回值
					if(!validate_ajax_return){
						//4.为假，从新显示错误信息
						validator.showErrors({
							"userCreditials": error_msg
						});
					}
				}
			};
 			
 			//定义页面跳转的方法
 			function to_page_main(){
 				location.href = "main";
 			};
 			
 			var validate_ajax_return,error_msg;
 			
 			
 			//用于登陆ajax，包括跳转
 			function login(){
// 				var userPrincipal = $('#userPrincipal').text();
 				var userCreditials = $('#userCreditials').val();
 				$.ajax({
// 					url: "http://localhost:8080/AISINO-MANAGEMENT-SCAFFOLD/shiro/login?userPrincipal=1121111&userCreditials=2",
 					url: "comparePass",
 					type: "get",
 					data: {
// 						userPrincipal:userPrincipal,
 						userCreditials:userCreditials
 					},
 					success:function(result){
 						if(result.code == "9999"){
 							error_msg = result.extendMap.response_message;
 							validate_ajax_return=false;
 							
 						}else if (result.code == "1001"){
 							validate_ajax_return=true;
 							to_page_main();
 						}
 						
 					}
 				});
 			};
 			
 			
 			
 			
 			
 			
 			
 			
             
        }

    };

}();