package com.cg;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.dao.IDeptDao;
import com.cg.dao.IEmpDao;
import com.cg.dto.EmpDto;
import com.cg.entity.Dept;
import com.cg.entity.Emp;
import com.cg.exceptions.DeptException;
import com.cg.service.EmpServiceImpl;
import com.cg.service.IEmpService;

@SpringBootTest
public class testAddEmp {
	@Mock
	private IEmpDao empdao;
	@Mock
	private IDeptDao deptdao;
	@InjectMocks
	private IEmpService service = new EmpServiceImpl();
	
	@BeforeEach
	public void beforeEach() {
		when(deptdao.findByDeptName("HR")).thenReturn(new Dept());
		when(deptdao.findByDeptName("Choukidar")).thenReturn(null);
		Emp persistedemp = new Emp(1001, "Dunkun", 42000.0, LocalDate.of(2019, 05, 05));
		when(empdao.save(any(Emp.class))).thenReturn(persistedemp);
	}
	@Test
	@DisplayName(value = "Test add employee for dept HR")
	public void testAddEmp1() throws DeptException {
		EmpDto empdto = new EmpDto(1001,"Henry", 42000.0, LocalDate.of(2014,01,05),"HR");
		//assertTrue(service.addEmployee(empdto) == 1001);
		assertNull(service.addEmployee(empdto));
	}
	@Test
	@DisplayName(value = "Test add employee for dept Choukidar")
	public void testAddEmp2() throws DeptException {
		EmpDto empdto = new EmpDto("Henry", 42000.0, LocalDate.of(2014,01,05),"Choukidar");
		assertThrows(DeptException.class, ()->service.addEmployee(empdto));
	}
	@Test
	@DisplayName(value = "Test add employee for dept HR")
	public void testAddEmp3() throws DeptException {
		EmpDto empdto = new EmpDto(1001,"Henry", 42000.0, LocalDate.of(2014,01,05),"HR");
		assertTrue(service.addEmployee(empdto) == 1001);
		
	}
}
