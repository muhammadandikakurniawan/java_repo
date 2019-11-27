package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		System.out.println("======================================================================");
//		EmployeeDI emp1 = (EmployeeDI)context.getBean("customBean");
//		emp1.setEmpName("andi");
//		emp1.ShowName();
//		
//		((EmployeeDI)context.getBean("customBean"));
		
//		emp3.ShowName();
		
		System.out.println("\n======================================================================");
	}

}
