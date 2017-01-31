package com.ktds.jgu;

public class ExtendsTest {

	public void start() {
		String str1 = new String("Extends test..."); //원래는 이런 형태로 사용해야 되는데 단축형으로 아래 형태로 많이 사용한다.
		String str = "Extends test...";
		
		Object obj = new String(str);
		//String() 이라는 클래스는 Object를 상속 받았기 때문에 이런 형태로 사용할 수 있다.
		
		System.out.println(obj);
	}
	
	public static void main(String[] args) {
		ExtendsTest extendsTest = new ExtendsTest();
		extendsTest.start();
		extendsTest.equals("");
		// equals()는 public과 protected만 사용할 수 있다.
		// protected는 상속 관계에서만 사용할 수 있는 접근제시자이다.
		
		
	}
}
