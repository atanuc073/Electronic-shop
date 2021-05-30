package com.cg.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Dept;
// It Handles the Dept database
@Repository
public interface IDeptDao extends JpaRepository<Dept, Integer>{
	@Query("from Dept where deptName=:dname")
	public Dept findByDeptName(@Param("dname") String deptname);
}
