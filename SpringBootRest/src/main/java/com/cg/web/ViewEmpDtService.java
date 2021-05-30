package com.cg.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Emp;
import com.cg.exception.EmpNotFoundException;
import com.cg.service.IEmpService;

@RestController
public class ViewEmpDtService {
	@Autowired
	private IEmpService service;
	@GetMapping("viewbydt/{sdoj}/{edoj}")
	public List<Emp> viewEmployeeByDate(@DateTimeFormat(pattern = "dd-MM-yyyy")@PathVariable("sdoj") LocalDate startDate,@DateTimeFormat(pattern="dd-MM-yyyy") @PathVariable("edoj") LocalDate endDate) throws EmpNotFoundException{
		return service.viewEmployee(startDate, endDate);
		
	}

}
