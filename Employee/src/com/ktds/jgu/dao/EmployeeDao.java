package com.ktds.jgu.dao;

import java.util.List;

import com.ktds.jgu.vo.EmployeeVO;
import com.ktds.jgu.vo.PositionVO;

public interface EmployeeDao extends PositionVO {

	/**
	 * 전체 직원 조회하기
	 */
	public List<EmployeeVO> seachAllEmployee();
	
	/**
	 * 직원 추가하기(입사)
	 */
	public void addEmployee(EmployeeVO newEmployee);
	
	/**
	 * 직원 검색하기
	 */
	public EmployeeVO findOneEmployee(int index);
	
	/**
	 * 직원 삭제하기(퇴사)
	 */
	public void deleteEmployee(int index);
	
	/**
	 * 직원 수정하기(진급)
	 */
	public void updateEmployee(int index, EmployeeVO newEmployee);
	
}
