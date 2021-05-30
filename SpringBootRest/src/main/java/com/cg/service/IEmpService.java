package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.dto.EmpDto;
import com.cg.entity.Emp;
import com.cg.exception.DeptException;
import com.cg.exception.EmpNotFoundException;
// It provides which method do I need in my service
public interface IEmpService {
	// It needs EmpDto instance to add employee
	public Integer addEmployee(EmpDto empdto) throws DeptException;
	public List<Emp> viewEmployee() throws EmpNotFoundException;
	public Emp viewEmployee(int eid) throws EmpNotFoundException;
	public List<Emp> viewEmployee(String deptname) throws EmpNotFoundException;
	public List<Emp> viewEmployee(LocalDate startdoj, LocalDate enddoj) throws EmpNotFoundException;
	public Integer editEmployee(EmpDto empdto) throws DeptException;
	

}
