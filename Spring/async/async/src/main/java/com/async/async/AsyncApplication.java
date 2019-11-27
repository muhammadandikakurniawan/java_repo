package com.async.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.*;

@SpringBootApplication
@EnableAsync
public class AsyncApplication {
	
	@Async
	public static CompletableFuture<String> met1() {
		System.out.println("Method1");
		System.out.println("Method1000");
		return CompletableFuture.completedFuture("method1");
	}
	
	@Async
	public static CompletableFuture<String> met2() {
		System.out.println("Method2");
		return CompletableFuture.completedFuture("method2");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AsyncApplication.class, args);
		AsyncApplication.met1();
		AsyncApplication.met2();
		
		CompletableFuture<String> m1 = AsyncApplication.met1();
		
		System.out.println(m1);
	}

}
