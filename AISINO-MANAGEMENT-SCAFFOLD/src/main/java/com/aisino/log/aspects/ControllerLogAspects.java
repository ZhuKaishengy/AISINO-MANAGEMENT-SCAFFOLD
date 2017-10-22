package com.aisino.log.aspects;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
/**
 * controller aspects
 * @author Administrator
 *
 */
@Aspect
public class ControllerLogAspects {

	    private final static Logger logger = Logger.getLogger(ControllerLogAspects.class);
	    
	    //配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
	    @Pointcut("execution(* com.aisino.handler..*.*(..))")
	    public void aspect(){}
	    /*
	     * 配置前置通知,使用在方法aspect()上注册的切入点
	     * 同时接受JoinPoint切入点对象,可以没有该参数
	     */
	    @Before("aspect()")
	    public void before(JoinPoint joinPoint){
	    	MDC.put("module", "["+joinPoint.getTarget().getClass().getName() + "."  
	                + joinPoint.getSignature().getName() +"]");
			MDC.put("processType", "["+SecurityUtils.getSubject().getSession().getId().toString()+"]");
	    	String strLog = "==========================Once Request Begin=======================";
	        logger.info(strLog);  
	        
	        MDC.remove("processType");
			MDC.remove("module");
	    }
	    
	    //配置后置通知,使用在方法aspect()上注册的切入点
	    @After("aspect()")
	    public void after(JoinPoint joinPoint){
	    	MDC.put("module", "["+joinPoint.getTarget().getClass().getName() + "."  
	                + joinPoint.getSignature().getName() +"]");
			MDC.put("processType", "["+SecurityUtils.getSubject().getSession().getId().toString()+"]");
			
	    	String strLog = "==========================Once Request End==========================";   
	        logger.warn(strLog);
	        
	        MDC.remove("processType");
			MDC.remove("module");
	    }
}
