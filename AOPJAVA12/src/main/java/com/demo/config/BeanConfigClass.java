package com.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// @Configuration 은 beans.xml과 같은 역할이다.
// 빈등록을 위한 자바 파일이라는 뜻이다.
@Configuration
//지정된 패키지의 Bean 클래스들의 어노테이션을 분석하여 Bean을 등록하라고 지정한다.
@ComponentScan(basePackages = {"com.demo.beans","com.demo.advisor"})
@EnableAspectJAutoProxy
public class BeanConfigClass {

}
