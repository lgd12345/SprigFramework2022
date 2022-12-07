package com.demo.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.TestBean;

public class MainClass {
// ctrl + shift + o == 자동 import 정리 해줌

	public static void main(String[] args) {
// beans.xml파일을 로딩한다.(필요한 객체들을 자동으로 생성함)

//		IoC : 객체를 자동으로 스프링 프레임워크에서 생성 하기때문에 제어역전(Inversion of Control)이라는 용어로 쓰인다.
		// IoC 종류 : BeanFactory, ApplicationContext
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/demo/config/beans.xml");

		TestBean bean1 = ctx.getBean("xml1", TestBean.class);

//		bean1.method1();
		
//		어라운드가 있으면 어라운드가 적용시 안에서 같이 가져옴 호출될 때 TestBean에 return 값이 있을 경우에는 리턴값이 같이 적용된다.
		System.out.printf("bean1.method1() : %d\n", bean1.method1());

		ctx.close();

	}

}
