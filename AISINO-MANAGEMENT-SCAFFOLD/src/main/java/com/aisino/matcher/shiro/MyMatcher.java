package com.aisino.matcher.shiro;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.subject.PrincipalCollection;

import com.aisino.token.shiro.LoginToken;
/**
 * 
 * @ClassName: MyMatcher
 * @Description: TODO(自定义凭证匹配器，用于加入：1.3次输入密码错误账户锁定	2.短信验证登陆免密码	功能)
 * @author ZhuKaishengy
 * @date 2017年9月1日 下午1:10:23
 */
public class MyMatcher extends HashedCredentialsMatcher {

	  	private Cache<String, AtomicInteger> passwordRetryCache;  //创建缓存的对象  
	  	
	  	private Cache<String, AtomicInteger> loginWithoutPasswordCache;
	  	
	    public MyMatcher(CacheManager cacheManager) {  
	        //赋予缓存对象，此处获取的是我们在ehcache.xml文件中配置,注意getCache("")获取的是xml中的name  
	        passwordRetryCache = cacheManager.getCache("passwordRetryCache");     
	        loginWithoutPasswordCache = cacheManager.getCache("loginWithoutPassword");     
	    }  
	  
	    @Override  
	    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {  
	        
	    	LoginToken lToken = (LoginToken) token;
	    	String type = lToken.getLoginType();
	    	
	    	if("0".equals(type)){
	    		//普通对登陆
	    		return this.doCredentialsMatchCommon(lToken, info);
	    	}else{
	    		//免密登陆
	    		return this.doCredentialsMatchIdentity(lToken, info);
	    	}
	    	
	    }
	    //普通登陆时的密码匹配，用户锁定功能验证
	    public boolean doCredentialsMatchCommon(AuthenticationToken token, AuthenticationInfo info) { 
	    	String username = (String) token.getPrincipal();    //获取用户名  
	  	  
	        AtomicInteger retryCount = passwordRetryCache.get(username);    //获取用户登录的次数  
	  
	        if (retryCount == null) {   //如果用户未登陆过  
	            retryCount = new AtomicInteger(0);  //新建一个登录次数  
	            passwordRetryCache.put(username, retryCount);   //放入缓存中  
	        }  
	  
	        if (retryCount.incrementAndGet() > 3) {  //如果用户登录次数超过三次（此处可根据需要自定义）  
	            throw new ExcessiveAttemptsException(); //抛出用户锁定异常类  
	        }  
	  
	        boolean matches = super.doCredentialsMatch(token, info);    //判断用户是否可用，即是否为正确的账号密码  
	          
	        if(matches){  
	            passwordRetryCache.remove(username);    //移除缓存中用户的登录次数  
	        }  
	  
	        return matches;  
	    }
	    
	    //免密登录时的密码匹配
	    public boolean doCredentialsMatchIdentity(AuthenticationToken token, AuthenticationInfo info) { 
	    	//获取token中的凭证
	    	LoginToken lToken = (LoginToken) token;
	    	String userPhone = lToken.getUserPhone();
	    	String identitiCode = lToken.getIdentitiCode();
	    	//获取AuthenticationInfo中的凭证
	    	PrincipalCollection principals = info.getPrincipals();
	    	String principal = (String) principals.asList().get(0);
	    	Object credentials = info.getCredentials();
	    	
	    	boolean matches = userPhone.equals(principal) && identitiCode.equals(String.valueOf(credentials));
	    	if(matches){
	    		loginWithoutPasswordCache.remove(userPhone);
	    	}
	    	return matches;
	    }
}
