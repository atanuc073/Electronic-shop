package com.cg.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.entity.Dept;
import com.cg.entity.Emp;

@Repository
public class EmpDaoImpl implements IEmpDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Emp> viewEmployee() {
		TypedQuery<Emp> qry =em.createQuery("from Emp e inner join fetch e.dept",Emp.class);
		
		// TODO Auto-generated method stub
		return qry.getResultList();
	}

	@Override
	public List<Emp> viewEmployee(String dept) {
		// TODO Auto-generated method stub
		String jpql="from Emp e inner join fetch e.dept d where d.deptName=:dname";
		TypedQuery<Emp> qry =em.createQuery(jpql,Emp.class);
		qry.setParameter("dname", dept);
		return qry.getResultList();
	}

	@Override
	public List<Emp> viewEmployee(LocalDate startDt, LocalDate endDt) {
		// TODO Auto-generated method stub
		String jpql="from Emp e inner join fetch e.dept d where e.empDoj>=:startdoj and e.empDoj<=:enddoj";
		TypedQuery<Emp> qry = em.createQuery(jpql,Emp.class);
		return qry.getResultList();
	}

	@Override
	public Emp viewEmployee(int eid) {
		// TODO Auto-generated method stub
		
		return em.find(Emp.class,eid);
	}

	@Override
	public Emp addEmployee(Emp emp) {
		// TODO Auto-generated method stub
		em.persist(emp);
		return emp;
	}

	@Override
	public boolean editEmployee(Emp emp) {
		// TODO Auto-generated method stub
		em.merge(emp);
		return true;
	}

	@Override
	public boolean removeEmployee(Emp emp) {
		// TODO Auto-generated method stub
		em.remove(emp);
		return true;
	}

	@Override
	public Integer getMaxId() {
		// TODO Auto-generated method stub
		String jpql="select max(empId) from Emp";
		TypedQuery<Integer> qry = em.createQuery(jpql,Integer.class);
		return qry.getSingleResult();
	}

	@Override
	public List<Dept> getDepartments() {
		// TODO Auto-generated method stub
		String jpql = "from Dept";
		TypedQuery<Dept> qry = em.createQuery(jpql,Dept.class);
		return qry.getResultList();
	}

	@Override
	public Dept getDepartment(String deptName) {
		// TODO Auto-generated method stub
		String jpql="from Dept where deptName=:dname";
		TypedQuery<Dept> qry = em.createQuery(jpql,Dept.class);
		return qry.getSingleResult();
	}
	

}
