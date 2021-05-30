package com.cg.dao;

import java.time.LocalDate;
import java.util.List;

import com.cg.entity.Dept;
import com.cg.entity.Emp;

public interface IEmpDao {
	public List<Emp> viewEmployee();
	public List<Emp> viewEmployee(String dept);
	public List<Emp> viewEmployee(LocalDate startDt,LocalDate endDt);
	public Emp viewEmployee(int eid);
	public Emp addEmployee(Emp emp);
	public boolean editEmployee(Emp emp);
	public boolean removeEmployee(Emp emp);
	public Integer getMaxId();
	public List<Dept> getDepartments();
	public Dept getDepartment(String deptName);

}
