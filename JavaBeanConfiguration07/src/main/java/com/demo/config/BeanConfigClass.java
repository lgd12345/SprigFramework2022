package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.demo.beans.TestBean1;
import com.demo.beans.TestBean2;
import com.demo.beans.TestBean3;
import com.demo.beans.TestBean4;

// @Configuration 은 beans.xml과 같은 역할이다.
// 빈등록을 위한 자바 파일이라는 뜻이다.
@Configuration
public class BeanConfigClass {
	
//  java1()이라는 객체로 등록해줌
	@Bean
	public TestBean1 java1() {
		//TestBean1 t1 = new TestBean1();
		//return t1;
		return new TestBean1();
	}
	
//  이름을 설정 해줄 수 있다. 부를 때 java600 이걸로 불러야 한다.
	@Bean(name = "java600")
	public TestBean1 java500() {
		return new TestBean1();
	}
//	부를 때 객체 한번만 생성됨
	@Bean
	@Lazy
	public TestBean2 java2() {
		return new TestBean2();
	}
//	부를 때마다 새로운 객체 생성됨
	@Bean
	@Scope("prototype")
	public TestBean3 java3() {
		return new TestBean3();
	}
	// TestBean4
	@Bean
	public TestBean4 java4() {
		return new TestBean4();
	}
	// TestBean4 위와 타입이 같다.
//	이름으로 객체를 가져오면 문제 없는데 타입으로 가져오면 에러가 날 수 있다.
//  타입이 같을 때 Primary를 가지고 있는 애가 우선권을 가지고 있어서 에러가 나지 않는다.
	@Bean
	@Primary
	public TestBean4 java5() {
		return new TestBean4();
	}

}
