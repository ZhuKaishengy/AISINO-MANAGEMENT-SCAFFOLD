package com.aisino.handler.shiro;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aisino.domain.shiro.Menu;
import com.aisino.domain.shiro.User;
import com.aisino.service.shiro.MenuService;
import com.aisino.service.shiro.UserService;
import com.aisino.system.CommonConstant;
import com.aisino.to.shiro.Msg;
import com.aisino.token.shiro.LoginToken;
import com.aisino.utils.shiro.TinnyTools;
/**
 * 
 * @ClassName: ShiroController
 * @Description: 用于Shiro认证授权的controller
 * @author ZhuKaishengy
 * @date 2017年8月26日 下午2:15:42
 */
@Controller
@RequestMapping("/shiro")
public class ShiroController {

	
	Logger logger = Logger.getLogger(ShiroController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	MenuService menuService;
	
	private Cache<String, AtomicInteger> loginWithoutPasswordCache;  //创建缓存的对象  
	
	public ShiroController(CacheManager cacheManager) {
		super();
		// TODO Auto-generated constructor stub
		loginWithoutPasswordCache = cacheManager.getCache("loginWithoutPassword");  //创建缓存的对象  
	}

	/**
	 * @Title      : validatePrincipalAjax 
	  * @Description: 登陆时用户名ajax校验
	  * @return     : Msg
	  * @author     : ZhuKaishengy
	  * Create Date : 2017年8月26日 下午2:03:13
	  * @throws
	 */
	@ResponseBody
	@RequestMapping(value="/validatePrincipalAjax",method=RequestMethod.GET)
	public Msg validatePrincipalAjax(@RequestParam("userPrincipal") String userPrincipal,HttpServletResponse response){
		//设置响应头使得此Controller支持ajax跨域请求
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","GET");
		
		logger.info("从页面获取userPrincipal:"+userPrincipal);
		
		String reg = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
		boolean flag = false;
		String errorInfo = "";
		if(!(userPrincipal.matches(reg))){
			errorInfo = "userPrincipal不符合正则表达式";
			logger.info("userPrincipal不符合正则表达式");
		}else{
			flag = userService.selectWhetherValidPrincipal(userPrincipal);
			errorInfo = "此用户名没有被注册！";
			logger.info("service层验证结果："+flag);
		}
		if(flag){
			return Msg.success();
		}
		return Msg.fail().add("errorInfo", errorInfo);
	}
	
//	==================shiro认证=======================
	
	@ResponseBody
	@RequestMapping(value="/login" ,method = RequestMethod.GET)
	public Msg login(@Valid User user,BindingResult bindingResult,@RequestParam(value="remember",required=false) String remember,
			@RequestParam(value="identitiCode" , required = false) String identitiCode){
		
		Subject subject = SecurityUtils.getSubject();
		
		if(!(subject.isAuthenticated() || subject.isRemembered())){
			logger.info("没有被认证也不是通过记住我登陆的用户，开始认证");
			LoginToken token = null;
			if(user.getUserPhone()!=null && identitiCode != null){
				token = new LoginToken(user.getUserPrincipal(), user.getUserCreditials(), "1", user.getUserPhone(), identitiCode);
				logger.info("此用户采用免密登陆！"+"\n"+"UserPhone:" +user.getUserPhone()+"\n"+"验证码:" +identitiCode);
			}else{
				token = new LoginToken(user.getUserPrincipal(), user.getUserCreditials(), "0", user.getUserPhone(), identitiCode);
				logger.info("此用户采用普通登陆！"+"\n"+"从页面获取的登录信息：username:"+user.getUserPrincipal()+"\n"+"password:" +user.getUserCreditials());
			}
			//设置记住我
			if("1".equals(remember)){
				token.setRememberMe(true);
				logger.info("设置记住我");
			}else{
				token.setRememberMe(false);
				logger.info("不设置记住我");
			}
			//定义 所有错误信息结果集
			Map<String, String> resultMap = null;
			try {
				logger.info("尝试通过LoginToken登陆");
				resultMap = TinnyTools.wrapperBindingResult(bindingResult);
				if(resultMap != null && resultMap.size() > 0){
					logger.info("hibernate-validator 验证失败！");
					return Msg.fail().add("resultMap", resultMap);
				}
				subject.login(token);
				logger.info("认证通过,跳转主页面");
				subject.getSession().setAttribute("currentUser", user);
				return Msg.success();
			} catch (LockedAccountException e) {
				// TODO Auto-generated catch block
				resultMap.put("Exception", "用户被锁定！");
				logger.error("LockedAccountException");
			} catch (UnknownAccountException e) {
				// TODO: handle exception
				resultMap.put("Exception", "用户名不存在！");
				logger.error("UnknownAccountException");
			} catch (IncorrectCredentialsException e) {
				// TODO: handle exception
				resultMap.put("Exception", "密码不正确！");
				logger.error("IncorrectCredentialsException");
			} catch (ExpiredCredentialsException e) {
				// TODO: handle exception
				resultMap.put("Exception", "密码过期！");
				logger.error("ExpiredCredentialsException");
			} catch (AuthenticationException e) {
				// TODO: handle exception
				resultMap.put("Exception", "认证不成功！");
				logger.error("AuthenticationException");
			}
			return Msg.fail().add("resultMap", resultMap);
		}
		
		return Msg.success();
	}
	
	@RequestMapping("/main")
	public String main(Map<String, Object> map){
		List<Menu> oneLevelMenu = menuService.getMenuListByUpId(null);
		map.put("menuList", oneLevelMenu);
		logger.info("跳转主页面，请求域中key=menuList，value="+oneLevelMenu);
		return "shiro/main";
	}
	
	@RequestMapping("/indexPage")
	public String indexPage(){
		
		logger.info("跳转主页面");
		return "shiro/indexPage";
	}
	
	@RequestMapping("/lock")
	public String lock(){
		
		logger.info("进入锁屏页面");
		
		return "shiro/extra_lock";
	}

	@RequestMapping("/test")
	public String test(){
		logger.info("进入test页面");
		return "shiro/test";
	}
	/**
	 * 	@Title      : sendMessage 
	  * @Description: 发送手机短信验证码
	  * @param userNumber 要群发短信的手机号
	  * @return     : int
	  * @author     : ZhuKaishengy
	  * Create Date : 2017年8月29日 上午11:38:53
	  * @throws
	 */
	@ResponseBody
	@RequestMapping("/sendIdentitiCode")
	public Msg sendIdentitiCode(@RequestParam("userPhone") String userPhone) {
		
		String identitiCode = TinnyTools.randomCodeGenerator(6);
		String messageContent = "你的验证码是"+identitiCode+"，此验证码用于登陆"+CommonConstant.SYSTEMNAME+"或重置密码，10分钟内有效。";
		String serialNumber = TinnyTools.randomCodeGenerator(20);
		
		//将生成的验证码加入缓存中
		AtomicInteger atomicInteger = new AtomicInteger(Integer.parseInt(identitiCode));
		loginWithoutPasswordCache.put(userPhone, atomicInteger);
		logger.info("验证码已生成，放入ehcache中：key="+userPhone+"\n"+"value="+atomicInteger);
		
		logger.info("发送短信start！");
		int isSuc = 1;

		// 定义httpClient的实例
		HttpClient httpclient = new HttpClient();

		// 创建post方法实例
		PostMethod postMethod = new PostMethod(CommonConstant.SMSURL);
		try {
			// 执行post方法
			postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");
			// 企业编号
			postMethod.setParameter("SpCode", CommonConstant.SMSSPCODE);
			// 用户名称
			postMethod.setParameter("LoginName", CommonConstant.SMSLOGINNAME);
			// 用户密码
			postMethod.setParameter("Password", CommonConstant.SMSPASSWORD);
			// 短信内容,
			// 最大402个字或字符（短信内容要求的编码为gb2312或gbk），短信发送必须按照短信模板，否则就会报模板不符，短信模板说明见3.1.1。
			// postMethod.setParameter("MessageContent",
			// "你有一项编号为123456789的事务需要处理。");
			postMethod.setParameter("MessageContent", messageContent);
			// 手机号码(多个号码用”,”分隔)，最多1000个号码
			postMethod.setParameter("UserNumber", userPhone);
			// postMethod.setParameter("UserNumber", "13889237691");
			// 流水号，20位数字，每个请求流水号要求唯一（规则自定义,建议时间格式精确到毫秒）必填参数，与回执接口中的流水号一一对应，不传后面回执接口无法查询数据
			postMethod.setParameter("SerialNumber", serialNumber);
			// 预约发送时间，格式:yyyyMMddHHmmss,如‘20090901010101’，立即发送请填空（预约时间要写当前时间5分钟之后的时间，若预约时间少于5分钟，则为立即发送。）
			// postMethod.setParameter("ScheduleTime", "");
			// 接入号扩展号（默认不填，扩展号为数字，扩展位数由当前所配的接入号长度决定，整个接入号最长20位）
			// postMethod.setParameter("ExtendAccessNum", "");
			// 提交时检测方式
			// 1 --- 提交号码中有效的号码仍正常发出短信，无效的号码在返回参数faillist中列出
			// 不为1 或该参数不存在 --- 提交号码中只要有无效的号码，那么所有的号码都不发出短信，所有的号码在返回参数faillist中列出
			// postMethod.setParameter("f", "1");

			int statusCode = httpclient.executeMethod(postMethod);
			if (statusCode != HttpStatus.SC_OK) {
				logger.info("连接短信服务器失败！返回码为[statusCode:" + statusCode + "]");
			}
			String rtn = new String(postMethod.getResponseBody(),"gbk");
			logger.info("短信服务返回的结果为 " + rtn);
			String result = "";
			String description = "";
			String[] s = rtn.split("&");
			for (String temp : s) {
				String[] ss = temp.split("=");
				if ("result".equals(ss[0])) {
					result = ss[1];
				} else if ("description".equals(ss[0])) {
					description = ss[1];
				}
			}
			if ("0".equals(result)) {
				logger.info("短信发送成功！");
			} else {
				isSuc = 0;
				logger.info("短信发送失败！");
				logger.info("短信服务器返回状态码为" + result);
				logger.info("短信服务器返回错误描述为" + description);
			}
		} catch (HttpException e) {
			isSuc = 0;
			logger.error("短信发送失败！", e);
		} catch (IOException e) {
			isSuc = 0;
			logger.error("短信发送失败！", e);
		} catch (Exception e) {
			isSuc = 0;
			logger.error("短信发送失败！", e);
		} finally {
			postMethod.releaseConnection();
			logger.info("发送短信end！");
		}
		return isSuc == 1 ? Msg.success():Msg.fail();
	}
	
	/**
	 * 	@Title      : comparePasswordForCurrentLogin 
	  * @Description: TODO(屏幕锁定时，用于比较当前登陆的用户密码是不是转正确)
	  * @return     : Msg
	  * @author     : ZhuKaishengy
	  * Create Date : 2017年9月3日 下午4:46:11
	  * @throws
	 */
	@ResponseBody
	@RequestMapping("/comparePass")
	public Msg comparePasswordForCurrentLogin(@RequestParam("userCreditials") String userCreditials){
		User currentUser = (User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		String standard = currentUser.getUserCreditials();
		if(standard.equals(userCreditials)){
			return Msg.success();
		}
		return Msg.fail().add("response_message", "密码不正确！");
	}
	
	@ResponseBody
	@RequestMapping("/getMenuList")
	public Msg getMenuListByUpId(@RequestParam(value="upId") String upId){
		List<Menu> menuList = menuService.getMenuListByUpId(upId);
		logger.info("根据upId="+upId+",获取menuList="+menuList);
		return Msg.success().add("menuList", menuList);
	}
	
	/**
	 * 菜单栏管理
	 * @return
	 */
	@RequestMapping("/shiro/menuManage")
	public String menuManage(){
		
		return "shiro/menuManage";
	}
}
