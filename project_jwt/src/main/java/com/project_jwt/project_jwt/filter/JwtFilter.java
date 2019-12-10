package com.project_jwt.project_jwt.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.util.ContentCachingRequestWrapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

@Component
public class JwtFilter extends GenericFilterBean{
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chainFilter) throws IOException,ServletException{
		
		HttpServletResponse httpRes = (HttpServletResponse) res;
		HttpServletRequest httpReq = (HttpServletRequest) req;
		
		HashMap<String,Object> reqBody = this.getReqBody(httpReq);
		
		String Authorization = httpReq.getHeader("Authorization"); 
		
		System.out.println("auth = "+Authorization);
		System.out.println("=============================================== FILTER ===============================================");
		System.out.println(reqBody.get("username"));
		System.out.println(reqBody);
		if(Authorization == null || !Authorization.startsWith("Bearer ")) {
			throw new ServletException("401 - UNAUTHORIZE");
		}
		String key = Base64.encodeBase64String("key".getBytes());
		try {
			Claims claims = Jwts.parser().setSigningKey(reqBody.get("username").toString()).parseClaimsJws(Authorization.substring(7)).getBody();
			httpReq.setAttribute("claims", claims);
			
			System.out.println("claim = "+claims);
			System.out.println("key = "+key);
			
		}catch(SignatureException ex) {
			throw new ServletException("401 - UNAUTHORIZE");
		}
		
		chainFilter.doFilter(req, res);
		
	}
	
	public HashMap<String,Object> getReqBody(HttpServletRequest httpReq) throws IOException{
		HttpServletRequestWrapper reqContentWrapper = new HttpServletRequestWrapper(httpReq);
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(reqContentWrapper.getInputStream()));
		char[] charBuffer = new char[128];
		int byteRead = -1;
		
		StringBuilder strBuilder = new StringBuilder();
		
		ObjectMapper objMapper = new ObjectMapper();
		
		while((byteRead = bufferReader.read(charBuffer)) != -1) {
			strBuilder.append(charBuffer,0,byteRead);
		}
		
		HashMap<String,Object> reqBody = objMapper.readValue(strBuilder.toString(),HashMap.class);
		
		return reqBody;
	}
	
}
