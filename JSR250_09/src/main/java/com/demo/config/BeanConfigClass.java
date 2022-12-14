package com.demo.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.demo.beans.DataBean1;
import com.demo.beans.DataBean2;
import com.demo.beans.TestBean1;
import com.demo.beans.TestBean2;
import com.demo.beans.TestBean3;
import com.demo.beans.TestBean4;
import com.demo.beans.TestBean5;
import com.demo.beans.TestBean6;

// @Configuration 은 beans.xml과 같은 역할이다.
// 빈등록을 위한 자바 파일이라는 뜻이다.
@Configuration
public class BeanConfigClass {

	@Bean(initMethod = "init1", destroyMethod = "destroy1")
	@Lazy
	public TestBean1 obj1() {
		return new TestBean1();
	}

	@Bean
	@Lazy
	public TestBean2 obj2() {
		return new TestBean2();
	}

	@Bean
	public DataBean1 data1() {
		return new DataBean1();
	}

	@Bean
	public DataBean2 data2() {
		return new DataBean2();
	}

//	앞으로 사라지니깐 앞으로는 클래스에서 바로 오토와이어드해라
	@Bean(autowire = Autowire.BY_NAME)
	public TestBean3 obj3() {
		return new TestBean3();
	}

	@Bean
	public TestBean4 obj4() {
		return new TestBean4();
	}

	@Bean
	public TestBean5 obj5() {
		return new TestBean5();

	}

	@Bean
	public TestBean6 obj6() {
		return new TestBean6();
	}

}
