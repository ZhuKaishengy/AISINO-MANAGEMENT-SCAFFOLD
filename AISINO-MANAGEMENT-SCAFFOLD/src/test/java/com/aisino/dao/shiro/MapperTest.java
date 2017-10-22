package com.aisino.dao.shiro;

import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aisino.domain.shiro.FilterChainDefinition;
import com.aisino.domain.shiro.Menu;
import com.aisino.domain.shiro.Permission;
import com.aisino.domain.shiro.Role;
import com.aisino.domain.shiro.RolePermission;
import com.aisino.domain.shiro.User;
import com.aisino.domain.shiro.UserRole;

@ContextConfiguration("file:src/main/resources/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MapperTest {

	@Autowired
	MenuMapper menuMapper;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	RoleMapper roleMapper;
	
	@Autowired
	UserRoleMapper userRoleMapper;
	
	@Autowired
	PermissionMapper permissionMapper;
	
	@Autowired
	RolePermissionMapper rolePermissionMapper;
	
	@Autowired
	FilterChainDefinitionMapper filterChainDefinitionMapper;
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Test
	public void testInsertUser(){
		User record = new User("test", "111");
		userMapper.insertSelective(record );
	}
	
	@Test
	public void testInsertRole(){
		Role record = new Role("test-role", "用于测试的角色");
		roleMapper.insertSelective(record);
	}
	
	@Test
	public void testInsertUserRole(){
		UserRole record = new UserRole("5B40D8C9-7EF1-494B-8347-6E6A77893FCF", "E406D07D-C999-4B46-A180-333F00E6B64C");
		userRoleMapper.insertSelective(record);
	}
	
	@Test
	public void testInsertPermission(){
		Permission record1 = new Permission("权限测试01", "table1:show");
		Permission record2 = new Permission("权限测试02", "table2:show");
		Permission record3 = new Permission("权限测试03", "table3:show");
		Permission record4 = new Permission("权限测试04", "table4:show");
		permissionMapper.insertSelective(record1);
		permissionMapper.insertSelective(record2);
		permissionMapper.insertSelective(record3);
		permissionMapper.insertSelective(record4);
	}
	@Test
	public void testInsertRolePermission(){
		//管理员（zks）
		RolePermission record1 = new RolePermission("68853654-52F1-4AD1-92C1-C924A6A8A82F", "29CA8C88-6C0D-4F92-B01E-4DE3A3D60828");
		RolePermission record2 = new RolePermission("68853654-52F1-4AD1-92C1-C924A6A8A82F", "3680EF64-CB84-4F26-A993-88B9F4222F5B");
		RolePermission record3 = new RolePermission("68853654-52F1-4AD1-92C1-C924A6A8A82F", "5A97FFAC-A2C9-41B3-8D5A-55B9653A8977");
		RolePermission record4 = new RolePermission("68853654-52F1-4AD1-92C1-C924A6A8A82F", "B505549C-D914-4FEC-923C-57AA91334067");
		//普通用户（sjx）
		RolePermission record5 = new RolePermission("FCFEB680-3247-4772-83D5-5889F5D8F3FC", "29CA8C88-6C0D-4F92-B01E-4DE3A3D60828");
		RolePermission record6 = new RolePermission("FCFEB680-3247-4772-83D5-5889F5D8F3FC", "B505549C-D914-4FEC-923C-57AA91334067");
		//测试用户(无权限，test)
		rolePermissionMapper.insertSelective(record1 );
		rolePermissionMapper.insertSelective(record2 );
		rolePermissionMapper.insertSelective(record3 );
		rolePermissionMapper.insertSelective(record4 );
		rolePermissionMapper.insertSelective(record5 );
		rolePermissionMapper.insertSelective(record6 );
	}
	/**
	 * ehcache 路径探索
	 */
	@Test
	public void testEhCache(){
//		String str = System.getProperty("java.io.tmpdir");
//		String str1 = System.getProperty("user.home");//C:\Users\Administrator
		String str2 = System.getProperty("user.dir");//C:\Users\Administrator\Workspaces\MyEclipse 2016 CI\AISINO-MANAGEMENT-SCAFFOLD

		System.out.println(str2);
	}
	
	@Test
	public void testSelectByUserPrincipal(){
		String str = userMapper.selectByUserPrincipal("zks");
		System.out.println(str);
	}
	/**
	 * 通过principal查询roles和permissions
	 */
	@Test
	public void testSelectByUserPrincipal2(){
		User user = userMapper.selectByPrincipalWithRP("testtest");
		if(user != null){
			List<Role> roles = user.getRoles();
			if(roles != null && roles.size() > 0){
				for (Role role : roles) {
					System.out.println(role.getRoleName());
					List<Permission> permissions = role.getPermissions();
					if(permissions != null && permissions.size() > 0){
						for (Permission permission : permissions) {
							System.out.println(permission.getPermissionUri());
						}
					}
				}
				
			}
		}
		
	}
	/**
	 *  /login.jsp=anon
		/unauthorizedUrl.jsp=anon
		/login=anon
		/logout=logout
		/list.jsp=roles[admin]
		/**=authc
	 */
	@Test
	public void testInsertFilterChainDefinitionBatch(){
		FilterChainDefinitionMapper mapper = sqlSession.getMapper(FilterChainDefinitionMapper.class);
		/*FilterChainDefinition record1 = new FilterChainDefinition("/**", "user");
		FilterChainDefinition record2 = new FilterChainDefinition("/safe/**", "authc");
		FilterChainDefinition record3 = new FilterChainDefinition("/login", "anon");
		FilterChainDefinition record4 = new FilterChainDefinition("/logout", "logout");*/
		FilterChainDefinition record5 = new FilterChainDefinition("/index.jsp", "anon");
		FilterChainDefinition record6 = new FilterChainDefinition("/login.jsp", "anon");
		/*mapper.insertSelective(record1);
		mapper.insertSelective(record2);
		mapper.insertSelective(record3);
		mapper.insertSelective(record4);*/
		mapper.insertSelective(record5);
		mapper.insertSelective(record6);
	}
	@Test
//	 List<LinkedHashMap<String, String>> selectAllOrderByIdDesc();
	public void testSelectAllOrderByIdDesc(){
		LinkedHashMap<String,String> map = new LinkedHashMap<String, String>();
		List<FilterChainDefinition> list = filterChainDefinitionMapper.selectAllOrderByIdDesc();
		for (FilterChainDefinition filterChainDefinition : list) {
			String uri = filterChainDefinition.getUri();
			String filter = filterChainDefinition.getFilter();
			map.put(uri, filter);
			
		}
		System.out.println(map);
		
	}
	
	@Test
	public void testSelectByUserPhone(){
		User user = userMapper.selectByUserPhone("13109894018");
		System.out.println(user.getUserCreditials());
		System.out.println(user.getUserPrincipal());
	}
	
	@Test
	public void testMenuInsert(){
		Menu record = new Menu(null, "icon-folder-open", "四级菜单", "1", null, "68853654-52F1-4AD1-92C1-C924A6A8A82F");
		menuMapper.insertSelective(record );
	}
}
