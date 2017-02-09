package com.ktds.jgu.hr.biz;

import java.util.ArrayList;
import java.util.List;

import com.ktds.jgu.hr.dao.HRDao;
import com.ktds.jgu.hr.dao.HRDaoImpl;
import com.ktds.jgu.hr.vo.CountriesVO;
import com.ktds.jgu.hr.vo.DepartmentVO;
import com.ktds.jgu.hr.vo.EmployeesVO;


public class HRBizImpl implements HRBiz {

	private HRDao hrDao;
	
	public HRBizImpl() {
		hrDao = new HRDaoImpl();
	}
	
	@Override
	public void printAllEmployees() {
		
		List<EmployeesVO> allEmployees = hrDao.getAllEmployees();
		
		for ( EmployeesVO employeesVO : allEmployees ) {
			System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%s\t%d\t%f\t%d\t%d\n",
			employeesVO.getEmployeeId()
			, employeesVO.getFirstName()
			, employeesVO.getLastName()
			, employeesVO.getEmail()
			, employeesVO.getPhoneNumber()
			, employeesVO.getHireDate()
			, employeesVO.getJobId()
			, employeesVO.getSalary()
			, employeesVO.getCommissionPct()
			, employeesVO.getManagerId()
			, employeesVO.getDepartmentId());
		}		
	}
	
	// Ctrl + Space 해서 해당 메소드 고르면 됨.
	@Override
	public void printOneEmployees(int employeeId) {
		EmployeesVO employees = hrDao.findOneEmployee(employeeId);
		
		System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%s\t%d\t%f\t%d\t%d\n",
				employees.getEmployeeId()
				, employees.getFirstName()
				, employees.getLastName()
				, employees.getEmail()
				, employees.getPhoneNumber()
				, employees.getHireDate()
				, employees.getJobId()
				, employees.getSalary()
				, employees.getCommissionPct()
				, employees.getManagerId()
				, employees.getDepartmentId());
	}

	@Override
	public void printAllDepartments() {
		
		List<DepartmentVO> allDepartments = hrDao.getAllDepartments();
		
		for ( DepartmentVO departmentsVO : allDepartments ) {
			System.out.printf("%d\t%s\t%d\t%d\n"
					, departmentsVO.getDepartmentId()
					, departmentsVO.getDepartmentName()
					, departmentsVO.getManagerId()
					, departmentsVO.getLocationId());
		}
		
	}

	@Override
	public void printAllEmployeesWithDepartments() {
		
		List<EmployeesVO> allEmployees = hrDao.getAllEmployeesWithDepartments();
		
		for ( EmployeesVO employeesVO : allEmployees ) {
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
					, employeesVO.getDepartments().getDepartmentId()
					, employeesVO.getDepartments().getDepartmentName()
					, employeesVO.getDepartments().getManagerId()
					, employeesVO.getDepartments().getLocationId());
		}
		
	}

	@Override
	public void printAllEmployeesWithJobs() {
		
		List<EmployeesVO> allEmployees = hrDao.getAllEmployeesWithJobs();
		
		for ( EmployeesVO employeesVO : allEmployees ) {
			System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%s\t%d\t%f\t%d\t%d\t%d\t%s\t%d\t%d\t%s\t%s\t%d\t%d\n"
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
					, employeesVO.getDepartments().getDepartmentId()
					, employeesVO.getDepartments().getDepartmentName()
					, employeesVO.getDepartments().getManagerId()
					, employeesVO.getDepartments().getLocationId()
					, employeesVO.getJobs().getJobId()
					, employeesVO.getJobs().getJobTitle()
					, employeesVO.getJobs().getMinSalary()
					, employeesVO.getJobs().getMaxSalary());
			
		}
		
	}

	@Override
	public void printAllDepartmentsWithLocations() {
		
		List<DepartmentVO> allDepartments = hrDao.getAllDepartmentsWithLocations();
		
		for ( DepartmentVO departmentsVO : allDepartments ) {
			System.out.printf("%d\t%s\t%d\t%d\t%d\t%s\t%s\t%s\t%s\t%s\n"
					, departmentsVO.getDepartmentId()
					, departmentsVO.getDepartmentName()
					, departmentsVO.getManagerId()
					, departmentsVO.getLocationId()
					, departmentsVO.getLocations().getLocationId()
					, departmentsVO.getLocations().getStreetAddress()
					, departmentsVO.getLocations().getPostalCode()
					, departmentsVO.getLocations().getCity()
					, departmentsVO.getLocations().getStateProvince()
					, departmentsVO.getLocations().getCountryId());
			
		}
	}

	@Override
	public void printAllCountriesWithRegions() {
		
		List<CountriesVO> allCountries = hrDao.getAllCountriesWithRegions();
		
		for ( CountriesVO countriesVO : allCountries ) {
			System.out.printf("%s\t%s\t%d\t%d\t%s\n"
					, countriesVO.getCountryId()
					, countriesVO.getCountryName()
					, countriesVO.getRegionId()
					, countriesVO.getRegions().getRegionId()
					, countriesVO.getRegions().getRegionName());
			
		}
		
	}
	
}
