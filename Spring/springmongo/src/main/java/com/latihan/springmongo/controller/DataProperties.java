package com.latihan.springmongo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/properties")
public class DataProperties {
	
	@Value("${app.name}")
	protected String appName;
	
	@RequestMapping(method=RequestMethod.GET)
	public HashMap<String,String> getProp(){
		String appName2 = this.appName;
		HashMap<String,String> res = new HashMap<String,String>(){
			{
				put("application_name",appName);
			}
		};
		
		return res;
	}
}
