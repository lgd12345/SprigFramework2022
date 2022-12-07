package com.demo.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

// @Configuration 은 beans.xml과 같은 역할이다.
// 빈등록을 위한 자바 파일이라는 뜻이다.
@Configuration
@ComponentScan(basePackages = { "com.demo.beans", "com.demo.db" })
public class BeanConfigClass {
	// DataSource 등록(DB주소,계정,비번)
	@Bean
	public BasicDataSource source() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName("oracle.jdbc.OracleDriver");
		source.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		source.setUsername("scott");
		source.setPassword("1234");

		return source;
	}
	// 데이터베이스에 접속해서 쿼리를 전달하는 빈을 등록한다.
	// (BasicDataSource source 여기에 위에꺼 내용 자동 주입됨)
	@Bean
	public JdbcTemplate db(BasicDataSource source) {
		JdbcTemplate db = new JdbcTemplate(source);
		return db;
	}
}
