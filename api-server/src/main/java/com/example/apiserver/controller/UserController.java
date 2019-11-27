package com.example.apiserver.controller;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.apiserver.model.UserModel;
import com.example.apiserver.repository.UserRepository;

import org.springframework.jdbc.core.JdbcTemplate;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	private EntityManagerFactory emf;
	
	@Autowired
	private UserRepository UserRepo;
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@RequestMapping(path="",method=RequestMethod.GET)
	public List<UserModel> GetUser(@RequestParam(value = "length",required = false,defaultValue = "") String length) {
		ArrayList<UserModel> result;
		EntityManager em = this.emf.createEntityManager();
		if(length.equalsIgnoreCase("")) {
			result = (ArrayList<UserModel>) this.jdbc.query("select * from tbl_user", 
					(res,renum) -> new UserModel(res.getInt("id"),res.getString("data")));
		}
		else {
//			result = (ArrayList<UserModel>) this.jdbc.query("select * from tbl_user limit "+length, 
//					(res,renum) -> new UserModel(res.getInt("id"),res.getString("data")));
			result = (ArrayList<UserModel>) this.UserRepo.findAll();
		}
//		return (ArrayList<UserModel>) this.UserRepo;
		return result;
	}
	

	@RequestMapping(path="",method=RequestMethod.POST)
	public HashMap<String,String> PostUser(@RequestParam("id") Integer id,@RequestParam("data") String data ){
//		UserModel user = new UserModel();
//		user.setId(id);
//		user.setData(data);
//		this.UserRepo.save(user);
		Integer proc = this.jdbc.update("insert into tbl_user(data) values(?)",data);
		HashMap<String,String> res = new HashMap<String,String>();
		res.put("result", "process");
		res.put("data", data);
		res.put("res", proc.toString());
		return res;
		
	}
	
}
