package com.ktds.jgu.hr.biz;

public interface HRBiz {

	public void printAllEmployees();
	
	public void printOneEmployees(int employeeId); // 사번 전달.
	
	public void printAllDepartments();
	
	public void printAllEmployeesWithDepartments();
	public void printAllEmployeesWithJobs();
	public void printAllDepartmentsWithLocations();
	public void printAllCountriesWithRegions();
//	public void printAllJobs();
	
}
