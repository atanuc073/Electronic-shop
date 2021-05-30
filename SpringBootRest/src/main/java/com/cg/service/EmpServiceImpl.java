package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IDeptDao;
import com.cg.dao.IEmpDao;
import com.cg.dto.EmpDto;
import com.cg.entity.Dept;
import com.cg.entity.Emp;
import com.cg.exception.DeptException;
import com.cg.exception.EmpNotFoundException;
@Service("myser") // You need to give Service  which implements all the services
public class EmpServiceImpl implements IEmpService{
	//Dependencies
	@Autowired
	private IEmpDao empdao;
	@Autowired
	private IDeptDao deptdao;

	@Override
	public Integer addEmployee(EmpDto empdto) throws DeptException {
		// here you create a connection between the Emp class and EmpDto class
		Emp emp = new Emp();
		//you no need to set empId as it is Auto generated
		emp.setEmpName(empdto.getEmpName());
		emp.setEmpSal(empdto.getEmpSal());
		emp.setEmpdoj(empdto.getDoj());
		Dept dept =deptdao.findByDeptName(empdto.getDeptName());
		if(dept == null)
			throw new DeptException("No department Found");
		emp.setDept(dept);
		Emp persistedEmp = empdao.save(emp);
		return persistedEmp.getEmpId();
	}

	@Override
	public List<Emp> viewEmployee() throws EmpNotFoundException {
		return null;
	}

	@Override
	public Emp viewEmployee(int eid) throws EmpNotFoundException {
		return null;
	}

	@Override
	public List<Emp> viewEmployee(String deptname) throws EmpNotFoundException {
		return empdao.viewEmployee(deptname);
	}

	@Override
	public List<Emp> viewEmployee(LocalDate startdate, LocalDate enddate) throws EmpNotFoundException {
		List<Emp> lst = empdao.viewEmployee(startdate,enddate);
		if(lst.isEmpty())
			throw new EmpNotFoundException("No Employee Found");
		lst.sort((e1,e2)->e1.getEmpdoj().compareTo(e2.getEmpdoj()));
		return lst;
	}

	@Override
	public Integer editEmployee(EmpDto empdto) throws DeptException {
		if (empdao.findById(empdto.getEmpId()).isPresent()) {
			Emp emp = empdao.findById(empdto.getEmpId()).get();
			emp.setEmpName(empdto.getEmpName());
			emp.setEmpSal(empdto.getEmpSal());
			emp.setEmpdoj(empdto.getDoj());
			Dept dept =deptdao.findByDeptName(empdto.getDeptName());
			if(dept == null)
				throw new DeptException("No department Found");
			emp.setDept(dept);
			Emp updatedemp = empdao.save(emp);
			return updatedemp.getEmpId();
		}
		return null;
		
	}
	

}
