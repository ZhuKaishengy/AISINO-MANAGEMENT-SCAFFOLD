package com.aisino.realms.shiro;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.aisino.dao.shiro.UserMapper;
import com.aisino.domain.shiro.User;
import com.aisino.token.shiro.LoginToken;

public class PhoneAuthenticationRealm extends AuthenticatingRealm{

	@Autowired
	UserMapper userMapper;
	
	private Cache<String, AtomicInteger> loginWithoutPasswordCache ;  //创建缓存的对象  
	
	public PhoneAuthenticationRealm(CacheManager cacheManager) {
		super();
		// TODO Auto-generated constructor stub
		loginWithoutPasswordCache = cacheManager.getCache("loginWithoutPassword");
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		AuthenticationInfo authenticationInfo = null;
		
		LoginToken lToken =  (LoginToken) token;
		//1.判断是不是免密登陆
		String loginType = lToken.getLoginType();
			//1.1 使用免密登陆
		if("1".equals(loginType)){
			//1.1.1 通过手机号，在缓存中获取验证码
			String userPhone = lToken.getUserPhone();
			AtomicInteger atomicInteger = loginWithoutPasswordCache.get(userPhone);
			//1.1.2 将手机号和验证码封装成 AuthenticationInfo 并返回
			authenticationInfo = new SimpleAuthenticationInfo(userPhone, atomicInteger, super.getName());
		}else{
			//1.2普通登陆
			//2.判断是用用户名、密码登陆还是手机号、密码登陆
			String userPhone = lToken.getUsername();
			User user = userMapper.selectByUserPhone(userPhone);
			String userCredicials = user.getUserCreditials();
			ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUserPrincipal());
			String realmName = super.getName();
			authenticationInfo = new SimpleAuthenticationInfo(userPhone, userCredicials, credentialsSalt, realmName);
			
		}
		return authenticationInfo;
	}

}
