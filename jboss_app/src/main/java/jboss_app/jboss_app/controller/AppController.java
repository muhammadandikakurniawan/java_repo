package jboss_app.jboss_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@RequestMapping(value="/end1",method=RequestMethod.GET)
	public String End1() {
		return "hello world";
	}
	@RequestMapping(value="",method=RequestMethod.GET)
	public String End() {
		return "hello jboss";
	}
}
