package com.latihan.springmongo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.latihan.springmongo.model.User;
import com.latihan.springmongo.repository.UserRepo;

@RestController
@RequestMapping("/mongo/api")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
    private MongoTemplate mongoTemplate;
	
	@Autowired
	private HttpServletRequest req;
	
//	@RequestMapping(method=RequestMethod.POST)
//	public User UserPost(@RequestParam("id") String id, @RequestParam("user_name") String user_name, @RequestParam("user_email") String user_email,@RequestParam("user_password") String user_password) {
//		User data = new User();
//		data.setId(id);
//		data.setUser_name(user_name);
//		data.setUser_email(user_email);
//		data.setUser_password(user_password);
//		this.userRepo.save(data);
//		return data;
//	}
	
	@RequestMapping(headers= {"Accept=application/json"}, produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},method=RequestMethod.POST)
	@CrossOrigin
	public User UserPost(@RequestBody User data) {
		userRepo.save(data);
		return data;
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@CrossOrigin
	public HashMap<String,String> UserTest(@RequestParam("file") MultipartFile file){
		HashMap<String,String> result = new HashMap<String,String>();
		try {
			String folder = "files/";
			File convertFile = new File(folder+file.getOriginalFilename());
			convertFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(convertFile);
			fout.write(file.getBytes());
			fout.close();
			result.put("res", "success");
		}
		catch (Exception e) {
			result.put("res", e.toString());
		}
		return result;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@CrossOrigin
	public List<User> UserGet(){
		Query query = new Query();
//		query.addCriteria(Criteria.where("user_name").is(this.req.getParameter("name")));
//		return (List<User>)this.mongoTemplate.find(query,User.class);
		String name = this.req.getParameter("name");
		List<User> result;
		try {
			if(!name.equalsIgnoreCase(null)) {
				BasicQuery query2 = new BasicQuery("{\"user_name\": {$regex : '" + name + "'} }");
				result =  (List<User>) this.mongoTemplate.find(query2, User.class);
			}
			else {
				result = (List<User>) this.userRepo.findAll();
			}
		}
		catch (Exception e) {
			result = (List<User>) this.userRepo.findAll();
		}
		return result;
	}
	
}
