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
		hrBiz.printAllDepartments();
		hrBiz.printAllEmployeesWithDepartments();
		hrBiz.printAllEmployeesWithJobs();
	}
	
	public static void main(String[] args) {
		new HRController().start();
	}
	
}
