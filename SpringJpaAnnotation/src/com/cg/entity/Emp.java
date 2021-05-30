package com.cg.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="lpu_emp")
@DynamicUpdate
@DynamicInsert
public class Emp {
	@Id
	@Column(name="eid")
	private int empId;
	@Column(name="ename",length=25)
	private String empName;
	@Column(name="emp_sal")
	private double empSal;
	
	private LocalDate doj;
	@Transient
	private String strDoj;
	private Dept dept =new Dept();
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
	public String getStrDoj() {
		return strDoj;
	}
	public void setStrDoj(String strDoj) {
		this.strDoj = strDoj;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", doj=" + doj + ", strDoj="
				+ strDoj + ", dept=" + dept + "]";
	}
	
	
	
	
	

}
