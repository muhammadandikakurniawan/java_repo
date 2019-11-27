package com.app.project.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

public class EmployeeDto {
	public Long id;
	public String name;
	public String position;
	public String identity;
	
	public EmployeeDto(Long id,String name,String position,String identity) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.identity = identity;
	}
}
