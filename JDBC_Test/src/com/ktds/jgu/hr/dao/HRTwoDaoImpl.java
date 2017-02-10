package com.ktds.jgu.hr.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ktds.jgu.hr.vo.CountriesVO;
import com.ktds.jgu.hr.vo.DepartmentVO;
import com.ktds.jgu.hr.vo.EmployeesVO;
import com.ktds.mcj.dao.support.JDBCDaoSupport;
import com.ktds.mcj.dao.support.QueryHandler;
import com.ktds.mcj.dao.support.annotation.BindData;

public class HRTwoDaoImpl extends JDBCDaoSupport implements HRDao {

	@Override
	public List<EmployeesVO> getAllEmployees() {
		
		return selectList(new QueryHandler() {

			@Override
			public String preparedQuery() {
				
				StringBuffer query = new StringBuffer();
				
				query.append(" SELECT 	EMPLOYEE_ID  "); 
				query.append(" 			, FIRST_NAME     "); 
				query.append(" 			, LAST_NAME      "); 
				query.append(" 			, EMAIL          "); 
				query.append(" 			, PHONE_NUMBER   "); 
				query.append(" 			, HIRE_DATE      "); 
				query.append(" 			, JOB_ID         "); 
				query.append(" 			, SALARY         "); 
				query.append(" 			, COMMISSION_PCT "); 
				query.append(" 			, MANAGER_ID     "); 
				query.append(" 			, DEPARTMENT_ID  "); 
				query.append(" FROM		EMPLOYEES        "); 
				
				return query.toString();
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				
			}

			@Override
			public Object getData(ResultSet rs) {
				EmployeesVO employeesVO = new EmployeesVO();
				BindData.bindData(rs, employeesVO);
				
				return employeesVO;
			}
		}); 
	}

	@Override
	public EmployeesVO findOneEmployee(int employeeId) {
		
//		return selectOne(new QueryHandler() {})
//		return selectList(new QueryHandler() {
//			StringBuffer query = new StringBuffer();
//			
//			query.append(" SELECT 	EMPLOYEE_ID      ");
//			query.append(" 			, FIRST_NAME         ");
//			query.append(" 			, LAST_NAME          ");
//			query.append(" 			, EMAIL              ");
//			query.append(" 			, PHONE_NUMBER       ");
//			query.append(" 			, HIRE_DATE          ");
//			query.append(" 			, JOB_ID             ");
//			query.append(" 			, SALARY             ");
//			query.append(" 			, COMMISSION_PCT     ");
//			query.append(" 			, MANAGER_ID         ");
//			query.append(" 			, DEPARTMENT_ID      ");
//			query.append(" FORM		EMPLOYEES            ");
//			query.append(" WHERE	EMPLOYEE_ID = ?  ");
//			
//			return query.toString(200);
//		});
		
		return null;
	}

	@Override
	public List<DepartmentVO> getAllDepartments() {
		
		return selectList(new QueryHandler() {
			

			@Override
			public String preparedQuery() {
				StringBuffer query = new StringBuffer();
				
				query.append(" SELECT 	DEPARTMENT_ID ");
				query.append(" 			, DEPARTMENT_NAME ");
				query.append(" 			, MANAGER_ID      ");
				query.append(" 			, LOCATION_ID     ");
				query.append(" FROM		DEPARTMENTS       ");
				
				return query.toString();
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				
			}

			@Override
			public Object getData(ResultSet rs) {
				DepartmentVO departmentVO = new DepartmentVO();
				BindData.bindData(rs, departmentVO);
				return departmentVO;
			}
		});
	}

	@Override
	public List<EmployeesVO> getAllEmployeesWithDepartments() {
		return selectList(new QueryHandler() {

			@Override
			public String preparedQuery() {
				StringBuffer query = new StringBuffer();
				
				query.append(" SELECT	E.EMPLOYEE_ID                       ");
				query.append(" 			, E.FIRST_NAME                          ");
				query.append(" 			, E.LAST_NAME                           ");
				query.append(" 			, E.EMAIL                               ");
				query.append(" 			, E.PHONE_NUMBER                        ");
				query.append(" 			, E.HIRE_DATE                           ");
				query.append(" 			, E.JOB_ID                              ");
				query.append(" 			, E.SALARY                              ");
				query.append(" 			, E.COMMISSION_PCT                      ");
				query.append(" 			, E.MANAGER_ID                          ");
				query.append(" 			, E.DEPARTMENT_ID                       ");
				query.append(" 			, D.DEPARTMENT_ID D_DEPARTMENT_ID       ");
				query.append(" 			, D.DEPARTMENT_NAME                     ");
				query.append(" 			, D.MANAGER_ID                          ");
				query.append(" 			, D.LOCATION_UD                         ");
				query.append(" FROM		EMPLOYEES E                             ");
				query.append(" 			, DEPARTMENTS D                         ");
				query.append(" WHERE	E,DEPARTMENT_ID = D.DEPARTMENT_ID   ");
						
				return query.toString();
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				
			}

			@Override
			public Object getData(ResultSet rs) {
				EmployeesVO employeesVO = new EmployeesVO();
				BindData.bindData(rs, employeesVO);
				BindData.bindData(rs, employeesVO.getDepartments());
				
				return employeesVO;
			}
			
		});
	}

