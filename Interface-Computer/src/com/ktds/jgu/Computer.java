package com.ktds.jgu;

/**
 * 컴퓨터 Interface (입력, 계산, 저장)
 * @author Admin
 *
 */
public interface Computer {

	// 인터페이스는 형태만 있기 때문에 멤버변수가 없다.
	// 인터페이스도 객체화 시킬 수 없기 때문에, 구현체를 가지고 객체화 한다.
	public void input();
	
	public void compute();
	
	public void store();
	
}
