package com.demo.beans;

public class TestBean2 {

//	TestBean1은 객체타입 DataBean2 2개를 필드 변수로 입력 받는다.
	private DataBean2 data1;
	private DataBean2 data2;

//	기본생성자
	public TestBean2() {
		
	}
//	super생성자
	public TestBean2(DataBean2 data1, DataBean2 data2) {
		super();
		this.data1 = data1;
		this.data2 = data2;
	}
	
// 	get ,set 메소드 만들기	
	public DataBean2 getData1() {
		return data1;
	}

	public void setData1(DataBean2 data1) {
		this.data1 = data1;
	}

	public DataBean2 getData2() {
		return data2;
	}

	public void setData2(DataBean2 data2) {
		this.data2 = data2;
	}

}