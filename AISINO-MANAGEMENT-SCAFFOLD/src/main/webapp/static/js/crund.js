/**
 * date类型的工具函数
 */
/* 获取日期格式 */
function getDate(str) {
	var date = new Date(str);
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    return year + "-" + month + "-" + day ;
}
/* 获取日期时间格式*/
function getDateTime(str) {
	
	var date = new Date(str);
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    var hh = date.getHours();
    var mm = date.getMinutes();
    var ss = date.getSeconds();
    return year + "-" + month + "-" + day + " " + hh + ":" + mm + ":" + ss;
}
/**
 * 实现在一个页面增删改查
 */
var totalRecord,currentPage,pageSize,old_page;

$(function(){
	to_page(1,10);
});

//实现只改变 pageSize,表头复选框checked属性值不变
function get_old_page(){
	
	return currentPage;
};

//显示列表页
function to_page(pageNum,pageSize){
	
	old_page = get_old_page();
	
	$.ajax({
		url: "emps",
		type: "GET",
		data: "pageNum="+pageNum+"&pageSize="+pageSize,
		success: function(result){
			//jquery 3.2.1 可以直接解析json
//			var result = JSON.parse(result);
//			console.log(result.code);
			//1、解析并显示员工数据
			build_emps_table(result);
			//2、解析并显示分页信息
			build_page_info(result);
			//3、解析显示分页条数据
			build_page_nav(result);
			//4. 重置表头复选框
			reset_list_table();
			
		}
	});
};


//重置表头复选框状态（只是改变pageSize，#check_all状态不变）
function reset_list_table(){
	
	if(old_page == currentPage){
		$(".check_item").prop("checked", $("#check_all").prop("checked"));
	}else{
		$("#check_all").prop("checked",false);
	}
};

function build_emps_table(result){
	//循环构建table
	var tbody = $("#listTable tbody");
	tbody.empty();
	var emps = result.extendMap.pageInfo.list;
	$.each(emps, function(i, elt) {
		var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
		var empIdTd = $("<td></td>").append(elt.empId);
		var empNameTd = $("<td></td>").append(elt.empName);
		var empEmailTd = $("<td></td>").append(elt.empEmail);
		var empBirthTd = $("<td></td>").append(getDate(elt.empBirth));
		var deptNameTd = $("<td></td>").append(elt.dept.deptName);
		//构建修改按钮
		var editSpan = $("<span></span>").addClass("glyphicon glyphicon-pencil");
		var editButton = $("<button></button>").attr("type","button").attr("operate_id", elt.empId).addClass("btn  btn-info btn-sm edit_btn").append(editSpan).append("修改");
		var editButtonTd = $("<td></td>").append(editButton);
		//构建删除按钮
		var deleteSpan = $("<span></span>").addClass("glyphicon glyphicon-trash");
		var deleteButton = $("<button></button>").attr("type","button").attr("operate_id", elt.empId).addClass("btn btn-danger btn-sm delete_btn").append(deleteSpan).append("删除");
		var deleteButtonTd = $("<td></td>").append(deleteButton);
			
		var tr = $("<tr></tr>").append(checkBoxTd).append(empIdTd).append(empNameTd).append(empEmailTd).append(empBirthTd).append(deptNameTd)
						.append(editButtonTd).append(deleteButtonTd);
		tr.appendTo(tbody);
	});
}

//构建分页信息
function build_page_info(result){
	$("#page_info").empty();
	totalRecord = result.extendMap.pageInfo.total;
	currentPage = result.extendMap.pageInfo.pageNum;
	pageSize = result.extendMap.pageInfo.pageSize;
	
	
	var selectItem = $("<select></select>").append("<option>10</option>")
		.append("<option>20</option>").append("<option>50</option>").attr("id","selectPageSize");
	
	$("#page_info").append("第"+result.extendMap.pageInfo.pageNum+"页,共"+
			result.extendMap.pageInfo.pages+"页,"+
			result.extendMap.pageInfo.total+"条记录，每页显示").append(selectItem).append("条记录。");
	
	//页面回显pageSize
	$.each($("option"), function(i, elt) {
		if(pageSize == $(elt).text()){
			$(elt).attr("selected","selected");
		}
	});
}

