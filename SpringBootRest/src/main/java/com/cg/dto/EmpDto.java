package com.cg.dto;

import java.time.LocalDate;

public class EmpDto {
	private int empId;
	private String empName;
	private double empSal;
	private LocalDate doj;
	private String DeptName;

	public EmpDto() {

	}

	public EmpDto(int empId, String empName, double empSal, LocalDate doj, String deptName) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.doj = doj;
		DeptName = deptName;
	}

	public EmpDto(String empName, double empSal, LocalDate doj, String deptName) {
		super();

		this.empName = empName;
		this.empSal = empSal;
		this.doj = doj;
		DeptName = deptName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public String getDeptName() {
		return DeptName;
	}

	public void setDeptName(String deptName) {
		DeptName = deptName;
	}

}
