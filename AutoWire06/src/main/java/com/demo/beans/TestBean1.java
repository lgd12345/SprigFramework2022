package com.demo.beans;

public class TestBean1 {

//	TestBean1은 객체타입 DataBean1 2개를 필드 변수로 입력 받는다.
	private DataBean1 data1;
	private DataBean1 data2;

// 	get ,set 메소드 만들기
	public DataBean1 getData1() {
		return data1;
	}

	public void setData1(DataBean1 data1) {
		this.data1 = data1;
	}

	public DataBean1 getData2() {
		return data2;
	}

	public void setData2(DataBean1 data2) {
		this.data2 = data2;
	}

}