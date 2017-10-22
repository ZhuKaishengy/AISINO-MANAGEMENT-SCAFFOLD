package com.aisino.system;

public class CommonConstant {

	//======发送手机短信=========
	public static final String SMSURL;
	public static final String SMSSPCODE;
	public static final String SMSLOGINNAME;
	public static final String SMSPASSWORD;
	public static final String SYSTEMNAME;
	static{
		
		SMSURL = "https://api.ums86.com:9600/sms/Api/Send.do";
		SMSSPCODE = "236913";
		SMSLOGINNAME = "ln_htxx";
		SMSPASSWORD = "Htxx_syt410";
		SYSTEMNAME="AISINO 管理系统";
	}
	
}
