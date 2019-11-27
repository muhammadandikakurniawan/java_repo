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

@RequestMapping("/service")
@RestController
@CrossOrigin
public class ServicesController {
	@Autowired
	private EmailService emailservice;
	
	@RequestMapping(value = "/sendmail", method = RequestMethod.POST)
	public HashMap<String,String> SendMail(
			@RequestParam("receiver") String Rec,
			@RequestParam("body") String Body,
			@RequestParam("subject") String Subject
			) throws Exception
	{
		HashMap<String,String> res = new HashMap();
		try {
			this.emailservice.sendEmail(Rec,Body,Subject);
		}
		catch(Exception e) {
			res.put("Error message", e.toString());
		}
		res.put("receiver", Rec);
		res.put("message", Body);
		res.put("Subject", Subject);
		
		return res;
	}
}
