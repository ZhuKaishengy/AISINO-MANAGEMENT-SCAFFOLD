package com.aisino.service.shiro.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.dao.shiro.MenuMapper;
import com.aisino.domain.shiro.Menu;
import com.aisino.domain.shiro.MenuExample;
import com.aisino.service.shiro.MenuService;

@Service
public class MunuServiceImpl implements MenuService {

	@Autowired
	MenuMapper menuMapper;
	
	@Override
	public List<Menu> getMenuListByUpId(String upId) {
		//upId == null？一级菜单：二级菜单
		upId = upId == null ? "0000" : upId;
		MenuExample example = new MenuExample();
		example.createCriteria().andMenuUpidEqualTo(upId).andStatusEqualTo("1");
		List<Menu> list = menuMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<Menu> getMenuList() {
		// TODO Auto-generated method stub
		
		List<Menu> list = menuMapper.selectByExample(null);
		return list;
	}

}
