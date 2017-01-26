package com.ktds.jgu.test;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		String folderPath = "D:\\";
		
		//FolderPath의 경로를 읽어 온다 
		File languagesFolder = new File  (folderPath);
		//languagesFolder의 경로가 폴더*디렉토리)인지 파일인지 구분한다.
		if ( languagesFolder.isDirectory() ) {
			System.out.println(languagesFolder.getAbsolutePath() + "는 폴더(디렉토리)입니다");
		}
		else {
			System.out.println(languagesFolder.getAbsolutePath() + "는 파일입니다");
		}
		
		File javaFolder = new File(languagesFolder.getAbsolutePath() + File.separator + "Java" );
		
		if (javaFolder.isDirectory() ){
			System.out.println(javaFolder.getAbsolutePath() + "는 폴더 입니다");
		}
		
		else {
			System.out.println(javaFolder.getAbsolutePath() + "는 파일 입니다");
		}
//		javaFolder 안에 있는 내용물들을 가져온다 
		//폴더 안에 뭐가 있는지 알게 해주는 프로그램 
		String[] contents = javaFolder.list();
		for ( String content : contents) {
			System.out.println(content);
		}
		
		
		
	}
}
