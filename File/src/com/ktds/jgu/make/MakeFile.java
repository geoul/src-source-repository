package com.ktds.jgu.make;

import java.io.File;
import java.io.IOException;

public class MakeFile {

	public void start() {
		String filePath = "D:\\makeFile.txt";
		
		File textFile = new File(filePath);
		
		//예외처리
		try {
			//파일을 실제 저장소에 생성한다. (파일을 실제로 만들어 주는 것.)
			if(!textFile.exists()) { // textFile이 존재하지 않는다면 만들어라.
				textFile.createNewFile();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public static void main(String[] args) {
		new MakeFile().start();
	}
}