//监听pageSize select 改变,注意：给document用on绑定事件
$(document).on("change","#selectPageSize", function() {
	var selectVal = $("#selectPageSize").val();
	to_page(currentPage, selectVal);
})


function build_page_nav(result){
	//page_nav_area
	$("#page_nav").empty();
	var ul = $("<ul></ul>").addClass("pagination");
	
	//构建元素
	var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
	var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
	if(!result.extendMap.pageInfo.hasPreviousPage){
		firstPageLi.addClass("disabled");
		prePageLi.addClass("disabled");
	}else{
		//为元素添加点击翻页的事件
		firstPageLi.click(function(){
			to_page(1,pageSize);
		});
		prePageLi.click(function(){
			to_page(currentPage-1,pageSize);
		});
	}
	var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
	var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
	if(!result.extendMap.pageInfo.hasNextPage){
		nextPageLi.addClass("disabled");
		lastPageLi.addClass("disabled");
	}else{
		nextPageLi.click(function(){
			to_page(currentPage+1,pageSize);
		});
		lastPageLi.click(function(){
			to_page(result.extendMap.pageInfo.pages,pageSize);
		});
	}
	//添加首页和前一页 的提示
	ul.append(firstPageLi).append(prePageLi);
	//1,2，3遍历给ul中添加页码提示
	$.each(result.extendMap.pageInfo.navigatepageNums,function(index,item){
		
		var numLi = $("<li></li>").append($("<a></a>").append(item));
		if(result.extendMap.pageInfo.pageNum == item){
			numLi.addClass("active");
		}
		numLi.click(function(){
			to_page(item,pageSize);
		});
		ul.append(numLi);
	});
	//添加下一页和末页 的提示
	ul.append(nextPageLi).append(lastPageLi);
	
	//把ul加入到nav
	var navEle = $("<nav></nav>").append(ul);
	navEle.appendTo("#page_nav");
	
}

//点击新增按钮弹出模态框。
$(document).on("click", "#emp_add_btn" ,function() {
	//清除表单数据（表单完整重置（表单的数据，表单的样式））
	reset_form("#empAddModal form",true);
	//发送ajax请求，查出部门信息，显示在下拉列表中
	getDepts("#empAddModal select");
	//弹出模态框
	$("#empAddModal").modal({
		backdrop:"static",
		 keyboard: true
	});
	
	$('.form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
//		startView: 2,
		forceParse: 0,
        showMeridian: 1,
        pickerPosition: "bottom-left"
    });
	
})

/**
 * 清除表单样式及内容
 * ele:选择器
 * flag:是否清除表单内容
 */
function reset_form(ele,flag){
	if(flag){
		$(ele)[0].reset();
	}
	//清空表单样式
	$(ele).find("*").removeClass("has-error has-success");
	$(ele).find(".help-block").text("");
}

//查出所有的部门信息并显示在下拉列表中
function getDepts(ele){
	//清空之前下拉列表的值
	$(ele).empty();
	$.ajax({
		url:"depts",
		type:"GET",
		success:function(result){
			$.each(result.extendMap.depts,function(){
				var optionEle = $("<option></option>").append(this.deptName).attr("value",this.deptId);
				optionEle.appendTo(ele);
			});
		}
	});
	
}

//前端校验表单用户名
function validate_add_form_empName(){
	//1、拿到要校验的数据，使用正则表达式
	var empName = $("#empName_add_input").val();
	var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
	if(!regName.test(empName)){
		show_validate_msg("#empName_add_input", "error", "用户名可以是2-5位中文或者6-16位英文和数字的组合");
		return false;
	}
	return true;
};
//前端校验邮箱
function validate_add_form_email(ele){
	//2、校验邮箱信息
	var email = $(ele).val();
	var regEmail = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
	if(!regEmail.test(email)){
		//应该清空这个元素之前的样式
		show_validate_msg(ele, "error", "邮箱格式不正确");
		return false;
	}else{
		show_validate_msg(ele, "success", "邮箱格式正确");
	}
	return true;
};

