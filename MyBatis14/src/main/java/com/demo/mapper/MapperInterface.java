package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.demo.beans.JdbcBean;

public interface MapperInterface {
	//crud 및 커스텀 sql문을 여기서 설정해준다.
	
	
	/*
	 * 만약 빈의 변수명(property)과 테이블 컬럼의 이름이 다르다면 여기에 설정한다.
	@Results({
		@Result(column = "int_data", property = "int_data"),
		@Result(column = "str_data", property = "str_data")
	})
	*/
	
	// 복잡한 sql문이라면 .xml에 적을 수 있다.
	
	//조회
	@Select("select int_data, str_data from jdbc_table")
	List<JdbcBean> select_data();
	
	//입력
	// bean의 값이 맞으면 들어감, 변수 : #{int_data}, #{str_data}
	@Insert("insert into jdbc_table(int_data, str_data) values (#{int_data}, #{str_data})")
	void insert_data(JdbcBean bean);
	
	@Update("update jdbc_table set str_data = #{str_data} where int_data = #{int_data}")
	void update_data(JdbcBean bean);
	
	// 값이 하나 밖에 없을 경우 int_data 이름이 같지 않아도 변수에 그냥 바로 들어감
	@Delete("delete from jdbc_table where int_data = #{abc}")
	void delete_data(int int_data);
	
}
