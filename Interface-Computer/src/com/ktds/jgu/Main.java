package com.ktds.jgu;

public class Main {

	public static void main(String[] args){
		
		Computer samsungComputer = new SamsungComputer();
		samsungComputer.input();
		samsungComputer.compute();
		samsungComputer.store();
		
		Computer lgComputer = new LGComputer();
		lgComputer.input();
		lgComputer.compute();
		lgComputer.store();
		
//		Computer appleComputer = new AppleComputer();
		FaceTime appleComputer = new AppleComputer();
		appleComputer.input();
		appleComputer.compute();
		appleComputer.store();
		appleComputer.faceTime();
		
	}
}
