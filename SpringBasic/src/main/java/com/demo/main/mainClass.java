package com.demo.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.HelloWorld;

public class mainClass {

	public static void main(String[] args) {
// beans.xml파일을 로딩한다.(필요한 객체들을 자동으로 생성함)
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("com/demo/config/beans.xml");
//	빈 객체 사용 하는 것을 스프링 프레임 워크에서 관리해줌
//		가져왔을 때 타입을 바꿔줌 hello1: 오브젝트(HelloWorld)가져와서 타입바꿈/
//							hello2: 매개변수로 타입을 변환후 가져옴
		
//		IoC : 객체를 자동으로 스프링 프레임워크에서 하기때문에 제어역전(Inversion of Control)이라는 용어로 쓰인다.
		// IoC 종류 : BeanFactory, ApplicationContext
		HelloWorld hello1 = (HelloWorld)ctx.getBean("hello");
		callMethod(hello1);
		
		HelloWorld hello2 = ctx.getBean("hello", HelloWorld.class);
		callMethod(hello2);
		
	ctx.close();
	
	}
	
	public static void callMethod(HelloWorld hello) {
		hello.sayHello();
	}

}
