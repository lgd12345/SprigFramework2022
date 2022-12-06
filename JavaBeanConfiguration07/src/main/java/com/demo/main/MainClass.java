package com.demo.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.TestBean1;
import com.demo.beans.TestBean2;
import com.demo.beans.TestBean3;
import com.demo.config.BeanConfigClass;

public class MainClass {

	public static void main(String[] args) {
// beans.xml파일을 로딩한다.(필요한 객체들을 자동으로 생성함)

//		IoC : 객체를 자동으로 스프링 프레임워크에서 생성 하기때문에 제어역전(Inversion of Control)이라는 용어로 쓰인다.
		// IoC 종류 : BeanFactory, ApplicationContext
	//	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/demo/config/beans.xml");
	//	ctx.close();
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		System.out.println("+++++++++++++++++++++++++++++++");
		TestBean1 java1 = ctx.getBean("java1",TestBean1.class);
		System.out.printf("+ java1 : %s\n", java1);
		
		TestBean1 java600 = ctx.getBean("java600",TestBean1.class);
		System.out.printf("+ java600 : %s\n", java600);
		
//		Lazy 부를 때 객체 한번만 생성됨
		TestBean2 java2 = ctx.getBean("java2",TestBean2.class);
		System.out.printf("+ java2 : %s\n", java2);
		TestBean2 java2_1 = ctx.getBean("java2",TestBean2.class);
		System.out.printf("+ java2_1 : %s\n", java2_1);
		
//		prototype 부를 때마다 새로운 객체 생성됨
		TestBean3 java3 = ctx.getBean("java3",TestBean3.class);
		System.out.printf("+ java3 prototype : %s\n", java3);
		TestBean3 java3_1 = ctx.getBean("java3",TestBean3.class);
		System.out.printf("+ java3_1 prototype : %s\n", java3_1);
		
		ctx.close();
	}

}
