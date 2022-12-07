package com.demo.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.beans.JdbcBean;
import com.demo.config.BeanConfigClass;
import com.demo.mapper.MapperInterface;

public class MainClass {
// ctrl + shift + o == 자동 import 정리 해줌

	public static void main(String[] args) {

//		IoC : 객체를 자동으로 스프링 프레임워크에서 생성 하기때문에 제어역전(Inversion of Control)이라는 용어로 쓰인다.
		// IoC 종류 : BeanFactory, ApplicationContext
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);

		MapperInterface mapper = ctx.getBean("test_mapper", MapperInterface.class);

		// insert 입력
		JdbcBean bean2 = new JdbcBean();
		bean2.setInt_data(100);
		bean2.setStr_data("문자열100");
		mapper.insert_data(bean2);

		// select 조회
		List<JdbcBean> list1 = mapper.select_data();
		for (JdbcBean bean1 : list1) {
			System.out.printf("int_data : %d\n", bean1.getInt_data());
			System.out.printf("str_data : %s\n", bean1.getStr_data());
			System.out.println("--------------------------------------");
		}
		// update
		JdbcBean bean4 = new JdbcBean();
		bean4.setInt_data(100);
		bean4.setStr_data("문자열300");
		mapper.update_data(bean4);

		// delete
		mapper.delete_data(100);

		ctx.close();

	}

}
