package com.app.project.model;

import java.io.Serializable;


import javax.persistence.*;

import org.hibernate.annotations.Immutable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity(name = "TbEmployee")
@Table(name = "TbEmployee")
@Immutable
public class TbEmployee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;
	
	@Column(name = "name")
	public String name;
	
	@Column(name = "position")
	public String position;
	
	@Column(name = "identity")
	public String identity;
	
	public TbEmployee(Integer id, String name, String position, String identity) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.identity = identity;
	}
	// @Id
//	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	//@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//@Column(name="position")
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name="identity")
	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}	
	
}
