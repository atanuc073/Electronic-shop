package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.entity.Emp;
import com.cg.exceptions.DeptException;
import com.cg.exceptions.EmpNotFoundException;

public interface IEmpService {
	public Integer addEmployee(EmpDto empdto) throws DeptException;
	public List<Emp> viewEmployee(String dept) throws EmpNotFoundException;
	public Emp viewEmployee(int eid) throws EmpNotFoundException;
	public List<Emp> viewEmployee(LocalDate startDOJ,LocalDate endDoj) throws EmpNotFoundException;
	public List<Emp> viewEmployee()throws EmpNotFoundException;
	public boolean editEmployee(EmpDto empdto)throws DeptException,EmpNotFoundException;
	public boolean removeEmployee(int eid)throws EmpNotFoundException;

}
