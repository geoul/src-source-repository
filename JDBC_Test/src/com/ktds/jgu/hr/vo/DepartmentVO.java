package com.ktds.jgu.hr.vo;

import com.ktds.mcj.dao.support.annotation.Types;

public class DepartmentVO {

	// D_DEPARTMENT_ID 가 없으면 아래것으로 가져옴.
	@Types(alias="D_DEPARTMENT_ID")
	private int departmentId;
	
	@Types
	private String departmentName;
	
	// D_MANAGER_ID 가 없으면 아래것으로 가져옴.
	@Types(alias = "D_MANAGER_ID")
	private int managerId;
	
	@Types
	private int locationId;
	
	// Join 하기 위해 테이블의 VO를 추가.
	private LocationsVO locations; 
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
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
	
	// Join 하기 위해 추가한 테이블 VO의 getter, setter를 추가해준다.
	public LocationsVO getLocations() {
		if ( locations == null ) {
			locations = new LocationsVO();
		}
		return locations;
	}
	public void setLocations(LocationsVO locations) {
		this.locations = locations;
	}
	
}
