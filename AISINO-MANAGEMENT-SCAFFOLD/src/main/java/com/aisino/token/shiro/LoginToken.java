package com.aisino.token.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 
 * @ClassName: LoginToken
 * @Description: TODO(自定义token，封装表单传来的token，用于登陆，实现免密登陆)
 * @author ZhuKaishengy
 * @date 2017年9月1日 下午1:17:41
 */
public class LoginToken extends UsernamePasswordToken {
 
	private static final long serialVersionUID = 1L;
	
	private String loginType;//登陆类型，0为普通登录 ，1为免密登陆
	
	private String userPhone;//手机号
	
	private String identitiCode;//验证码

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getIdentitiCode() {
		return identitiCode;
	}

	public void setIdentitiCode(String identitiCode) {
		this.identitiCode = identitiCode;
	}
	
	public LoginToken(final String username, final String password,
            final boolean rememberMe, final String host,String loginType,String userPhone,String identitiCode) {
        super(username, password, rememberMe, host);
        this.loginType = loginType;
        this.userPhone = userPhone;
        this.identitiCode = identitiCode;
    }
	public LoginToken(final String username, final String password,
				String loginType,String userPhone,String identitiCode) {
		super(username, password);
		this.loginType = loginType;
		this.userPhone = userPhone;
		this.identitiCode = identitiCode;
	}
	
}
