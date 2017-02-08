package com.ktds.jgu.hr.biz;

import java.util.List;

import com.ktds.jgu.hr.dao.HRDao;
import com.ktds.jgu.hr.dao.HRDaoImpl;
import com.ktds.jgu.hr.vo.EmployeesVO;

public class Main {

	public static void main(String[] args) {
	
		HRDao hrDao = new HRDaoImpl();
		List<EmployeesVO> employees = hrDao.getAllEmployees();
		
		for (EmployeesVO employeesVO : employees) {
			System.out.print(employeesVO.getEmployeeId() + "\t");
			System.out.print(employeesVO.getFirstName() + "\t");
			System.out.println(employeesVO.getLastName());
		}
	}
	
}
