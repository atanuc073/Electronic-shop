package com.cg.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.EmpDto;
import com.cg.dto.SuccessMessage;
import com.cg.exception.DeptException;
import com.cg.exception.EmpNotFoundException;
import com.cg.exception.ValidateEmpException;
import com.cg.service.IEmpService;

@RestController // This is the Rest api
public class EmpCrudService {
	@Autowired
	private IEmpService service;
	
	@RequestMapping(value="addemployee",method=RequestMethod.POST)
	public SuccessMessage addEmployee(@RequestBody EmpDto empdto,BindingResult br) throws ValidateEmpException, DeptException {
		if(br.hasErrors())
			throw new ValidateEmpException(br.getFieldErrors());
		int eid = service.addEmployee(empdto);
		return new SuccessMessage(" your Generated Id is "+eid);
	}
	
	@PutMapping("editemployee")
	public SuccessMessage editEmployee(@RequestBody EmpDto empdto,BindingResult br) throws DeptException {
		Integer eid=service.editEmployee(empdto);
		return new SuccessMessage("Your Updated id Is"+eid);
		
	}

}