//显示校验结果的提示信息,并添加验证结果标签
function show_validate_msg(ele,status,msg){
	//清除当前元素的校验状态
	$(ele).parent().removeClass("has-success has-error");
	$(ele).next("span").text("");
	$(ele).next("span").next("span").removeClass("glyphicon glyphicon-ok glyphicon-remove");
	if("success"==status){
		$(ele).parent().addClass("has-success");
		$(ele).next("span").next("span").addClass("glyphicon glyphicon-ok");
		$(ele).attr("validate-all", "success");
	}else if("error" == status){
		$(ele).parent().addClass("has-error");
		$(ele).next("span").text(msg);
		$(ele).next("span").next("span").addClass("glyphicon glyphicon-remove");
		$(ele).attr("validate-all", "error");
	}
}
function show_validate_msg_only(ele,status,msg){
	//清除当前元素的校验状态
	$(ele).parent().removeClass("has-success has-error");
	$(ele).next("span").text("");
	if("success"==status){
		$(ele).parent().addClass("has-success");
	}else if("error" == status){
		$(ele).parent().addClass("has-error");
		$(ele).next("span").text(msg);
	}
}

//后台验证用户名
function checkUser(){
	//发送ajax请求校验用户名是否可用
	var empName = $("#empName_add_input").val();
	$.ajax({
		url:"checkuser",
		data:"empName="+empName,
		type:"POST",
		success:function(result){
			if(result.code==1001){
				show_validate_msg("#empName_add_input","success","用户名可用");
			}else{
				show_validate_msg("#empName_add_input","error",result.extendMap.va_msg);
			}
		}
	});
};

//校验用户名
$(document).on("change","#empName_add_input", function() {
	var flag = validate_add_form_empName();
	if(flag){
		checkUser();
	}
});

//校验邮箱
$(document).on("change","#email_add_input", function() {
	var flag = validate_add_form_email(this);
});

//添加模态框提交时,校验表单信息
$(document).on("click", "#emp_save_btn",function() {
	
	if(!($("#empName_add_input").attr("validate-all") == "success")){
		show_validate_msg("#empName_add_input", "error", "必须输入用户名");
	}
	if(!($("#email_add_input").attr("validate-all") == "success")){
		show_validate_msg("#email_add_input", "error", "必须输入邮箱");
	}
	if($("#empName_add_input").attr("validate-all") == "success" && $("#email_add_input").attr("validate-all") == "success"){
		$.ajax({
			url: "emp",
			type: "POST",
			data: $("#empAddModal form").serialize(),
			success: function(result){
				//操作成功
				if(result.code ==  "1001"){
					//模态框关闭,定位最后一页
					$("#empAddModal").modal("hide");
					to_page(totalRecord, pageSize);
				}else{
					//有哪个字段的错误信息就显示哪个字段的；
					if(undefined != result.extendMap.errorMap.empEmail){
						//显示邮箱错误信息
						show_validate_msg("#email_add_input", "error", result.extendMap.errorMap.empEmail);
					}
					if(undefined != result.extendMap.errorMap.empName){
						//显示员工名字的错误信息
						show_validate_msg("#empName_add_input", "error", result.extendMap.errorMap.empName);
					}
					if(undefined != result.extendMap.errorMap.empBirth){
						//显示员工名字的错误信息
						show_validate_msg_only("#birth_add_input", "error", result.extendMap.errorMap.empBirth);
					}
				}
			}
		})
	}
});

//修改模态框显示
$(document).on("click",".edit_btn",function(){
	reset_form("#empUpdateModal",false);
	//保存 operate_id
	var operate_id = $(this).attr("operate_id");
	$("#emp_update_btn").attr("operate_id", operate_id);
	
	//1、查出部门信息，并显示部门列表
	getDepts("#empUpdateModal select");
	//2、查出员工信息，显示员工信息
	getEmp(operate_id);
	//3.显示修改模态框
	$("#empUpdateModal").modal({
		backdrop:"static"
	});
	
	//4.datetime-picker事件
	$('.form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
//		startView: 2,
		forceParse: 0,
        showMeridian: 1,
        pickerPosition: "bottom-left"
    });
});

