package com.demo.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.demo.beans.JdbcBean;

@Component
public class JdbcDAO {

	@Autowired
	private JdbcTemplate db;
	
	@Autowired
	private MapperClass mapper;

	// 저장
	// 리턴이 없는 입력,삭제,업데이트는 update사용
	public void insert_data(JdbcBean bean) {
		String sql = "insert into jdbc_table (int_data, str_data) values (?, ?)";
		db.update(sql, bean.getInt_data(), bean.getStr_data());
	}

	// 가져오기
	// query메소드 사용 mapper가 필요
	public List<JdbcBean> select_data() {
		String sql = "select int_data, str_data from jdbc_table";
		List<JdbcBean> list = db.query(sql, mapper);
		return list;
	}
	//한줄만 가져오기
	public List<JdbcBean> select_data(int int_data){
		String sql = "select int_data, str_data from jdbc_table where int_data = ?";
		List<JdbcBean> one = db.query(sql, mapper, int_data);
		return one;
	}

	// 수정
	public void update_data(JdbcBean bean) {
		String sql = "update jdbc_table set str_data = ? where int_data = ?";
		db.update(sql, bean.getStr_data(), bean.getInt_data());

	}

	// 삭제
	public void delete_data(int int_data) {
		String sql = "delete from jdbc_table where int_data = ?";
		db.update(sql, int_data);
	}

}
