package com.ktds.jgu.make;

import java.io.File;

public class MakeDirectories {

	public void start() {
		String directoryPath = "D:\\game\\mobile\\poketmon\\go";
		
		// 폴더 만들기
		File game = new File(directoryPath);
		
		// 폴더를 생성한다.(mkdir은 마지막에 위치한 go라는 폴더를 만들어야 하는데, 
		//poketmon이라는 폴더까지 기존에 존재해야 한다.)
		// mkdirs를 하면 마지막에 있는 폴더까지 다 만들어진다.
		if(!game.exists()) { // game이 존재하지 않는다면 만들어라.
			game.mkdirs();
		}
		
	}
	
	public static void main(String[] args) {
		new MakeDirectories().start();
	}
}
