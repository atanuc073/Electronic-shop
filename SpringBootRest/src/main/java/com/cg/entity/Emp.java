package com.cg.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cg_emp")
public class Emp {
	@Id
	@Column(name="emp_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	@Column(name="emp_name",length=30,nullable=false)
	private String empName;
	@Column(name="emp_sal")
	private Double empSal;
	@Column(name="emp_doj")
	private LocalDate empdoj;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="did",referencedColumnName = "dept_id")
	private Dept dept;
	

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(Integer empId, String empName, Double empSal, LocalDate empdoj) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.empdoj = empdoj;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}

	public LocalDate getEmpdoj() {
		return empdoj;
	}

	public void setEmpdoj(LocalDate empdoj) {
		this.empdoj = empdoj;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return empName+" "+empId+" "+empSal+" "+empdoj;
	}
	

}
