package com.ktds.jgu.hr.vo;

import java.util.List;

import com.ktds.mcj.dao.support.annotation.Types;

public class DepartmentsVO {

	@Types
	private int departmentsId;
	@Types
	private String departmentName;
	@Types
	private int managerId;
	@Types
	private int locationId;
	
	private List<EmployeesVO> employeesVO;
	
	
	public List<EmployeesVO> getEmployeesVO() {
		return employeesVO;
	}
	public void setEmployeesVO(List<EmployeesVO> employeesVO) {
		this.employeesVO = employeesVO;
	}
	
	public int getDepartmentsId() {
		return departmentsId;
	}
	public void setDepartmentsId(int departmentsId) {
		this.departmentsId = departmentsId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
}
