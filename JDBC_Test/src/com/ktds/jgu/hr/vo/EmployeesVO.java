package com.ktds.jgu.hr.vo;

public class EmployeesVO {

	// 테이블 컬럼명을 변수로 적어주면 됨.
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String hireDate;
	private String jobId;
	private int salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;
	
	// Join 하기 위해 테이블의 VO를 추가.
	private DepartmentVO departments;
	private JobsVO jobs;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public double getCommissionPct() {
		return commissionPct;
	}
	public void setCommissionPct(double commissionPct) {
		this.commissionPct = commissionPct;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	// Join 하기 위해 추가한 테이블 VO의 getter, setter를 추가해준다.
	public DepartmentVO getDepartments() {
		// 체이닝을 해야하기 때문에 여기서 null 체크를 해준다.
		if ( departments == null ) {
			departments = new DepartmentVO();
		}
		return departments;
	}
	public void setDepartments(DepartmentVO departments) {
		this.departments = departments;
	}
	
	public JobsVO getJobs() {
		if ( jobs == null) {
			jobs = new JobsVO();
		}
		return jobs;
	}
	public void setJobs(JobsVO jobs) {
		this.jobs = jobs;
	}
	
}
