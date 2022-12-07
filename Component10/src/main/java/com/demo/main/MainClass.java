package com.demo.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.beans.TestBean1;
import com.demo.beans.TestBean2;
import com.demo.beans2.TestBean3;
import com.demo.beans2.TestBean4;
import com.demo.beans3.TestBean5;
import com.demo.config.BeanConfigClass;

public class MainClass {
// ctrl + shift + o == 자동 import 정리 해줌

	public static void main(String[] args) {
// beans.xml파일을 로딩한다.(필요한 객체들을 자동으로 생성함)

//		IoC : 객체를 자동으로 스프링 프레임워크에서 생성 하기때문에 제어역전(Inversion of Control)이라는 용어로 쓰인다.
		// IoC 종류 : BeanFactory, ApplicationContext
		// ClassPathXmlApplicationContext ctx = new
		// ClassPathXmlApplicationContext("com/demo/config/beans.xml");
		// ctx.close();
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);

//		객체는 java1 하나만 만들어졌고 
//		객체 안에 데이터 3,4,5 번은 @Autowired로 자동주입이 이루어져 있다.(자동주입된 그 값을 부른 것임)
		System.out.println("+++++++++++++++++++++++++++++++");

		TestBean1 java1 = ctx.getBean(TestBean1.class);
		System.out.printf("java1 : %s\n", java1);

		TestBean2 java2 = ctx.getBean("java2", TestBean2.class);
		System.out.printf("java2 : %s\n", java2);

		TestBean2 java3 = ctx.getBean("java3", TestBean2.class);
		System.out.printf("java3 : %s\n", java3);

		System.out.println("-------------------------------");

		TestBean3 java4 = ctx.getBean(TestBean3.class);
		System.out.printf("java4 : %s\n", java4);

		TestBean4 java5 = ctx.getBean("bean4", TestBean4.class);
		System.out.printf("java5 : %s\n", java5);

		TestBean4 java100 = ctx.getBean("java100", TestBean4.class);
		System.out.printf("java100 : %s\n", java100);

		TestBean4 java200 = ctx.getBean("java200", TestBean4.class);
		System.out.printf("java200 : %s\n", java200);

		System.out.println("-------------------------------");

		TestBean5 java500 = ctx.getBean(TestBean5.class);
		System.out.printf("java500 : %s\n", java500);

		ctx.close();
	}

}
