package demo.main;

import demo.beans.HelloWorld;
import demo.beans.HelloWorldEn;
import demo.beans.HelloWorldKo;

public class MainClass {

	public static void main(String[] args) {
		// 메인클래스의 메소드 콘솔에 실행
		
		HelloWorld hello1 = new HelloWorldEn();
//		hello1.sayHello();
		callMethod(hello1);
		
		HelloWorldKo hello2 = new HelloWorldKo();
		hello2.sayHello();

	}
	
//	public static void callMethod(HelloWorldEn hello) {
//		hello.sayHello();
//	}
	
	public static void callMethod(HelloWorld hello) {
		hello.sayHello();
	}

}
