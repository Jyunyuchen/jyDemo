package com.example.demo.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	
	@Autowired
	HttpServletRequest request;
	
	//任意返回類型 com.example.demo.controller下的任意類任意方法任意參數
	@Pointcut("execution(* com.example.demo.controller.*.*(..))")
	public void log() {}
	
	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("訪問的Url:" + request.getRequestURI().toString());
		System.out.println("訪問的Ip:" + request.getRemoteAddr());
		System.out.println("訪問的Class名稱:" + joinPoint.getSignature().getDeclaringTypeName());
		System.out.println("訪問的Method名稱:" + joinPoint.getSignature().getName());
		System.out.println("參數:" + Arrays.toString(joinPoint.getArgs()));

	}

}
