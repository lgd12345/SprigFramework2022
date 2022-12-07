package com.demo.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.beans.TestBean1;
import com.demo.beans.TestBean2;
import com.demo.beans.TestBean3;
import com.demo.beans.TestBean4;
import com.demo.beans.TestBean5;
import com.demo.beans.TestBean6;
import com.demo.config.BeanConfigClass;

public class MainClass {
// ctrl + shift + o == 자동 import 정리 해줌
	
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
		TestBean1 obj1 = ctx.getBean("obj1", TestBean1.class);
		TestBean2 obj2 = ctx.getBean("obj2", TestBean2.class);
		System.out.println("---------------------------------");
		
		TestBean3 obj3 = ctx.getBean("obj3", TestBean3.class);
		System.out.printf("obj3.data1 : %s\n", obj3.getData1());
		System.out.printf("obj3.data2 : %s\n", obj3.getData2());
		
		System.out.println("----------------------------------------");
		
		TestBean4 obj4 = ctx.getBean("obj4", TestBean4.class);
		System.out.printf("obj4.data1 : %s\n", obj4.getData1());
		System.out.printf("obj4.data2 : %s\n", obj4.getData2());
		
		System.out.println("-------------------------------------------");
		
		TestBean5 obj5 = ctx.getBean("obj5", TestBean5.class);
		System.out.printf("obj5.data1 : %s\n", obj5.getData1());
		System.out.printf("obj5.data2 : %s\n", obj5.getData2());
		
		System.out.println("------------------------------------------");
		
		TestBean6 obj6 = ctx.getBean("obj6", TestBean6.class);
		System.out.printf("obj6.data100 : %s\n", obj6.getData100());
		System.out.printf("obj6.data200 : %s\n", obj6.getData200());


		
		
		ctx.close();
	}

}
