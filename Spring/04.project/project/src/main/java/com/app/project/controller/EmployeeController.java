package com.app.project.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.app.project.dto.*;
import com.app.project.model.*;
import com.app.project.repository.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository EmpRepo;
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public List<TbEmployee> GetEmployee(){
//		List<EmployeeDto> result = new ArrayList<EmployeeDto>();
//		for(EmployeeModel emp : this.EmpRepo.findAll()) {
//			result.add(new EmployeeDto(emp.getId(),emp.getName(),emp.getPosition(),emp.getIdentity()));
//		}	
		List<TbEmployee> result = this.EmpRepo.findAll();
		return result;
	}
	
}
