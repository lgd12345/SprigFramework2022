package com.demo.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.beans.JdbcBean;
import com.demo.config.BeanConfigClass;
import com.demo.db.JdbcDAO;

public class MainClass {
// ctrl + shift + o == 자동 import 정리 해줌

	public static void main(String[] args) {

//		IoC : 객체를 자동으로 스프링 프레임워크에서 생성 하기때문에 제어역전(Inversion of Control)이라는 용어로 쓰인다.
		// IoC 종류 : BeanFactory, ApplicationContext
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);

		// dao를 가져온다.
		JdbcDAO dao = ctx.getBean(JdbcDAO.class);

// insert
//		JdbcBean bean1 = new JdbcBean();
//		bean1.setInt_data(1);
//		bean1.setStr_data("문자열1");
//		dao.insert_data(bean1);

		// 가져와서 출력하기 select
		List<JdbcBean> list = dao.select_data();

		for (JdbcBean bean : list) {
			System.out.printf("int_data : %d\n", bean.getInt_data());
			System.out.printf("str_data : %s\n", bean.getStr_data());
			System.out.println("----------------------------------------");
		}

		// 가져와서 출력하기 select
		List<JdbcBean> one = dao.select_data(1);

		for (JdbcBean bean : one) {
			System.out.printf("int_data : %d\n", bean.getInt_data());
			System.out.printf("str_data : %s\n", bean.getStr_data());
			System.out.println("----------------------------------------");
		}
		// update
		JdbcBean bean4 = new JdbcBean();
		bean4.setInt_data(1);
		bean4.setStr_data("문자열3");
		dao.update_data(bean4);
//
		List<JdbcBean> one2 = dao.select_data(1);

		for (JdbcBean bean : one2) {
			System.out.printf("int_data : %d\n", bean.getInt_data());
			System.out.printf("str_data : %s\n", bean.getStr_data());
			System.out.println("----------------------------------------");
		}
		// delete
//		dao.delete_data(1);

		ctx.close();

	}

}
