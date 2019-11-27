package com.example.demo.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.*;

@RestController
@RequestMapping("/api")
public class Controller1Controller {
	
	@Autowired
	private EmployeeDI emp1;
	
	@RequestMapping(method = RequestMethod.GET, value="/mefirst")
	public HashMap<String,String> Me1() throws Exception{
		HashMap<String,String> res = new HashMap<String,String>();
		try {
			emp1.setEmpAge(25);
			emp1.setEmpName("Dimas");
			emp1.setEmpMobile("08123123123");
			emp1.setEmpPosition("staff");
			res.put("name", emp1.getEmpName());
			res.put("age", emp1.getEmpAge().toString());
			res.put("mobile", emp1.getEmpMobile());
			res.put("position", emp1.getEmpPosition());
		}
		finally {
			return res;
		}
	}
}
