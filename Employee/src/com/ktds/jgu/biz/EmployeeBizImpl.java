package com.ktds.jgu.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ktds.jgu.dao.EmployeeDao;
import com.ktds.jgu.dao.EmployeeDaoImpl;
import com.ktds.jgu.vo.EmployeeVO;
import com.ktds.jgu.vo.PositionVO.*;

public class EmployeeBizImpl implements EmployeeBiz{

//	private List<EmployeeVO> employeeList; // 멤버변수
	private Scanner input;
	private EmployeeDao employeeDao;
	
	public EmployeeBizImpl() {
		input = new Scanner(System.in);
		employeeDao = new EmployeeDaoImpl();
//		employeeList = new ArrayList<EmployeeVO>(); // 멤버변수 초기화
	}
	
	@Override
	public void seachAllEmployee() {
		List<EmployeeVO> employeeList = employeeDao.seachAllEmployee();
		for ( EmployeeVO employee : employeeList ) {
			System.out.printf("직원 이름 : %s, 직급 : %s, 연봉 : %s, 부서 : %s\n", 
					employee.getEmployeeName(), employee.getPositionName(), employee.getAnnualSalary(), employee.getDepartmentName());
		}
//		return employeeList;  // 전체 주소 반환
	}

	@Override
	public void addEmployee() {
		EmployeeVO employeeVO;
		System.out.println("새로운 직원 정보를 입력하세요.");
		System.out.println("직원의 이름을 입력하세요.");
		String employeeNameTemp = input.next();
		System.out.println("직원의 직급을 입력하세요.(0:사원, 1:대리, 2:과장, 3:차장, 4:부장, 5:사장)");
		int positionConstants = input.nextInt();
		String positionNameTemp = "";
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
		String annualSalaryTemp = input.next();
		System.out.println("직원이 소속된 부서를 입력하세요.");
		String departmentNameTemp = input.next();
		
		employeeVO = new  EmployeeVO();
		employeeVO.setEmployeeName(employeeNameTemp);
		employeeVO.setPositionName(positionNameTemp);
		employeeVO.setAnnualSalary(annualSalaryTemp);
		employeeVO.setDepartmentName(departmentNameTemp);
		
		employeeDao.addEmployee(employeeVO);
//		employeeList.add(newEmployee);
	}

	@Override
	public void deleteEmployee() {
		System.out.println("직원목록의 번호를 입력하세요.");
		int employeeNumber = input.nextInt();
		employeeDao.deleteEmployee(employeeNumber);
//		employeeList.remove(index);
	}

	@Override
	public void updateEmployee() {
		System.out.println("직원목록의 번호를 입력하세요.");
		int employeeNumber = input.nextInt();
		EmployeeVO employeeVO = employeeDao.findOneEmployee(employeeNumber);
		
		System.out.println("수정할 직원 정보를 입력하세요.");
		System.out.println("직원의 이름을 입력하세요.");
		String employeeNameTemp = input.next();
		System.out.println("직원의 직급을 입력하세요.(0:사원, 1:대리, 2:과장, 3:차장, 4:부장, 5:사장)");
		int positionConstants = input.nextInt();
		String positionNameTemp = "";
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
		String annualSalaryTemp = input.next();
		System.out.println("직원이 소속된 부서를 입력하세요.");
		String departmentNameTemp = input.next();
		
		employeeVO = new EmployeeVO();
		employeeVO.setEmployeeName(employeeNameTemp);
		employeeVO.setPositionName(positionNameTemp);
		employeeVO.setAnnualSalary(annualSalaryTemp);
		employeeVO.setDepartmentName(departmentNameTemp);
		
		employeeDao.updateEmployee(employeeNumber, employeeVO);
//		employeeList.set(index, newEmployee);
	}

	@Override
	public EmployeeVO findOneEmployee(int index) {
		return null;
	}
	
}
