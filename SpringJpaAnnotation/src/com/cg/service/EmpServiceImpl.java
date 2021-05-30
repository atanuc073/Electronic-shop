package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.IEmpDao;
import com.cg.dto.EmpDto;
import com.cg.entity.Dept;
import com.cg.entity.Emp;
import com.cg.exceptions.DeptException;
import com.cg.exceptions.EmpNotFoundException;

@Service("myservice")
@Transactional(readOnly=true)
public class EmpServiceImpl implements IEmpService{
	@Autowired
	private IEmpDao dao;

	@Override
	@Transactional(readOnly = false)
	public Integer addEmployee(EmpDto empdto) throws DeptException {
		// TODO Auto-generated method stub
		Emp emp =new Emp();
		emp.setEmpName(empdto.getEmpName());
		emp.setEmpSal(empdto.getEmpSal());
		emp.setDoj(empdto.getDoj());
		Dept dept =null;
		return null;
	}

	@Override
	public List<Emp> viewEmployee(String dept) throws EmpNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp viewEmployee(int eid) throws EmpNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> viewEmployee(LocalDate startDOJ, LocalDate endDoj) throws EmpNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> viewEmployee() throws EmpNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editEmployee(EmpDto empdto) throws DeptException, EmpNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeEmployee(int eid) throws EmpNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

}
