package com.ktds.jgu.explore;

import java.io.File;

public class FileSystemExplore3 {

	public void printFileSystem(String path) {
		
		// 1. File 객체 생성 (Path 정보를 가지는 파일을 만듬)
		File directory = new File(path);
		
		// 1-1. directory 안의 내용을 탐색한다.
		String[] contents = directory.list();
		File file = null; 
		// 반복문 안에서 선언하는 것은 피한다.
		// 레퍼런스 타입의 초기값은 null이다.
		for( String content : contents ) { 
			// content와 directory의 경로를 결합해 새로운 file 객체를 생성한다.
			
			// File.separator : 폴더 경로 구분 시 Window 는 역슬래쉬 사용, 
			// Linux는 슬래쉬를 사용하는데,
			// 자바에서 이를 자동으로 구분해주는 역할을 한다.(D:\Languages)
			file = new File(directory.getAbsolutePath() + File.separator + content);
			
			// 2. directory 객체의 내용이 폴더인지 파일인지 구분한다.
			if( file.isDirectory() ) {
				// 2-1. 폴더일 경우 폴더 내부를 탐색한다.
				printFileSystem(file.getAbsolutePath());
			} 
			else {
				// 2-2. 파일의 경우 파일의 경로를 출력한다.
				System.out.println(file.getAbsolutePath());
			}
			
		}
		
	}
	
}
