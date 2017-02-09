package com.ktds.jgu.hr.dao;

import java.util.List;

import com.ktds.jgu.hr.vo.CountriesVO;
import com.ktds.jgu.hr.vo.DepartmentVO;
import com.ktds.jgu.hr.vo.EmployeesVO;

public interface HRDao {

	// Select from employees했던 거를 List<EmployeesVO>에 담겠다.
	public List<EmployeesVO> getAllEmployees();
	
	public EmployeesVO findOneEmployee(int employeeId);
	//사번이 pk이므로 적어준다.
	// 1사람의 정보만 받을거니까 EmployeeVO를 써준다. (여러명의 정보를 받을 경우, List를 쓴다.)
	
	public List<DepartmentVO> getAllDepartments();
	
	// Join 하기 위해 추가해줌.
	public List<EmployeesVO> getAllEmployeesWithDepartments();
	public List<EmployeesVO> getAllEmployeesWithJobs();
	public List<DepartmentVO> getAllDepartmentsWithLocations();
	public List<CountriesVO> getAllCountriesWithRegions();
	
}
