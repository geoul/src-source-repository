package com.ktds.jgu.hr.dao;

import java.util.List;

import com.ktds.jgu.hr.vo.DepartmentsVO;
import com.ktds.jgu.hr.vo.EmployeesVO;

public interface HRDao {

	public List<EmployeesVO> getEmployeesWithDepartmentsWithJobsWithLocations();
	
	public List<EmployeesVO> getDepartmentsWithEmployees();
	
	public List<EmployeesVO> getSeattleWithEmployees();
	
	public List<DepartmentsVO> getAllDepartments();
	
}
