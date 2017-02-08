package com.ktds.jgu.hr.dao;

import java.util.List;

import com.ktds.jgu.hr.vo.DepartmentVO;
import com.ktds.jgu.hr.vo.EmployeesVO;

public interface HRDao {

	// Select from employees했던 거를 List<EmployeesVO>에 담겠다.
	public List<EmployeesVO> getAllEmployees();
	public List<DepartmentVO> getAllDepartments();
	
	// Join 하기 위해 추가해줌.
	public List<EmployeesVO> getAllEmployeesWithDepartments();
	public List<EmployeesVO> getAllEmployeesWithJobs();
	
}
