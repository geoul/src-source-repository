package com.ktds.jgu.hr.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ktds.jgu.hr.vo.DepartmentsVO;
import com.ktds.jgu.hr.vo.EmployeesVO;
import com.ktds.mcj.dao.support.JDBCDaoSupport;
import com.ktds.mcj.dao.support.QueryHandler;
import com.ktds.mcj.dao.support.annotation.BindData;
import com.sun.org.apache.bcel.internal.generic.Select;

public class HRDaoImpl extends JDBCDaoSupport implements HRDao {

	@Override
	public List<EmployeesVO> getEmployeesWithDepartmentsWithJobsWithLocations() {
		
		return selectList(new QueryHandler() {

			@Override
			public String preparedQuery() {
				
				StringBuffer query = new StringBuffer();
				
				query.append(" SELECT	E.EMPLOYEE_ID                       ");
				query.append(" 			, E.FIRST_NAME                          ");
				query.append(" 			, E.LAST_NAME                           ");
				query.append(" 			, D.DEPARTMENT_NAME                     ");
				query.append(" 			, J.JOB_TITLE                           ");
				query.append(" 			, C.CITY                                ");
				query.append(" FROM 	EMPLOYEES E                         ");
				query.append(" 			, DEPARTMENTS D                         ");
				query.append(" 			, JOBS J                                ");
				query.append(" 			, LOCATIONS L                           ");
				query.append(" WHERE	E.DEPARTMENT_ID = D.DEPARTMENT_ID   ");
				query.append(" AND 		E.JOB_ID = J.JOB_ID                     ");
				
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
				BindData.bindData(rs, employeesVO.getJobs());
				BindData.bindData(rs, employeesVO.getLocations());
				
				return employeesVO;
			}
		});
	}

	@Override
	public List<EmployeesVO> getDepartmentsWithEmployees() {
		
		return selectList(new QueryHandler() {

			@Override
			public String preparedQuery() {
				
				StringBuffer query = new StringBuffer();
				
				query.append(" SELECT  E.EMPLOYEE_ID                      ");
		        query.append(" 			, E.FIRST_NAME                        ");
		        query.append(" 			, E.LAST_NAME                         ");
		        query.append(" 			, D.DEPARTMENT_ID                     ");
		        query.append(" FROM    EMPLOYEES E                        ");
		        query.append(" 			, DEPARTMENTS D                       ");
		        query.append(" WHERE   E.DEPARTMENT_ID = D.DEPARTMENT_ID  ");
		        query.append(" AND     D.DEPARTMENT_ID = '20'             ");
		        
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
	public List<EmployeesVO> getSeattleWithEmployees() {
		
		return selectList(new QueryHandler() {

			@Override
			public String preparedQuery() {
				
				StringBuffer query = new StringBuffer();
				
				query.append(" SELECT  E.EMPLOYEE_ID      ");
		        query.append(" 			, E.FIRST_NAME        ");
		        query.append(" 			, E.LAST_NAME         ");
		        query.append(" 			, E.EMAIL             ");
		        query.append(" 			, E.PHONE_NUMBER      ");
		        query.append(" 			, E.HIRE_DATE         ");
		        query.append(" 			, E.JOB_ID            ");
		        query.append(" 			, E.SALARY            ");
		        query.append(" 			, E.COMMISSION_PCT    ");
		        query.append(" 			, E.MANAGER_ID        ");
		        query.append(" 			, E.DEPARTMENT_ID     ");
		        query.append(" 			, D.DEPARTMENT_NAME   ");
		        query.append(" 			, J.JOB_TITLE         ");
		        query.append(" 			, L.CITY              ");
		        query.append(" FROM    EMPLOYEES E        ");
		        query.append(" 			, DEPARTMENTS D       ");
		        query.append(" 			, JOBS J              ");
		        query.append(" 			, LOCATIONS L         ");
		        query.append(" WHERE   L.CITY = 'Seattle' ");
				
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
				BindData.bindData(rs, employeesVO.getJobs());
				BindData.bindData(rs, employeesVO.getLocations());
				
				return employeesVO;
			}
		});
	}

	@SuppressWarnings("unchecked")  // 실행에 영향을 미치지 않음. 노란색 줄(경고) 없애기.
	@Override
	public List<DepartmentsVO> getAllDepartments() {
		
		return selectList(new QueryHandler() {

			@Override
			public String preparedQuery() {
				
				StringBuffer query = new StringBuffer();
				
				query.append(" Select	E.EMPLOYEE_ID                      ");
				query.append(" 			, E.FIRST_NAME                         ");
				query.append(" 			, E.LAST_NAME                          ");
				query.append(" 			, E.EMAIL                              ");
				query.append(" 			, E.PHONE_NUMBER                       ");
				query.append(" 			, E.HIRE_DATE                          ");
				query.append(" 			, E.JOB_ID                             ");
				query.append(" 			, E.SALARY                             ");
				query.append(" 			, E.COMMISSION_PCT                     ");
				query.append(" 			, E.MANAGER_ID                         ");
				query.append(" 			, E.DEPARTMENT_ID                      ");
				query.append(" 			, D.DEPARTMENT_ID D_DEPARTMENT_ID      ");
				query.append(" 			, D.DEPARTMENT_NAME                    ");
				query.append(" 			, D.MANAGER_ID D_MANAGER_ID            ");
				query.append(" 			, D.LOCATION_ID                        ");
				query.append(" FROM 	EMPLOYEES E,                       ");
				query.append(" 			DEPARTMENTS D                          ");
				query.append(" WHERE	E.DEPARTMENT_ID = D.DEPARTMENT_ID  ");
				
				return query.toString();
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
			}

			@Override
			public Object getData(ResultSet rs) {
				return null;
			}
			
		});
	}

}
