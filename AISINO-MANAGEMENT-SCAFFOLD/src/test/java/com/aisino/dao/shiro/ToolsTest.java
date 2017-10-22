package com.aisino.dao.shiro;

import org.apache.shiro.cache.CacheManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aisino.utils.shiro.TinnyTools;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/applicationContext.xml")
public class ToolsTest {

	@Autowired
	CacheManager cacheManager;
	
	@Test
	public void testrandomCodeGenerator(){
		String str = TinnyTools.randomCodeGenerator(6);
		System.out.println(str);
	}
	
	@Cacheable(key="#name",value="cacheTest")
	public String select(String name){
		return "1";
	}
	
	/*@Test
	public void testCache(){
		ToolsTest toolsTest = new ToolsTest();
		toolsTest.select("zks");
		Cache<Object, Object> cache = cacheManager.getCache("zks");
		System.out.println(cache);
	}*/
}
