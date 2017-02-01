package com.ktds.jgu.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ktds.jgu.dao.EmployeeDao;
import com.ktds.jgu.dao.EmployeeDaoImpl;
import com.ktds.jgu.vo.EmployeeVO;
import com.ktds.jgu.vo.PositionVO;

public class EmployeeBizImpl implements EmployeeBiz{

	private List<EmployeeVO> employeeList; // 멤버변수
	private List<PositionVO> positionList;
	
	public EmployeeBizImpl() {
		employeeList = new ArrayList<EmployeeVO>(); // 멤버변수 초기화
		positionList = new ArrayList<PositionVO>();
	}
	
	@Override
	public List<EmployeeVO> seachAllEmployee() {
		
		return employeeList;  // 전체 주소 반환
	}

	@Override
	public void addEmployee(EmployeeVO newEmployee) {
		employeeList.add(newEmployee);
	}

	@Override
	public void deleteEmployee(int index) {
		employeeList.remove(index);
	}

	@Override
	public void updateEmployee(int index, EmployeeVO newEmployee) {
		employeeList.set(index, newEmployee);
	}

	@Override
	public EmployeeVO findOneEmployee(int index) {
		return null;
	}
	
}
