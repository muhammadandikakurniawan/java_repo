package com.app1.app.controllers;

import java.util.HashMap;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.app1.app.di.*;

@RestController
@RequestMapping("/api")
public class Controller1Controller {
	@RequestMapping(value = "/ep1", method = RequestMethod.GET)
	public HashMap<String,String> ep1() throws Exception {
		HashMap<String,String> res = new HashMap<String,String>();
		try {
			EmployeeDI emp1 = new EmployeeDI();
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
