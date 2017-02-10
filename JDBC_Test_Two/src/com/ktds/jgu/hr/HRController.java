package com.ktds.jgu.hr;

import com.ktds.jgu.hr.biz.HRBiz;
import com.ktds.jgu.hr.biz.HRBizImpl;

public class HRController {

	private HRBiz hrBiz;
	
	public HRController() {
		HRBiz hrBiz = new HRBizImpl();
	}
	
	public void start() {
		hrBiz.printEmployeesWithDepartmentsWithJobsWithLocations();
		hrBiz.printDepartmentsWithEmployees();
	}
	
	public static void main(String[] args) {
		new HRController().start();
	}
	
}
