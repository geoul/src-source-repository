package com.ktds.jgu.dao;

import java.util.ArrayList;
import java.util.List;

import com.ktds.jgu.vo.EmployeeVO;
import com.ktds.jgu.vo.PositionVO;

public class EmployeeDaoImpl implements EmployeeDao{

	private List<EmployeeVO> employeeList;
	private List<PositionVO> positionList;
	
	public void EmployeeBizImpl() {
		employeeList = new ArrayList<EmployeeVO>();
		positionList = new ArrayList<PositionVO>();
	}
	
	@Override
	public List<EmployeeVO> seachAllEmployee() {
		return employeeList;
	}

	@Override
	public void addEmployee(EmployeeVO newEmployee) {
		employeeList.add(newEmployee);
	}

	@Override
	public void deleteEmployee(int index) {
		employeeList.remove(index);
	}

//	@Override
//	public void updateEmployee(int employeeNumber, PositionVO newPosition) {
//		positionList.set(employeeNumber, newPosition);
//	}

	@Override
	public void updateEmployee(int index, EmployeeVO newEmployee) {
		// TODO Auto-generated method stub
		
	}
	
}
