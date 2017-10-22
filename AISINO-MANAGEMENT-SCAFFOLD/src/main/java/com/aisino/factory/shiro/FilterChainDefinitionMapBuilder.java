package com.aisino.factory.shiro;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aisino.dao.shiro.FilterChainDefinitionMapper;
import com.aisino.domain.shiro.FilterChainDefinition;

@Component
public class FilterChainDefinitionMapBuilder {

	@Autowired
	FilterChainDefinitionMapper filterChainDefinitionMapper;
	
	public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
		
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		
		//从数据库中检索授权信息，有顺序
		List<FilterChainDefinition> list = filterChainDefinitionMapper.selectAllOrderByIdDesc();
		for (FilterChainDefinition filterChainDefinition : list) {
			String uri = filterChainDefinition.getUri();
			String filter = filterChainDefinition.getFilter();
			map.put(uri, filter);
		}
		return map;
	}
}
