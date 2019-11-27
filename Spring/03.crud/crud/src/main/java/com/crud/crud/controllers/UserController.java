package com.crud.crud.controllers;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.multipart.MultipartFile;

import com.crud.crud.dao.*;
import com.crud.crud.models.*;
import com.crud.crud.services.*;
import com.crud.crud.repository.*;

@RestController
@RequestMapping("/api")

public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private UserService service;
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	private UserDao user;
	
	@Autowired
	HttpServletRequest req;
	
	@Autowired
	HttpServletResponse res;
	
	@CrossOrigin
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<UserModel> GetUser(){
//		return this.user.GetModel();
//		this.UserRepo.save(new UserModel("dimas","dimas123","dimas.jpeg"));
//		List<UserModel> res = new ArrayList<>();
//	    this.repo.findAll().forEach(res::add);
//	    return service.Get();
		this.res.setHeader("Access-Control-Allow-Origin", "*");
		return this.user.GetModel();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public HashMap<String,String> GetUser(
			@RequestParam("name") String name, 
			@RequestParam("password") String Password,
			@RequestParam("pict") MultipartFile pict) throws Exception{
		HashMap<String,String> result = new HashMap<String,String>();
		this.res.setHeader("Access-Control-Allow-Origin", "*");
		result.put("result", (this.user.InsertModel(name, Password, pict) >= 1) ? "success" : "fail");
		return result;
	}
//	
//	@RequestMapping(value = "/cekreq", method = RequestMethod.POST)
//	public HashMap<String,String> CekRequest(){
//		HashMap<String,String> res = new HashMap<String,String>();
//		res.put("header", this.req.getHeader("Content-Type"));
//		res.put("param",this.req.getParameter("data").toString());
//		res.put("authorization",this.req.getHeader("Authorization"));
//		
//		return res;
//	}
	
	
}
