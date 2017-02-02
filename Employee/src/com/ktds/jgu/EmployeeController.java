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
		
		List<EmployeeVO> employeeList = null;
		EmployeeVO employeeVO = null;
		List<PositionVO> positionList = null;
		PositionVO positionVO = null;
		
		int employeeNumber = 0;
		int positionConstants = 0;
		
		String employeeNameTemp = "";
		String positionNameTemp = "";
		String annualSalaryTemp = "";
		String departmentNameTemp = "";
		
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
				employeeList = employeeBiz.seachAllEmployee();
				for ( EmployeeVO employee : employeeList ) {
					System.out.printf("직원 이름 : %s, 직급 : %s, 연봉 : %s, 부서 : %s\n", 
							employee.getEmployeeName(), employee.getPositionName(), employee.getAnnualSalary(), employee.getDepartmentName());
				}
			} 
			else if ( chooseMenu == 2 ) {
				System.out.println("새로운 직원 정보를 입력하세요.");
				System.out.println("직원의 이름을 입력하세요.");
				employeeNameTemp = input.next();
				System.out.println("직원의 직급을 입력하세요.(0:사원, 1:대리, 2:과장, 3:차장, 4:부장, 5:사장)");
				positionConstants = input.nextInt();
				if(positionConstants == 0) {
					positionNameTemp = "사원";
				}
				else if(positionConstants == 1) {
					positionNameTemp = "대리";
				}
				else if(positionConstants == 2) {
					positionNameTemp = "과장";
				}
				else if(positionConstants == 3) {
					positionNameTemp = "차장";
				}
				else if(positionConstants == 4) {
					positionNameTemp = "부장";
				}
				else if(positionConstants == 5) {
					positionNameTemp = "사장";
				} 
				else {
					positionNameTemp = "";
					System.out.println("직원의 직급을 잘못 입력하였습니다. 다시 입력하세요.");
					positionConstants = input.nextInt();
				}
				System.out.println("직원의 연봉을 입력하세요.");
				annualSalaryTemp = input.next();
				System.out.println("직원이 소속된 부서를 입력하세요.");
				departmentNameTemp = input.next();
				
				employeeVO = new  EmployeeVO();
				employeeVO.setEmployeeName(employeeNameTemp);
				employeeVO.setPositionName(positionNameTemp);
				employeeVO.setAnnualSalary(annualSalaryTemp);
				employeeVO.setDepartmentName(departmentNameTemp);
				
				employeeBiz.addEmployee(employeeVO);
			}
			else if ( chooseMenu == 3 ) {
				System.out.println("직원목록의 번호를 입력하세요.");
				employeeNumber = input.nextInt();
				employeeBiz.deleteEmployee(employeeNumber);
			}
			else if ( chooseMenu == 4 ) {
				
				System.out.println("직원목록의 번호를 입력하세요.");
				employeeNumber = input.nextInt();
				employeeVO = employeeBiz.findOneEmployee(employeeNumber);
				
				System.out.println("수정할 직원 정보를 입력하세요.");
				System.out.println("직원의 이름을 입력하세요.");
				employeeNameTemp = input.next();
				System.out.println("직원의 직급을 입력하세요.(0:사원, 1:대리, 2:과장, 3:차장, 4:부장, 5:사장)");
				positionConstants = input.nextInt();
				if(positionConstants == 0) {
					positionNameTemp = "사원";
				}
				else if(positionConstants == 1) {
					positionNameTemp = "대리";
				}
				else if(positionConstants == 2) {
					positionNameTemp = "과장";
				}
				else if(positionConstants == 3) {
					positionNameTemp = "차장";
				}
				else if(positionConstants == 4) {
					positionNameTemp = "부장";
				}
				else if(positionConstants == 5) {
					positionNameTemp = "사장";
				} 
				else {
					positionNameTemp = "";
					System.out.println("직원의 직급을 잘못 입력하였습니다. 다시 입력하세요.");
					positionConstants = input.nextInt();
				}
				
				System.out.println("직원의 연봉을 입력하세요.");
				annualSalaryTemp = input.next();
				System.out.println("직원이 소속된 부서를 입력하세요.");
				departmentNameTemp = input.next();
				
				employeeVO = new EmployeeVO();
				employeeVO.setEmployeeName(employeeNameTemp);
				employeeVO.setPositionName(positionNameTemp);
				employeeVO.setAnnualSalary(annualSalaryTemp);
				employeeVO.setDepartmentName(departmentNameTemp);
				
				employeeBiz.updateEmployee(employeeNumber, employeeVO);
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
