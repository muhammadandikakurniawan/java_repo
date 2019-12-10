package com.project_jwt.project_jwt.controller;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.fasterxml.jackson.core.JsonToken;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/")
public class ProjectController {
	
	@RequestMapping("/token")
	public HashMap<String,Object> Token(@RequestHeader(value = "Authorization") String auth,@RequestBody HashMap<String,Object> params){
		Date date = new Date();
		Date expireToken = new Date(date.getTime() + 60000); // 1 minute
		String key = Base64.encodeBase64String("key".getBytes());
		JwtBuilder jwt = Jwts.builder().setSubject(params.get("username").toString())
				.setExpiration(expireToken) // set expire token
				.claim("claim_username", params.get("username").toString())
				.setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256,params.get("username").toString());
		String token = jwt.compact();
		
		
		HashMap<String,Object> res = new HashMap<String,Object>(){
				{
					put("token",token);
					put("expire_token",expireToken);
					put("authorization",auth);
					put("key",key);
					put("time",date.getTime());
				}
			};
			
			System.out.println("=============================================== TOKEN CONTROLLER===============================================");
			System.out.println(res);
			System.out.println("=============================================== TOKEN CONTROLLER ===============================================");
		return res;
	}
	
	@Autowired
	private HttpServletRequest req;
	
	@RequestMapping("/jwt")
	public HashMap<String,Object> JwtEndPoint(@RequestHeader("Authorization") String auth) {
		HashMap<String,Object> res= new HashMap<String,Object>(){
			{
				put("message","succes");
				put("Authorization",auth);
			}
		};
		
		System.out.println("=============================================== JWT CONTROLLER===============================================");
		System.out.printf("auth header = %s",auth);
		System.out.println("");
//		System.out.print("request = ",req.getAttribute(""));
		System.out.println("=============================================== JWT CONTROLLER ===============================================");
		
		return res;
	}
	
}
