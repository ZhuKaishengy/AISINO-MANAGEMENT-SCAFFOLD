package com.aisino.realms.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.aisino.dao.shiro.UserMapper;
import com.aisino.domain.shiro.Permission;
import com.aisino.domain.shiro.Role;
import com.aisino.domain.shiro.User;

public class ShiroRealm extends AuthorizingRealm{

	@Autowired
	UserMapper userMapper;
	
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		//从realms中获取第一个principal
		String principal = (String) principals.getPrimaryPrincipal();
		//根据principal在数据库中查询User，级联roles和permissions
		User user = userMapper.selectByPrincipalWithRP(principal);
		//封装结果集 AuthorizationInfo
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		if(user != null){
			List<Role> roles = user.getRoles();
			if(roles != null && roles.size() > 0){
				for (Role role : roles) {
					info.addRole(role.getRoleName());
					List<Permission> permissions = role.getPermissions();
					if(permissions != null && permissions.size() > 0){
						for (Permission permission : permissions) {
							//注意：StringPermission为null报错
							if(permission.getPermissionUri() != null ){
								info.addStringPermission(permission.getPermissionUri());
							}
						}
					}
				}
				
			}
		}
		
		return info;
	}

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		//获取表单用户名
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		//根据用户名在数据库中检索密码
		String userCriditials = userMapper.selectByUserPrincipal(username);
		//封装成 AuthenticationInfo 对象返回,采用MD5盐值加密
		if(userCriditials != null){
			ByteSource credentialsSalt = ByteSource.Util.bytes(username);
			String realmName = super.getName();
			AuthenticationInfo info = new SimpleAuthenticationInfo(username, userCriditials, credentialsSalt, realmName);
			return info;
		}
		return null;
	}

}
