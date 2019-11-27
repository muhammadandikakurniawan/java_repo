package com.apirealtime.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.apirealtime.model.UserModel;


@Service
public class UserService {
	
	@Autowired
	private MongoTemplate mongoTmp;
	
	public List<Object> GetUser(){
		List<Object> result = new ArrayList<Object>();
		try {
			BasicQuery query = new BasicQuery("{}");
			result = (List<Object>) this.mongoTmp.find(query, Object.class,"tb_user");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public String AddUser(String username, String email,String password) {
		String result = "fail";
		try {
			BasicQuery query = new BasicQuery("{}");
			UserModel data = this.mongoTmp.findOne(query.limit(1).skip(this.GetUser().size()-1),UserModel.class,"tb_user");
			
			String setId = Integer.toString(Integer.valueOf(data.getId())+1);
			
			UserModel dataUser = new UserModel();
			dataUser.setId(Integer.toString(this.GetUser().size()+1));
			dataUser.setUser_name(username);
			dataUser.setUser_email(email);
			dataUser.setUser_password(password);
			
			this.mongoTmp.insert(dataUser,"tb_user");
			result = "success";
		}
		catch (Exception e) {
			e.printStackTrace();
			result = e.getMessage().toString();
		}
		
		return result;
	}
	
}
