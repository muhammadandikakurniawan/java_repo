package com.latihan.transaction.latihantransaction.controller;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.springframework.beans.factory.annotation.*;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

@RestController
@RequestMapping("/api")
public class TransController {
	
	@Autowired
	private JdbcTemplate JdbcTemplate;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@RequestMapping(value="/general",method=RequestMethod.POST)
	public HashMap<String,String> PostGeneral(){
		HashMap<String,String> result = new HashMap<String,String>();
		ArrayList<HashMap<String,String>> datas = new ArrayList<HashMap<String,String>>();
		
		datas.add(new HashMap<String,String>(){
			{
				put("name","dina");
				put("dept","it");
			}
		});
		datas.add(new HashMap<String,String>(){
			{
				put("name","rina");
				put("dept","dev");
			}
		});
		datas.add(new HashMap<String,String>(){
			{
				put("name","dim");
				put("dept","it");
			}
		});
		
		
		
		try {
			for(HashMap<String,String> data : datas) {
				this.JdbcTemplate.update("INSERT INTO tables.tb_trans(name,dept) values(?,?)",(prepare) -> {
						prepare.setString(1,data.get("name"));
						prepare.setString(2, data.get("dept"));
					});
			}
			result.put("message", "success");
		}
		catch(Exception e) {
			result.put("message", e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value="/transactional",method=RequestMethod.POST)
	@Transactional(rollbackFor = {Exception.class})
	public HashMap<String,String> PostTransactional(){
		HashMap<String,String> result = new HashMap<String,String>();
		ArrayList<HashMap<String,String>> datas = new ArrayList<HashMap<String,String>>();
		
		datas.add(new HashMap<String,String>(){
			{
				put("name","dina");
				put("dept","it");
			}
		});
		datas.add(new HashMap<String,String>(){
			{
				put("name","rina");
				put("dept","developer");
			}
		});
		datas.add(new HashMap<String,String>(){
			{
				put("name","dimas anggara putera");
				put("dept","it");
			}
		});
		try {
			for(HashMap<String,String> data : datas) {
				this.JdbcTemplate.update("INSERT INTO tables.tb_trans(name,dept) values(?,?)",(prepare) -> {
						prepare.setString(1,data.get("name"));
						prepare.setString(2, data.get("dept"));
					});
			}
			
			result.put("message", "success");
		}
		catch(Exception e) {
			result.put("message", e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value="/entitymanager",method=RequestMethod.POST)
	@Transactional(rollbackFor = {Exception.class},propagation=Propagation.REQUIRED)
	public HashMap<String,String> PostEntityManager(){
		HashMap<String,String> result = new HashMap<String,String>();
		ArrayList<HashMap<String,String>> datas = new ArrayList<HashMap<String,String>>();
		
		datas.add(new HashMap<String,String>(){
			{
				put("name","dina");
				put("dept","it");
			}
		});
		datas.add(new HashMap<String,String>(){
			{
				put("name","rina");
				put("dept","dev");
			}
		});
		datas.add(new HashMap<String,String>(){
			{
				put("name","dim");
				put("dept","it");
			}
		});
		try {
			for(HashMap<String,String> data : datas) {
				this.JdbcTemplate.update("INSERT INTO tables.tb_trans(name,dept) values(?,?)",(prepare) -> {
						prepare.setString(1,data.get("name"));
						prepare.setString(2, data.get("dept"));
					});
			}
			if(datas.size() > 2) {
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
//				TransactionInterceptor.currentTransactionStatus().flush();
			}
			result.put("message", "success");
		}
		catch(Exception e) {
			result.put("message", e.getMessage());
		}
		return result;
	}
}
