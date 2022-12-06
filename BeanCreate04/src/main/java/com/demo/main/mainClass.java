package com.demo.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.TestBean;

public class mainClass {

	public static void main(String[] args) {
// beans.xml파일을 로딩한다.(필요한 객체들을 자동으로 생성함)

//		IoC : 객체를 자동으로 스프링 프레임워크에서 생성 하기때문에 제어역전(Inversion of Control)이라는 용어로 쓰인다.
		// IoC 종류 : BeanFactory, ApplicationContext

//		싱글턴타입 : 딱 한 번 만 생성함 beans.xml에서 ("com/demo/config/beans.xml"); id="t1"이라고 해줬던 게 생성됨
//		불러올 때 생성했던 것을 가져옴
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/demo/config/beans.xml");

// 		t0는 id가 없으므로 클래스의 타입만 가지고 객체를 가져올 수 있다.
// 		그러나!! 같은 타입이 2개 이상 있으면 못 가져옴 어떤걸 가져와야 하는 지 모름 에러
//		TestBean t0 = ctx.getBean(TestBean.class);
//		System.out.printf("test0  : %s\n",t0);
		
//		id가 있을 때 id로 가져온다. ("test0",)
		TestBean t0 = ctx.getBean("test0",TestBean.class);
		System.out.printf("test0  : %s\n", t0);		
		
		
//		id가 있을 때 id로 가져온다..
		TestBean t1 = ctx.getBean("test1",TestBean.class);
		System.out.printf("t1  : %s\n", t1);
		
//		id가 있을 때 id로 가져온다.. t1과 t2는 같은 id 를 사용한다. (같은 객체)
		TestBean t2 = ctx.getBean("test1",TestBean.class);
		System.out.printf("t2  : %s\n", t2);
		
//		lazy - init은 객체를 가져올 때 생성한다.
		TestBean t3 = ctx.getBean("test2",TestBean.class);
		System.out.printf("t3  : %s\n", t3);
		
//		scope==prototype는 객체를 가져올 때 마다 생성한다.
		TestBean t4 = ctx.getBean("test3",TestBean.class);
		System.out.printf("t4  : %s\n", t4);
		TestBean t5 = ctx.getBean("test3",TestBean.class);
		System.out.printf("t5  : %s\n", t5);
		

		ctx.close();

	}

}
