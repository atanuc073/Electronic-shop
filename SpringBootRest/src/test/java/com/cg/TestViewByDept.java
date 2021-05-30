package com.cg;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.dao.IEmpDao;
import com.cg.entity.Emp;
import com.cg.exceptions.EmpNotFoundException;
import com.cg.service.EmpServiceImpl;
import com.cg.service.IEmpService;

@SpringBootTest
public class TestViewByDept {
	
	@Mock
	private IEmpDao empdao;
	
	@InjectMocks
	private IEmpService service = new EmpServiceImpl();
	
	@BeforeEach
	public void beforeEach() {
		List<Emp> lst = new ArrayList<>();
		lst.add(new Emp(1001, "Wriju", 8000.0, LocalDate.of(2016, 01, 01)));
		lst.add(new Emp(1001, "Shyam", 9000.0, LocalDate.of(2017, 03, 03)));
		List<Emp> lst2 = new ArrayList<>();
		when(empdao.viewEmployee("HR")).thenReturn(lst);
		when(empdao.viewEmployee("Choukidar")).thenReturn(lst2);
	}
	@Test
	@DisplayName(value = "test view by dept for hr")
	public void testViewByDept1() throws EmpNotFoundException {
		assertTrue(service.viewEmployee("HR").size()>0);
	}
	@Test
	@DisplayName(value = "test view by dept for wrong input")
	public void testViewByDept2() throws EmpNotFoundException {
		assertThrows(EmpNotFoundException.class, ()->service.viewEmployee("Choukidar"));
	}
}
