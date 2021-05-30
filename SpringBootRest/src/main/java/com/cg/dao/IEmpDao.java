package com.cg.dao;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
// Dao pakages always handles the DataBase
// Dao pakages handle interfaces
import org.springframework.stereotype.Repository;

import com.cg.entity.Emp;
// it handles Employee reppository
@Repository
public interface IEmpDao extends JpaRepository<Emp, Integer>{
	@Query("from Emp e inner join fetch e.dept d where d.deptName=:dname ")
	public List<Emp> viewEmployee(@Param("dname") String deptName);
	// custom method custom query
	@Query("from Emp e inner join fetch e.dept d where e.empdoj>=:startdoj and e.empdoj<=:enddoj")
	public List<Emp> viewEmployee(@Param("startdoj")LocalDate startdate,@Param("enddoj") LocalDate enddate);

}
