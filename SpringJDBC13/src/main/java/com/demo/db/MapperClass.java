package com.demo.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.demo.beans.JdbcBean;

// @Component 오토와이어드 쓸 수 있게
@Component
public class MapperClass implements RowMapper<JdbcBean> {

	@Override
	public JdbcBean mapRow(ResultSet rs, int rowNum) throws SQLException{
		// select문의 결과를 jdbcBean객체에 담을 수 있도록 설정함
		
		// jdbcmapper select는 다른 것과 달리 데이터를 가져오는 게 필요하다.)
		// mapper에서 select의 가져올 때 컬럼문의 기본값을 설정해준다.
		
		// select문의 데이터를 가져올 때 어떤 컬럼의 값을 bean 어디에 주입할 것인지 정해
		// 줘야하는데 이 역할을 하는 클래스를 mapper클래스라고 부른다.
		JdbcBean bean = new JdbcBean();
		bean.setInt_data(rs.getInt("int_data"));
		bean.setStr_data(rs.getString("str_data"));

		return bean;
	}
}
