package com.demo.advisor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// @Aspect AOP 작성을 위한 어노테이션
@Aspect
@Component
public class AdvisorClass {

	@Before("execution(* method1())")
	public void beforeMethod() {
		System.out.println("beforeMethod 호출");
	}

	@After("execution(* method1())")
	public void afterMethod() {
		System.out.println("afterMethod 호출");
	}

//	before, after사이에 들어감
	@Around("execution(* method1())")
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("aroundMethod 호출1");

		// 원래의 메서드를 호출한다.
		Object obj = pjp.proceed();

		System.out.println("aroundMethod 호출 2");

		return obj;
	}
}
