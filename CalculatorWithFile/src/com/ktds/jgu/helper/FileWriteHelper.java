package com.ktds.jgu.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriteHelper {

	private static final String LOG_FOLDER_PATH = "D:\\logs";

	//	private final String LOG_FILE_PATH = "D:\\logs\\Calculator.log";
	private static final String LOG_FILE_PATH = LOG_FOLDER_PATH + "\\Calculator.log";
	
	public static void log( String message ) {

		// D:\\logs 폴더를 생성한다.
		makeLogsFolder();
		
		// D:\\logs\\Calculator.log 파일을 생성한다.
		makeCalculatorLogFile();
		
		// D:\\logs\\Calculator.log 파일에 message 를 기록한다.
		writeLog(message);
		
	}
	
	// 외부에서 사용할 때 사용자에게 어떤 것을 사용해야할지 혼란을 줄 수 있어, 
	// 가이드가 필요하기 때문에 호출하는 것만 빼고 private으로 설정한다.
	private static void makeLogsFolder() {
		File logsFolder = new File(LOG_FOLDER_PATH);
		
		if( !logsFolder.exists() ) {  // 폴더 만들 때는 try catch를 안 하도록 만들어져 있음.
			logsFolder.mkdirs();
		} 
		else {
			if(!logsFolder.isDirectory()) {
				logsFolder.mkdirs();
			}
		}
	}
	
	private static void makeCalculatorLogFile() {
		File logFile = new File(LOG_FILE_PATH);
		
		if( !logFile.exists() ) {
			try {
				logFile.createNewFile();
			} catch(IOException e) {
				e.printStackTrace();  // 에러났을 때 빨간색 로그 보여주는 역할.(이게 없으면 에러나도 로그가 안보임.)
			}
		} 
		else {
			try {
				logFile.createNewFile();
			} catch(IOException e) {
				e.printStackTrace();  // 에러났을 때 빨간색 로그 보여주는 역할.(이게 없으면 에러나도 로그가 안보임.)
			}
		}
	}
	
	private static void writeLog(String message) {
		try {
			FileWriter fw = new FileWriter(LOG_FILE_PATH, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			
			out.println(message);
			
			out.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