//后台获取修改员工的信息
function getEmp(id){
	$.ajax({
		url:"emp/"+id,
		type:"GET",
		success:function(result){
//			console.log(result);
			var empData = result.extendMap.emp;
			$("#empName_update_static").text(empData.empName);
			$("#email_update_input").val(empData.empEmail);
			$("#dtp_input").val(getDate(empData.empBirth));
			$("#birth_add_input").val(getDate(empData.empBirth));
			$("#empUpdateModal select").val([empData.deptId]);
		}
	});
}

//修改页面邮箱信息的前端验证
$(document).on("change","#email_update_input", function() {
	validate_add_form_email(this);
});

//点击更新，更新员工信息
$(document).on("click","#emp_update_btn", function() {
	//1、校验邮箱信息
		if(!($("#email_update_input").attr("validate-all") == "error")){
			
			//2、发送ajax请求保存更新的员工数据
			$.ajax({
				url:"emp/"+$("#emp_update_btn").attr("operate_id"),
				type:"PUT",
				data:$("#empUpdateModal form").serialize(),
				success:function(result){
					debugger;
					if(result.code == "1001"){
						//1、关闭对话框
						$("#empUpdateModal").modal("hide");
						//2、回到本页面
						to_page(currentPage,pageSize);
					}else{
						show_validate_msg_only("#birth_update_input","error",result.extendMap.errorMap.empBirth);
					}
				}
			});
		}
});

//单个删除
$(document).on("click",".delete_btn",function(){
	//1、弹出是否确认删除对话框
	var empName = $(this).parents("tr").find("td:eq(2)").text();
	var empId = $(this).attr("operate_id");
	
	build_confirm_table("系统提示","确认删除【"+empName+"】吗？",single_delete,"系统提示","删除成功！",empId);
});

/**
 * 创建confirm_table
 * 
 * title,模态框头
 * content,模态框内容
 * callbackfunction,回调函数	注意：1.js中的回调函数和普通参数一样声明 2.像方法一样调用 3.可加形式参数
 * return_title,返回模态框头
 * return_message,返回模态框内容
 * arg：回调函数的形参
 */
function build_confirm_table(title,content,callbackfunction,return_title,return_message,arg){
	
	 Confirm.show(title, content, {
         '确定': {
             'primary': true,
             'callback': function() {
            	 callbackfunction(arg);
                 Confirm.show(return_title, return_message);
             }
         }
     });
};


//完成全选/全不选功能--注意：翻页时，#check_all不变
$(document).on("click","#check_all", function() {
	//prop修改和读取dom原生属性的值
	$(".check_item").prop("checked", $(this).prop("checked"));
});

//反选功能
$(document).on("click",".check_item",function(){
	//判断当前所有复选框都被选中
	var flag = $(".check_item:checked").length==$(".check_item").length;
	$("#check_all").prop("checked",flag);
});


//点击全部删除，就批量删除
$(document).on("click","#emp_delete_all_btn",function() {
	var empNames = "";
	var del_idstr = "";
	$.each($(".check_item:checked"),function(){
		//this
		empNames += $(this).parents("tr").find("td:eq(2)").text()+",";
		//组装员工id字符串
		del_idstr += $(this).parents("tr").find("td:eq(1)").text()+"-";
	});
	//去除empNames多余的,
	empNames = empNames.substring(0, empNames.length-1);
	//去除删除的id多余的-
	del_idstr = del_idstr.substring(0, del_idstr.length-1);
	
	build_confirm_table("系统提示","确认删除【"+empNames+"】吗？",batch_delete,"系统提示","删除成功！",del_idstr);
	
});


//后台单个删除的方法
function single_delete(empId){
	
	//确认，发送ajax请求删除即可
	$.ajax({
		url:"emp/"+empId,
		type:"DELETE",
		success:function(result){
			//回到本页
			to_page(currentPage,pageSize);
		}
	});
}


//后台批量删除
function batch_delete(del_idstr){
	if(!(del_idstr == "" || del_idstr.length == 0)){
		
		//发送ajax请求删除
		$.ajax({
			url:"emp/"+del_idstr,
			type:"DELETE",
			success:function(result){
				//回到当前页面
				to_page(currentPage,pageSize);
			}
		});
	}
}

