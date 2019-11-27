package com.apirealtime.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.apirealtime.model.UserModel;
import com.apirealtime.service.UserService;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private List<SseEmitter> emitters = new CopyOnWriteArrayList<>();
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MongoTemplate mongoTmp;
	
	private Integer mockDataCounter = 0;
	private ArrayList<Integer> mockData = new ArrayList<Integer>() {{add(mockDataCounter);}};
	
	@RequestMapping(method=RequestMethod.GET)
	@CrossOrigin
	public SseEmitter getUser() throws IOException {
		SseEmitter sseEmitter = new SseEmitter();
//		sseEmitter.send(SseEmitter.event().name("postdata").data(this.userService.GetUser()));
//		sseEmitter.send(SseEmitter.event().name("openconnection").data(this.userService.GetUser()));
//		sseEmitter.send(SseEmitter.event().name("closeconnection").data(this.userService.GetUser()));
		
//		this.emitters.add(sseEmitter);
		
//		this.emitters.remove(sseEmitter);
//		sseEmitter.onCompletion(()->this.emitters.remove(sseEmitter));
		
//		ExecutorService executor = Executors.newSingleThreadExecutor();
//		
//		executor.execute(() -> 
//        {
//              try {
//            	  	sseEmitter.send(SseEmitter.event().name("postdata").data(this.userService.GetUser()));
//            	  	this.emitters.add(sseEmitter);
//                    sseEmitter.complete();
//
//              } catch (IOException e) {
//            	  sseEmitter.completeWithError(e);
//              }
//        });
//		sseEmitter.onCompletion(()->executor.shutdown());
		
		this.emitters.add(sseEmitter);
		
		sseEmitter.send(SseEmitter.event().name("set-data").data(this.mockData));
		
		sseEmitter.onCompletion(()->this.emitters.remove(sseEmitter));
		
		return sseEmitter;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@CrossOrigin
	public void postUser() {
//		String username,String email,String password
//		this.userService.AddUser(username, email, password);
		this.mockData.add((this.mockData.get((this.mockData.size()-1)))+1);
		for(SseEmitter emitter : this.emitters) {
			try {
				emitter.send(SseEmitter.event().name("post-data").data(this.mockData));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
}
