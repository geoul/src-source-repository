package com.ktds.jgu.hr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.jgu.hr.vo.DepartmentVO;
import com.ktds.jgu.hr.vo.EmployeesVO;
import com.ktds.jgu.hr.vo.JobsVO;

public class HRDaoImpl implements HRDao {

	@Override
	public List<EmployeesVO> getAllEmployees() {
		
		// 1. Oracle Driver Loading
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로딩 실패! 시스템을 종료합니다.");
			return null;
		}
		
		// Database 교재 63p 참조. (JDBC API)
		// 2. JDBC Instance 생성
		// import java.spl 사용
		// 파이프를 이용해서 데이터를 던지고 나중에 파이프를 회수해야함.(finally에서 함)
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// 3. Oracle Instance에 연결
		// getConnection 3번째꺼 사용.
		// windows는 @localhost 사용.
		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		try {
			conn = DriverManager.getConnection(oracleUrl, "HR", "HR");
			
			// 4. 쿼리를 만든다.
			// 따옴표 앞/뒤는 띄어쓰기한다. 붙이면 에러남.
			String query = " SELECT  " +
					" EMPLOYEE_ID, FIRST_NAME, LAST_NAME,  " +
					"   EMAIL, PHONE_NUMBER, HIRE_DATE,  " +
					"   JOB_ID, SALARY, COMMISSION_PCT,  " +
					"   MANAGER_ID, DEPARTMENT_ID " +
					" FROM HR.EMPLOYEES ";
			
			// 5. 쿼리를 실행한다.
			stmt = conn.prepareStatement(query);
			
			// 6. 쿼리에 실행결과를 얻어온다.
			rs = stmt.executeQuery();
			
			// 6-1. 쿼리의 실행결과를 List 객체에 할당한다.
			EmployeesVO employeesVO = null;
			List<EmployeesVO> employees = new ArrayList<EmployeesVO>();
			while ( rs.next() ) {
				// 6-2. ROW의 정보를 employeesVO에 셋팅한다.
				employeesVO = new EmployeesVO();
				employeesVO.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				employeesVO.setFirstName( rs.getString("FIRST_NAME") );
				employeesVO.setLastName( rs.getString("LAST_NAME") );
				employeesVO.setEmail( rs.getString("EMAIL") );
				employeesVO.setPhoneNumber( rs.getString("PHONE_NUMBER") );
				employeesVO.setHireDate( rs.getString("HIRE_DATE") );
				employeesVO.setJobId( rs.getString("JOB_ID") );
				employeesVO.setSalary( rs.getInt("SALARY") );
				employeesVO.setCommissionPct(rs.getDouble("COMMISSION_PCT") );
				employeesVO.setManagerId( rs.getInt("MANAGER_ID") );
				employeesVO.setDepartmentId( rs.getInt("DEPARTMENT_ID") );
				
				// 6-3. employees 에 employeesVO를 add 한다.
				employees.add(employeesVO);
			}
			
			// 7.  return 한다.
			return employees;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Oracle 인스턴스에 연결하지 못했습니다. 시스템을 종료합니다.");
			return null;
		} finally {
			try {
				// rs가 null이 아니라면 이라는 조건을 달아줘야 NullPointerException이 발생하지 않는다.
				// catch로 올 경우 위에서 선언을 null로 했기 때문에 null을 만나게 되서...
				if ( rs != null ) {
					rs.close();
				}
			} catch (SQLException e) {}
			try {
				if ( stmt != null ) {
					stmt.close();
				}
			} catch (SQLException e) {}
			try {
				if ( conn != null ) {
					conn.close();
				}
			} catch (SQLException e) {}
		}	
	}
	
	public List<DepartmentVO> getAllDepartments() {
		
		// 1. Oracle Driver Loading
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로딩 실패! 시스템을 종료합니다.");
			return null;
		}
		
		// 2. JDBC Instance 생성
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// 3. Oracle Instance에 연결
		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		try {
			conn = DriverManager.getConnection(oracleUrl, "HR", "HR");
			
			// 4. 쿼리를 만든다.
			String query = " SELECT " +
					" DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID " +
					" FROM HR.DEPARTMENTS ";
			
			// 5. 쿼리를 실행한다.
			stmt = conn.prepareStatement(query);
			
			// 6. 쿼리의 실행결과를 얻어온다.
			rs = stmt.executeQuery();
			
			// 6-1. 쿼리의 실행결과를 List 객체에 할당한다.
			DepartmentVO departmentsVO = null;
			List<DepartmentVO> departments = new ArrayList<DepartmentVO>();
			
			while ( rs.next() ) {
				// 6-2. ROW의 정보를 DepartmentVO에 셋팅한다.
				departmentsVO = new DepartmentVO();
				departmentsVO.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				departmentsVO.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
				departmentsVO.setManagerId(rs.getInt("MANAGER_ID"));
				departmentsVO.setLocationId(rs.getInt("LOCATION_ID"));
				
				// 6-3. departments에 departmentsVO를 add한다.
				departments.add(departmentsVO);
			}
			// 7. return 한다.
			return departments;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Oracle 인스턴스에 연결하지 못했습니다. 시스템을 종료합니다.");
			return null;
		} finally {
			try {
				if( rs != null) {
					rs.close();
				}
			} catch (SQLException e) {}
			try {
				if( stmt != null ) {
					stmt.close();
				}
			} catch (SQLException e) {}
			try {
				if( conn != null ) {
					conn.close();
				}
			} catch (SQLException e) {}
		}
		
	}

	@Override
	public List<EmployeesVO> getAllEmployeesWithDepartments() {
		// 1. Oracle Driver Loading
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e) {
					System.out.println("오라클 드라이버 로딩 실패! 시스템을 종료합니다.");
					return null;
				}
				
				// Database 교재 63p 참조. (JDBC API)
				// 2. JDBC Instance 생성
				// import java.spl 사용
				// 파이프를 이용해서 데이터를 던지고 나중에 파이프를 회수해야함.(finally에서 함)
				Connection conn = null;
				PreparedStatement stmt = null;
				ResultSet rs = null;
				
				// 3. Oracle Instance에 연결
				// getConnection 3번째꺼 사용.
				// windows는 @localhost 사용.
				String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";
				try {
					conn = DriverManager.getConnection(oracleUrl, "HR", "HR");
					
					// 4. 쿼리를 만든다.
					// 따옴표 앞/뒤는 띄어쓰기한다. 붙이면 에러남.
					String query = " SELECT  " 
							+ " E.EMPLOYEE_ID, E.FIRST_NAME, E.LAST_NAME,  " 
							+ " E.EMAIL, E.PHONE_NUMBER, E.HIRE_DATE,  " 
							+ " E.JOB_ID, E.SALARY, E.COMMISSION_PCT,  " 
							+ " E.MANAGER_ID, E.DEPARTMENT_ID, " 
							+ " D.DEPARTMENT_ID D_DEPARTMENT_ID, D.DEPARTMENT_NAME, "
							+ " D.MANAGER_ID D_MANAGER_ID, "
							+ " D.LOCATION_ID "
							+ " FROM EMPLOYEES E, "
							+ " DEPARTMENTS D "
							+ " WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID ";
					
					// 5. 쿼리를 실행한다.
					stmt = conn.prepareStatement(query);
					
					// 6. 쿼리에 실행결과를 얻어온다.
					rs = stmt.executeQuery();
					
					// 6-1. 쿼리의 실행결과를 List 객체에 할당한다.
					EmployeesVO employeesVO = null;
					DepartmentVO departmentVO = null;
					List<EmployeesVO> employees = new ArrayList<EmployeesVO>();
					while ( rs.next() ) {
						// 6-2. ROW의 정보를 employeesVO에 셋팅한다.
						employeesVO = new EmployeesVO();
						departmentVO = new DepartmentVO();
						employeesVO.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
						employeesVO.setFirstName( rs.getString("FIRST_NAME") );
						employeesVO.setLastName( rs.getString("LAST_NAME") );
						employeesVO.setEmail( rs.getString("EMAIL") );
						employeesVO.setPhoneNumber( rs.getString("PHONE_NUMBER") );
						employeesVO.setHireDate( rs.getString("HIRE_DATE") );
						employeesVO.setJobId( rs.getString("JOB_ID") );
						employeesVO.setSalary( rs.getInt("SALARY") );
						employeesVO.setCommissionPct(rs.getDouble("COMMISSION_PCT") );
						employeesVO.setManagerId( rs.getInt("MANAGER_ID") );
						employeesVO.setDepartmentId( rs.getInt("DEPARTMENT_ID") );
						
						// .으로 연결하는 것을 메소드 체이닝이라고 부름.
						departmentVO = employeesVO.getDepartments();
						departmentVO.setDepartmentId( rs.getInt("D_DEPARTMENT_ID") );
						departmentVO.setDepartmentName( rs.getString("DEPARTMENT_NAME") );
						departmentVO.setManagerId( rs.getInt("D_MANAGER_ID") );
						departmentVO.setLocationId( rs.getInt("LOCATION_ID") );
						
						// 6-3. employees 에 employeesVO를 add 한다.
						employees.add(employeesVO);
					}
					
					// 7.  return 한다.
					return employees;
					
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Oracle 인스턴스에 연결하지 못했습니다. 시스템을 종료합니다.");
					return null;
				} finally {
					try {
						// rs가 null이 아니라면 이라는 조건을 달아줘야 NullPointerException이 발생하지 않는다.
						// catch로 올 경우 위에서 선언을 null로 했기 때문에 null을 만나게 되서...
						if ( rs != null ) {
							rs.close();
						}
					} catch (SQLException e) {}
					try {
						if ( stmt != null ) {
							stmt.close();
						}
					} catch (SQLException e) {}
					try {
						if ( conn != null ) {
							conn.close();
						}
					} catch (SQLException e) {}
				}	
	}

	@Override
	public List<EmployeesVO> getAllEmployeesWithJobs() {
		// 1. Oracle Driver Loading
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로딩 실패! 시스템을 종료합니다.");
			return null;
		}
		
		// 2. JDBC Istance 생성.
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// 3. Oracle Instance에 연결.
		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		try {
			conn = DriverManager.getConnection(oracleUrl, "HR", "HR");
			
			// 4. 쿼리를 만든다.
			String query = " SELECT  " 
					+ " E.EMPLOYEE_ID, E.FIRST_NAME, E.LAST_NAME, " 
					+ " E.EMAIL, E.PHONE_NUMBER, E.HIRE_DATE, " 
					+ " E.JOB_ID, E.SALARY, E.COMMISSION_PCT, " 
					+ " E.MANAGER_ID, E.DEPARTMENT_ID, "
					+ " D.DEPARTMENT_ID D_DEPARTMENT_ID, "
					+ " D.DEPARTMENT_NAME, "
					+ " D.MANAGER_ID D_MANAGER_ID, "
					+ " D.LOCATION_ID, " 
					+ " J.JOB_ID J_JOB_ID, "
					+ " J.JOB_TITLE, "
					+ " J.MIN_SALARY, J.MAX_SALARY "
					+ " FROM EMPLOYEES E, "
					+ " DEPARTMENTS D, "
					+ " JOBS J "
					+ " WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID "
					+ " AND E.JOB_ID = J.JOB_ID ";
			
			// 5. 쿼리를 실행한다.
			stmt = conn.prepareStatement(query);
			
			// 6. 쿼리에 실행결과를 얻어온다.
			rs = stmt.executeQuery();
			
			// 6-1. 쿼리의 실행결과를 List 객체에 할당한다.
			EmployeesVO employeesVO = null;
			DepartmentVO departmentVO = null;
			JobsVO jobsVO = null;
			List<EmployeesVO> employees = new ArrayList<EmployeesVO>();
			while ( rs.next() ) {
				// 6-2. ROW의 정보를 employeesVO에 셋팅한다.
				employeesVO = new EmployeesVO();
				departmentVO = new DepartmentVO();
				jobsVO = new JobsVO();
				employeesVO.setEmployeeId( rs.getInt("EMPLOYEE_ID") );
				employeesVO.setFirstName( rs.getString("FIRST_NAME") );
				employeesVO.setLastName( rs.getString("LAST_NAME") );
				employeesVO.setEmail( rs.getString("Email") );
				employeesVO.setPhoneNumber( rs.getString("PHONE_NUMBER") );
				employeesVO.setHireDate( rs.getString("HIRE_DATE") );
				employeesVO.setJobId( rs.getString("JOB_ID") );
				employeesVO.setSalary( rs.getInt("SALARY") );
				employeesVO.setCommissionPct( rs.getDouble("COMMISSION_PCT") );
				employeesVO.setManagerId( rs.getInt("MANAGER_ID") );
				employeesVO.setDepartmentId( rs.getInt("DEPARTMENT_ID") );
				
				departmentVO = employeesVO.getDepartments();
				departmentVO.setDepartmentId( rs.getInt("D_DEPARTMENT_ID") );
				departmentVO.setDepartmentName( rs.getString("DEPARTMENT_NAME") );
				departmentVO.setManagerId( rs.getInt("D_MANAGER_ID") );
				departmentVO.setLocationId( rs.getInt("LOCATION_ID") );
				
				jobsVO = employeesVO.getJobs();
				jobsVO.setJobId( rs.getString("J_JOB_ID") );
				jobsVO.setJobTitle( rs.getString("JOB_TITLE") );
				jobsVO.setMinSalary( rs.getInt("MIN_SALARY") );
				jobsVO.setMaxSalary( rs.getInt("MAX_SALARY") );
				
				// 6-3. employees에 employeesVO를 add 한다.
				employees.add(employeesVO);
			}
			
			// 7. return 한다.
			return employees;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Oracle 인스턴스에 연결하지 못했습니다. 시스템을 종료합니다.");
			return null;
		} finally {
			try {
				if ( rs != null ) {
					rs.close();
				}
			} catch (SQLException e) {}
			try {
				if ( stmt != null ) {
					stmt.close();
				}
			} catch (SQLException e) {}
			try {
				if ( conn != null ) {
					conn.close();
				}
			} catch (SQLException e) {}
		}
		
	}
	
}
