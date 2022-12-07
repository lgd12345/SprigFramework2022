package com.demo.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.TestBean;
import com.demo.config.BeanConfigClass;

public class MainClass {
// ctrl + shift + o == 자동 import 정리 해줌

	public static void main(String[] args) {
// beans.xml파일을 로딩한다.(필요한 객체들을 자동으로 생성함)

//		IoC : 객체를 자동으로 스프링 프레임워크에서 생성 하기때문에 제어역전(Inversion of Control)이라는 용어로 쓰인다.
		// IoC 종류 : BeanFactory, ApplicationContext
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);

		TestBean java1 = ctx.getBean(TestBean.class);

		java1.method1();
		

		ctx.close();

	}

}
