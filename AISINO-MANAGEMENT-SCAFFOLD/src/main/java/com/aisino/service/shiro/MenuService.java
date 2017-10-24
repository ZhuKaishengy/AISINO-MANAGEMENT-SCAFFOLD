package com.aisino.service.shiro;

import java.util.List;

import com.aisino.domain.shiro.Menu;

public interface MenuService {

	public List<Menu> getMenuListByUpId(String upId);
}