	@Override
	public List<EmployeesVO> getAllEmployeesWithJobs() {
		
		return selectList(new QueryHandler() {

			@Override
			public String preparedQuery() {
				StringBuffer query = new StringBuffer();
				
				query.append(" SELECT 	E.EMPLOYEE_ID         ");
				query.append(" 			, E.FIRST_NAME            ");
				query.append(" 			, E.LAST_NAME             ");
				query.append(" 			, E.EMAIL                 ");
				query.append(" 			, E.PHONE_NUMBER          ");
				query.append(" 			, E.HIRE_DATE             ");
				query.append(" 			, E.JOB_ID                ");
				query.append(" 			, E.SALARY                ");
				query.append(" 			, E.COMMISSION_PCT        ");
				query.append(" 			, E.MANAGER_ID            ");
				query.append(" 			, E.DEPARTMENT_ID         ");
				query.append(" 			, J.JOB_ID J_JOB_ID       ");
				query.append(" 			, J.JOB_TITLE             ");
				query.append(" 			, J.MIN_SALARY            ");
				query.append(" 			, J.MAX_SALARY            ");
				query.append(" FROM 	EMPLOYEES E           ");
				query.append("    		, JOBS J              ");
				query.append(" WHERE	E.JOB_ID = J_JOB_ID   ");
						
				return query.toString();
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				
			}

			@Override
			public Object getData(ResultSet rs) {
				EmployeesVO employeesVO = new EmployeesVO();
				BindData.bindData(rs, employeesVO);
				BindData.bindData(rs, employeesVO.getJobs());
				
				return employeesVO;
			}
			
		});
	}

	@Override
	public List<DepartmentVO> getAllDepartmentsWithLocations() {
		
		return selectList(new QueryHandler() {

			@Override
			public String preparedQuery() {
				StringBuffer query = new StringBuffer();
				
				query.append(" SELECT	D.DEPARTMENT_ID                ");
				query.append(" 			, D.DEPARTMENT_NAME                ");
				query.append(" 			, D.MANAGER_ID                     ");
				query.append(" 			, D.LOCATION_ID                    ");
				query.append(" 			, L.LOCATION_ID L_LOCATION_ID      ");
				query.append(" 			, L.STREET_ADDRESS                 ");
				query.append(" 			, L.POSTAL_CODE                    ");
				query.append(" 			, L.CITY                           ");
				query.append(" 			, L.STATE_PROVINCE                 ");
				query.append(" 			, L.COUNTRY_ID                     ");
				query.append(" FROM		DEPARTMENTS D                      ");
				query.append(" 			, LOCATIONS L                      ");
				query.append(" WHERE	D.LOCATION_ID = L_LOCATION_ID  ");
				
				return query.toString();
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				
			}

			@Override
			public Object getData(ResultSet rs) {
				DepartmentVO departmentVO = new DepartmentVO();
				BindData.bindData(rs, departmentVO);
				BindData.bindData(rs, departmentVO.getLocations());
				return departmentVO;
			}
			
		});
	}

	@Override
	public List<CountriesVO> getAllCountriesWithRegions() {
		
		return selectList(new QueryHandler() {

			@Override
			public String preparedQuery() {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	C.COUNTRY_ID              ");
				query.append(" 			, C.COUNTRY_NAME              ");
				query.append(" 			, C.REGION_ID                 ");
				query.append(" 			, R.REGION_ID R_REGION_ID     ");
				query.append(" 			, R.REGION_NAME               ");
				query.append(" FROM		COUNTRIES C                   ");
				query.append(" 			, REGIONS R                   ");
				query.append(" WHERE 	C.REGION_ID = R_REGION_ID ");
				
				return null;
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				
			}

			@Override
			public Object getData(ResultSet rs) {
				CountriesVO countriesVO = new CountriesVO();
				BindData.bindData(rs, countriesVO);
				BindData.bindData(rs, countriesVO.getRegions());
				
				return countriesVO;
			}
			
		});
	}

	
	
}
