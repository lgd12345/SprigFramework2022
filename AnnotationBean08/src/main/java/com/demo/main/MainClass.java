package com.demo.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.beans.TestBean1;
import com.demo.config.BeanConfigClass;

public class MainClass {

	public static void main(String[] args) {
// beans.xml파일을 로딩한다.(필요한 객체들을 자동으로 생성함)

//		IoC : 객체를 자동으로 스프링 프레임워크에서 생성 하기때문에 제어역전(Inversion of Control)이라는 용어로 쓰인다.
		// IoC 종류 : BeanFactory, ApplicationContext
	//	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/demo/config/beans.xml");
	//	ctx.close();
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
//		객체는 java1 하나만 만들어졌고 
//		객체 안에 데이터 3,4,5 번은 @Autowired로 자동주입이 이루어져 있다.(자동주입된 그 값을 부른 것임)
		System.out.println("+++++++++++++++++++++++++++++++");
		TestBean1 java1 = ctx.getBean("java1",TestBean1.class);
		System.out.printf("java1: %s\n",java1);
		
		System.out.printf("java1.data1: %d\n",java1.getData1());
		System.out.printf("java1.data2: %s\n",java1.getData2());
		System.out.printf("java1.data3: %s\n",java1.getData3());
		System.out.printf("java1.data4: %s\n",java1.getData4());
		System.out.printf("java1.data5: %s\n",java1.getData5());
		
		
		ctx.close();
	}

}
