package com.project_jwt.project_jwt.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.project_jwt.project_jwt.filter.JwtFilter;

@Configuration
public class FilterConfig {
	
	@Bean
	public FilterRegistrationBean FilterRegistration() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new JwtFilter());
		filterRegistrationBean.addUrlPatterns("/jwt/*");
		return filterRegistrationBean;
	}
	
}
