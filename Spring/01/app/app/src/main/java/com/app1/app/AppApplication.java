package com.app1.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.app1.app.di.*;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AppApplication.class, args);
		
		EmployeeDI emp1 = context.getBean(EmployeeDI.class);
		emp1.setEmpName("andika");
		System.out.println("===================================================================");
		emp1.ShowName();
	}

}
