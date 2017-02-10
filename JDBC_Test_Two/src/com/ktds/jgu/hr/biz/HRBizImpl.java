package com.ktds.jgu.hr.biz;

import java.util.List;

import com.ktds.jgu.hr.dao.HRDao;
import com.ktds.jgu.hr.dao.HRDaoImpl;
import com.ktds.jgu.hr.vo.EmployeesVO;

public class HRBizImpl implements HRBiz {

	private HRDao hrDao;
	
	public HRBizImpl() {
		hrDao = new HRDaoImpl();
	}
	
	@Override
	public void printEmployeesWithDepartmentsWithJobsWithLocations() {
		
		List<EmployeesVO> employees = hrDao.getEmployeesWithDepartmentsWithJobsWithLocations();
		
		for (EmployeesVO employeesVO : employees) {
			System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%s\t%d\t%f\t%d\t%d\n"
					, employeesVO.getEmployeeId()
					, employeesVO.getFirstName()
					, employeesVO.getLastName()
					, employeesVO.getEmail()
					, employeesVO.getPhoneNumber()
					, employeesVO.getHireDate()
					, employeesVO.getJobId()
					, employeesVO.getSalary()
					, employeesVO.getCommissionPct()
					, employeesVO.getManagerId()
					, employeesVO.getDepartmentId()
					, employeesVO.getDepartments().getDepartmentsId()
					, employeesVO.getDepartments().getDepartmentName()
					, employeesVO.getDepartments().getManagerId()
					, employeesVO.getDepartments().getLocationId()
					, employeesVO.getJobs().getJobId()
					, employeesVO.getJobs().getJobName()
					, employeesVO.getJobs().getMinSalary()
					, employeesVO.getJobs().getMaxSalary()
					, employeesVO.getLocations().getLocationId()
					, employeesVO.getLocations().getStreetAddress()
					, employeesVO.getLocations().getPostalCode()
					, employeesVO.getLocations().getCity()
					, employeesVO.getLocations().getStateProvince()
					, employeesVO.getLocations().getCountryId());
		}
		
	}

	@Override
	public void printDepartmentsWithEmployees() {
		
		List<EmployeesVO> employees = hrDao.getDepartmentsWithEmployees();
		
		for (EmployeesVO employeesVO : employees) {
			System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%s\t%d\t%f\t%d\t%d\t%d\t%s\t%d\t%d\n"
					, employeesVO.getEmployeeId()
					, employeesVO.getFirstName()
					, employeesVO.getLastName()
					, employeesVO.getEmail()
					, employeesVO.getPhoneNumber()
					, employeesVO.getHireDate()
					, employeesVO.getJobId()
					, employeesVO.getSalary()
					, employeesVO.getCommissionPct()
					, employeesVO.getManagerId()
					, employeesVO.getDepartmentId()
					, employeesVO.getDepartments().getDepartmentsId()
					, employeesVO.getDepartments().getDepartmentName()
					, employeesVO.getDepartments().getManagerId()
					, employeesVO.getDepartments().getLocationId());
		}
		
	}

	@Override
	public void printAllEmployeesInDepartments() {
		
List<EmployeesVO> employees = hrDao.getDepartmentsWithEmployees();
		
		for (EmployeesVO employeesVO : employees) {
			System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%s\t%d\t%f\t%d\t%d\t%d\t%s\t%d\t%d\n"
					, employeesVO.getEmployeeId()
					, employeesVO.getFirstName()
					, employeesVO.getLastName()
					, employeesVO.getEmail()
					, employeesVO.getPhoneNumber()
					, employeesVO.getHireDate()
					, employeesVO.getJobId()
					, employeesVO.getSalary()
					, employeesVO.getCommissionPct()
					, employeesVO.getManagerId()
					, employeesVO.getDepartmentId()
					, employeesVO.getDepartments().getDepartmentsId()
					, employeesVO.getDepartments().getDepartmentName()
					, employeesVO.getDepartments().getManagerId()
					, employeesVO.getDepartments().getLocationId());
		}
		
	}

//	@Override
//	public void printSeattleWithEmployees() {
//		// TODO Auto-generated method stub
//		
//	}

	
	
}
