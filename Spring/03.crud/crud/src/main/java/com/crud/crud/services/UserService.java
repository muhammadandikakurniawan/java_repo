package com.crud.crud.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.crud.repository.*;
import com.crud.crud.models.*;
import com.crud.crud.dao.*;
import com.crud.crud.controllers.*;

@Service
public class UserService{
	@Autowired
	private UserRepository repo;
	
	public List<UserModel> Get(){
		return (List<UserModel>) this.repo.findAll();
	}
}
