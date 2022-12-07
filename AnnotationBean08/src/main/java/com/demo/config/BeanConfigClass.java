package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.beans.DataBean1;
import com.demo.beans.DataBean2;
import com.demo.beans.TestBean1;

// @Configuration 은 beans.xml과 같은 역할이다.
// 빈등록을 위한 자바 파일이라는 뜻이다.
@Configuration
public class BeanConfigClass {

//  java1()이라는 객체로 등록해줌
	@Bean
	public TestBean1 java1() {
		// TestBean1 t1 = new TestBean1();
		// return t1;
		return new TestBean1();
	}

	// DataBean1 타입 data_bean1 등록
	@Bean
	public DataBean1 data_bean1() {
		return new DataBean1();
	}

	// DataBean2 obj4와 ojb5 등록
	@Bean
	public DataBean2 obj4() {
		return new DataBean2();
	}

	@Bean
	public DataBean2 obj5() {
		return new DataBean2();
	}

}
