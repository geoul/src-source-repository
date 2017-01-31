package com.ktds.jgu.pccafe;

import com.ktds.jgu.AppleComputer;
import com.ktds.jgu.Computer;
import com.ktds.jgu.LGComputer;
import com.ktds.jgu.SamsungComputer;

public class PCCafe {

	public static void main(String[] args) {
		
		Computer[] computers = new Computer[5];
		
		// 인터페이스로 구현한 것을 객체로 사용할 수 있다.
		computers[0] = new SamsungComputer();
		computers[1] = new LGComputer();
		computers[2] = new SamsungComputer();
		computers[3] = new AppleComputer();
		computers[4] = new LGComputer();
		
		for(Computer computer : computers) {
			computer.input();
			computer.compute();
			computer.store();
			if( computer instanceof AppleComputer ) {
				((AppleComputer) computer).faceTime();
			}
		}
		
	}
	
}
