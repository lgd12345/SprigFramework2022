package com.demo.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.TestBean1;
import com.demo.beans.TestBean2;

public class mainClass {

	public static void main(String[] args) {
// beans.xml파일을 로딩한다.(필요한 객체들을 자동으로 생성함)

//		IoC : 객체를 자동으로 스프링 프레임워크에서 생성 하기때문에 제어역전(Inversion of Control)이라는 용어로 쓰인다.
		// IoC 종류 : BeanFactory, ApplicationContext

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/demo/config/beans.xml");

//		obj1 객체를 가져온다. ()
		TestBean1 obj1 = ctx.getBean("obj1", TestBean1.class);
		System.out.printf("obj1.data1  : %s\n", obj1.getData1());
		System.out.printf("obj1.data2  : %s\n", obj1.getData2());

		System.out.println("----------------------------------");
		System.out.println("이름으로 자동주입");
// 		obj2
		TestBean1 obj2 = ctx.getBean("obj2", TestBean1.class);
		System.out.printf("obj2.data1 : %s\n", obj2.getData1());
		System.out.printf("obj2.data2 : %s\n", obj2.getData2());
		System.out.println("----------------------------------");
		System.out.println("타입으로 자동주입");
//		obj3
		TestBean2 obj3 = ctx.getBean("obj3", TestBean2.class);
		System.out.printf("obj3.data1 : %s\n", obj3.getData1());
		System.out.printf("obj3.data2 : %s\n", obj3.getData2());
		System.out.println("---------------------------------------");
		System.out.println("생성자로 자동주입");
//		obj4
		TestBean2 obj4 = ctx.getBean("obj4", TestBean2.class);
		System.out.printf("obj4.data1 : %s\n", obj4.getData1());
		System.out.printf("obj4.data2 : %s\n", obj4.getData2());

		ctx.close();

	}

}
