package com.cg.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cg_dept")
public class Dept {
	@Id
	@Column(name="dept_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer deptId;

	@Column(name="dept_name",length=25)
	private String deptName;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return deptId+" "+deptName;
		
	}
	@OneToMany(mappedBy = "dept")
	@JsonIgnore
	private Set<Emp> employees;
	public Set<Emp> getemployees(){
		return employees;
	}
	public void setEmployees(Set<Emp> employees) {
		this.employees =employees;
	}
	
}
