package com.ktds.jgu.hr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.jgu.hr.vo.CountriesVO;
import com.ktds.jgu.hr.vo.DepartmentVO;
import com.ktds.jgu.hr.vo.EmployeesVO;
import com.ktds.jgu.hr.vo.JobsVO;
import com.ktds.jgu.hr.vo.LocationsVO;
import com.ktds.jgu.hr.vo.RegionsVO;
import com.ktds.mcj.dao.support.JDBCDaoSupport;
import com.ktds.mcj.dao.support.QueryHandler;
import com.ktds.mcj.dao.support.annotation.BindData;

public class HRDaoImpl extends JDBCDaoSupport implements HRDao {

	@Override
	public List<EmployeesVO> getAllEmployees() {

		// QueryHandler가 인터페이스이기 때문에 구체화 하려면 클래스를 만들어야 하는데,
		// 클래스를 만드는 것 보다는 {}(중괄호)를 사용해서 생성과 동시에 구체화를 시켜줌.
		// QueryHandler가 selectList의 파라미터로 들어감.
		return selectList(new QueryHandler() {

			// 인터페이스에 있는 것을 구체화 시켜줌.
			@Override
			public String preparedQuery() {
				StringBuffer query = new StringBuffer();

				query.append(" SELECT 	EMPLOYEE_ID ");
				query.append(" 			, FIRST_NAME ");
				query.append(" 			, LAST_NAME ");
				query.append(" 			, EMAIL ");
				query.append(" 			, PHONE_NUMBER ");
				query.append(" 			, HIRE_DATE ");
				query.append(" 			, JOB_ID ");
				query.append(" 			, SALARY ");
				query.append(" 			, COMMISSION_PCT ");
				query.append(" 			, MANAGER_ID ");
				query.append(" 			, DEPARTMENT_ID ");
				query.append(" FROM 	EMPLOYEES ");
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
			String query = " SELECT " + " DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID "
					+ " FROM HR.DEPARTMENTS ";

			// 5. 쿼리를 실행한다.
			stmt = conn.prepareStatement(query);

			// 6. 쿼리의 실행결과를 얻어온다.
			rs = stmt.executeQuery();

			// 6-1. 쿼리의 실행결과를 List 객체에 할당한다.
			DepartmentVO departmentsVO = null;
			List<DepartmentVO> departments = new ArrayList<DepartmentVO>();

			while (rs.next()) {
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
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}

	}

	@Override
	public List<EmployeesVO> getAllEmployeesWithDepartments() {

		return selectList(new QueryHandler() {

			@Override
			public String preparedQuery() {
				String query = " SELECT  " + " E.EMPLOYEE_ID, E.FIRST_NAME, E.LAST_NAME,  "
						+ " E.EMAIL, E.PHONE_NUMBER, E.HIRE_DATE,  " + " E.JOB_ID, E.SALARY, E.COMMISSION_PCT,  "
						+ " E.MANAGER_ID, E.DEPARTMENT_ID, " + " D.DEPARTMENT_ID D_DEPARTMENT_ID, D.DEPARTMENT_NAME, "
						+ " D.MANAGER_ID D_MANAGER_ID, " + " D.LOCATION_ID " + " FROM EMPLOYEES E, " + " DEPARTMENTS D "
						+ " WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID ";
				return query;
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				// stmt.setInt(1, employeeId);
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
			String query = " SELECT  " + " E.EMPLOYEE_ID, E.FIRST_NAME, E.LAST_NAME, "
					+ " E.EMAIL, E.PHONE_NUMBER, E.HIRE_DATE, " + " E.JOB_ID, E.SALARY, E.COMMISSION_PCT, "
					+ " E.MANAGER_ID, E.DEPARTMENT_ID, " + " D.DEPARTMENT_ID D_DEPARTMENT_ID, " + " D.DEPARTMENT_NAME, "
					+ " D.MANAGER_ID D_MANAGER_ID, " + " D.LOCATION_ID, " + " J.JOB_ID J_JOB_ID, " + " J.JOB_TITLE, "
					+ " J.MIN_SALARY, J.MAX_SALARY " + " FROM EMPLOYEES E, " + " DEPARTMENTS D, " + " JOBS J "
					+ " WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID " + " AND E.JOB_ID = J.JOB_ID ";

			// 5. 쿼리를 실행한다.
			stmt = conn.prepareStatement(query);

			// 6. 쿼리에 실행결과를 얻어온다.
			rs = stmt.executeQuery();

			// 6-1. 쿼리의 실행결과를 List 객체에 할당한다.
			EmployeesVO employeesVO = null;
			DepartmentVO departmentVO = null;
			JobsVO jobsVO = null;
			List<EmployeesVO> employees = new ArrayList<EmployeesVO>();
			while (rs.next()) {
				// 6-2. ROW의 정보를 employeesVO에 셋팅한다.
				employeesVO = new EmployeesVO();
				departmentVO = new DepartmentVO();
				jobsVO = new JobsVO();

				employeesVO.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				employeesVO.setFirstName(rs.getString("FIRST_NAME"));
				employeesVO.setLastName(rs.getString("LAST_NAME"));
				employeesVO.setEmail(rs.getString("Email"));
				employeesVO.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				employeesVO.setHireDate(rs.getString("HIRE_DATE"));
				employeesVO.setJobId(rs.getString("JOB_ID"));
				employeesVO.setSalary(rs.getInt("SALARY"));
				employeesVO.setCommissionPct(rs.getDouble("COMMISSION_PCT"));
				employeesVO.setManagerId(rs.getInt("MANAGER_ID"));
				employeesVO.setDepartmentId(rs.getInt("DEPARTMENT_ID"));

				departmentVO = employeesVO.getDepartments();
				departmentVO.setDepartmentId(rs.getInt("D_DEPARTMENT_ID"));
				departmentVO.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
				departmentVO.setManagerId(rs.getInt("D_MANAGER_ID"));
				departmentVO.setLocationId(rs.getInt("LOCATION_ID"));

				jobsVO = employeesVO.getJobs();
				jobsVO.setJobId(rs.getString("J_JOB_ID"));
				jobsVO.setJobTitle(rs.getString("JOB_TITLE"));
				jobsVO.setMinSalary(rs.getInt("MIN_SALARY"));
				jobsVO.setMaxSalary(rs.getInt("MAX_SALARY"));

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
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}

	}

	@Override
	public List<DepartmentVO> getAllDepartmentsWithLocations() {

		// 1. Oracle Driver Loading.
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

		// 3. Oracle Instance에 연결.
		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		try {
			conn = DriverManager.getConnection(oracleUrl, "HR", "HR");

			// 4. 쿼리를 만든다.
			String query = " SELECT  " + " D.DEPARTMENT_ID, " + " D.DEPARTMENT_NAME, " + " D.MANAGER_ID, "
					+ " D.LOCATION_ID, " + " L.LOCATION_ID L_LOCATION_ID, " + " L.STREET_ADDRESS, " + " L.POSTAL_CODE, "
					+ " L.CITY, " + " L.STATE_PROVINCE, " + " L.COUNTRY_ID " + " FROM    DEPARTMENTS D, "
					+ " LOCATIONS L " + " WHERE D.LOCATION_ID = L.LOCATION_ID ";
			// 5. 쿼리를 실행한다.
			stmt = conn.prepareStatement(query);

			// 6. 쿼리에 실행결과를 얻어온다
			rs = stmt.executeQuery();

			// 6-1. 쿼리의 실행결과를 List 객체에 할당한다.
			DepartmentVO departmentsVO = null;
			LocationsVO locationsVO = null;
			List<DepartmentVO> departments = new ArrayList<DepartmentVO>();

			while (rs.next()) {
				// 6-2. ROW의 정보를 DepartmentVO에 넣어준다.
				departmentsVO = new DepartmentVO();
				locationsVO = new LocationsVO();

				departmentsVO.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				departmentsVO.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
				departmentsVO.setManagerId(rs.getInt("MANAGER_ID"));
				departmentsVO.setLocationId(rs.getInt("LOCATION_ID"));

				locationsVO = departmentsVO.getLocations();
				locationsVO.setLocationId(rs.getInt("L_LOCATION_ID"));
				locationsVO.setStreetAddress(rs.getString("STREET_ADDRESS"));
				locationsVO.setPostalCode(rs.getString("POSTAL_CODE"));
				locationsVO.setCity(rs.getString("CITY"));
				locationsVO.setStateProvince(rs.getString("STATE_PROVINCE"));
				locationsVO.setCountryId(rs.getString("COUNTRY_ID"));

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
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public List<CountriesVO> getAllCountriesWithRegions() {

		// 1. Oracle Driver Loading.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("오라클 드라이버 로딩 실패! 시스템을 종료합니다.");
			return null;
		}

		// 2. JDBC Instance 생성.
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// 3. Oracle Instance에 연결
		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		try {
			conn = DriverManager.getConnection(oracleUrl, "HR", "HR");

			// 4. 쿼리 만들기
			String query = " SELECT  " + " C.COUNTRY_ID, C.COUNTRY_NAME, " + " C.REGION_ID, "
					+ " R.REGION_ID R_REGION_ID, " + " R.REGION_NAME " + " FROM    COUNTRIES C," + " REGIONS R "
					+ " WHERE C.REGION_ID = R.REGION_ID ";

			// 5. 쿼리를 실행한다.
			stmt = conn.prepareStatement(query);

			// 6. 쿼리에 실행한 결과를 얻어온다.
			rs = stmt.executeQuery();

			// 6-1. 쿼리의 결과를 List 객체에 할당한다.
			CountriesVO countriesVO = null;
			RegionsVO regionsVO = null;
			List<CountriesVO> countries = new ArrayList<CountriesVO>();

			while (rs.next()) {
				// 6-2. Row의 정보를 CountriesVO에 넣어준다.
				countriesVO = new CountriesVO();
				regionsVO = new RegionsVO();

				countriesVO.setCountryId(rs.getString("COUNTRY_ID"));
				countriesVO.setCountryName(rs.getString("COUNTRY_NAME"));
				countriesVO.setRegionId(rs.getInt("REGION_ID"));

				regionsVO = countriesVO.getRegions();
				regionsVO.setRegionId(rs.getInt("R_REGION_ID"));
				regionsVO.setRegionName(rs.getString("REGION_NAME"));

				countries.add(countriesVO);
			}
			// 7. return 한다.
			return countries;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Oracle 인스턴스에 연결하지 못했습니다. 시스템을 종료합니다.");
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public EmployeesVO findOneEmployee(int employeeId) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		try {
			conn = DriverManager.getConnection(url, "HR", "HR");

			// 쿼리를 쉽게 가져올 수 있도록 StringBuffer를 사용.
			StringBuffer query = new StringBuffer();
			query.append(" SELECT	EMPLOYEE_ID ");
			query.append("			, FIRST_NAME ");
			query.append("			, LAST_NAME ");
			query.append("			, EMAIL ");
			query.append("			, PHONE_NUMBER ");
			query.append("			, JOB_ID ");
			query.append("			, HIRE_DATE ");
			query.append("			, SALARY ");
			query.append("			, COMMISSION_PCT ");
			query.append("			, MANAGER_ID ");
			query.append("			, DEPARTMENT_ID ");
			query.append(" FROM 	EMPLOYEES ");
			query.append(" WHERE 	EMPLOYEE_ID = ? ");
			// query.append(" WHERE EMPLOYEE_ID IN = (?, ?) ");
			// IN 하면, 1개가 나올 수도 있고 2개가 나올 수도 있다.

			// .toString()을 사용하여 String 형태로 바꾼다.
			stmt = conn.prepareStatement(query.toString());
			// 위에 쿼리에서 ?(물음표)가 있을 경우 아래를 적는다.
			stmt.setInt(1, employeeId); // index가 0으로 시작하는 것을 배열과 List 밖에 없음.

			rs = stmt.executeQuery();
			// 여기까지는 위에 쿼리에서 ?(물음표)가 없을 경우 에러가 안남.

			EmployeesVO employeesVO = null;
			if (rs.next()) {
				employeesVO = new EmployeesVO();

				// rs에 있는 데이터를 어디에 넣어줄 것인지 적는다.(employeesVO)
				BindData.bindData(rs, employeesVO);
				// employeesVO.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				// employeesVO.setFirstName(rs.getString("FIRST_NAME"));
				// employeesVO.setLastName(rs.getString("LAST_NAME"));
				// employeesVO.setEmail(rs.getString("EMAIL"));
				// employeesVO.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				// employeesVO.setHireDate(rs.getString("HIRE_DATE"));
				// employeesVO.setJobId(rs.getString("JOB_ID"));
				// employeesVO.setSalary(rs.getInt("SALARY"));
				// employeesVO.setCommissionPct(rs.getDouble("COMMISSION_PCT"));
				// employeesVO.setManagerId(rs.getInt("MANAGER_ID"));
				// employeesVO.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
			}
			return employeesVO;

			// Toggle Block Selection Mode (Alt + Shift + A) 로 쉽게 작성.
			// 쿼리문만 쓰고 쿼리문 앞에서 쿼리문 만큼 세로로 선을 그어준 후, 앞에 필요한 코드를 작성함.
			// query.append(" SELECT EMPLOYEE_ID ");
			// query.append(" , FIRST_NAME ");
			// query.append(" , LAST_NAME ");
			// query.append(" FROM EMPLOYEES ");

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// try가 밖에 있는 것 보다 if가 밖에 있을 때, 실행 속도가 더 빠르다.
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
