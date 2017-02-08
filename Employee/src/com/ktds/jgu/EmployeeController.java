package com.ktds.jgu;

import java.util.List;
import java.util.Scanner;

import com.ktds.jgu.biz.EmployeeBiz;
import com.ktds.jgu.biz.EmployeeBizImpl;
import com.ktds.jgu.vo.EmployeeVO;
import com.ktds.jgu.vo.PositionVO;

public class EmployeeController {

	public void start() {
		
		EmployeeBiz employeeBiz = new EmployeeBizImpl();
		
		Scanner input = new Scanner(System.in);
		int chooseMenu = 0;
		
//		List<EmployeeVO> employeeList = null;
//		EmployeeVO employeeVO = null;
//		List<PositionVO> positionList = null;
//		PositionVO positionVO = null;
//		
//		int employeeNumber = 0;
//		int positionConstants = 0;
//		
//		String employeeNameTemp = "";
//		String positionNameTemp = "";
//		String annualSalaryTemp = "";
//		String departmentNameTemp = "";
		
		while( true ) {
			System.out.println("========== 직원 관리 시스템 ==========");
			System.out.println("1. 직원 조회");
			System.out.println("2. 직원 추가(입사)");
			System.out.println("3. 직원 삭제(퇴사)");
			System.out.println("4. 직원 수정(진급)");
			System.out.println("5. 종료");
			System.out.println("=====================================");		
			System.out.println("메뉴를 선택하세요.");
			
			chooseMenu = input.nextInt();
			
			if ( chooseMenu == 1 ) {
				employeeBiz.seachAllEmployee();
			} 
			else if ( chooseMenu == 2 ) {
				employeeBiz.addEmployee();
			}
			else if ( chooseMenu == 3 ) {
				employeeBiz.deleteEmployee();
			}
			else if ( chooseMenu == 4 ) {
				employeeBiz.updateEmployee();
			}
			else {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		new EmployeeController().start();
	}
	
}
