package com.ktds.jgu.biz;

import java.util.List;

import com.ktds.jgu.vo.EmployeeVO;
//import com.ktds.jgu.vo.PositionVO.*;

public interface EmployeeBiz {

	/**
	 * 전체 직원 조회하기
	 */
	public void seachAllEmployee();
	
	/**
	 * 직원 추가하기(입사)
	 */
	public void addEmployee();
	
	/**
	 * 직원 검색하기
	 */
	public EmployeeVO findOneEmployee(int index);
	
	/**
	 * 직원 삭제하기(퇴사)
	 */
	public void deleteEmployee();
	
	/**
	 * 직원 수정하기(진급)
	 */
	public void updateEmployee();
	
}
