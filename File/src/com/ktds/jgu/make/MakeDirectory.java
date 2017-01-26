package com.ktds.jgu.make;

import java.io.File;

public class MakeDirectory {

	public void start() {
		String directoryPath = "D:\\game";
		
		// 폴더 만들기
		File game = new File(directoryPath);
		
		// 폴더를 생성한다.(mkdir은 make directory 라는 뜻)
		if(!game.exists()) { // game이 존재하지 않는다면 만들어라.
			game.mkdir();
		}
		
	}
	
	public static void main(String[] args) {
		new MakeDirectory().start();
	}
}
