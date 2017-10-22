package com.aisino.service.shiro.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.dao.shiro.UserMapper;
import com.aisino.domain.shiro.UserExample;
import com.aisino.domain.shiro.UserExample.Criteria;
import com.aisino.service.shiro.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public boolean selectWhetherValidPrincipal(String userPrincipal) {
		
		UserExample example = new UserExample();
		Criteria criteria1 = example.createCriteria();
		criteria1.andUserPrincipalEqualTo(userPrincipal);
		
		Criteria criteria2 = example.createCriteria();
		criteria2.andUserPhoneEqualTo(userPrincipal);
		
		example.or(criteria2);
		int count = userMapper.countByExample(example);
		return count==1;
	}

}
