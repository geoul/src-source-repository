package com.ktds.jgu.hr;

import java.util.List;

import com.ktds.jgu.hr.biz.HRBiz;
import com.ktds.jgu.hr.biz.HRBizImpl;
import com.ktds.jgu.hr.dao.HRDaoImpl;
import com.ktds.jgu.hr.vo.EmployeesVO;

public class HRController {

	private HRBiz hrBiz;
	
	public HRController() {
		hrBiz = new HRBizImpl();
	}
	
	public void start() {
		hrBiz.printAllEmployees();
//		hrBiz.printAllDepartments();
//		hrBiz.printAllEmployeesWithDepartments();
//		hrBiz.printAllEmployeesWithJobs();
//		hrBiz.printAllDepartmentsWithLocations();
//		hrBiz.printAllCountriesWithRegions();
//		hrBiz.printOneEmployees(200); // 200번 사원의 데이터가 출력된다.
	}
	
	public static void main(String[] args) {
		new HRController().start();
	}
	
}
