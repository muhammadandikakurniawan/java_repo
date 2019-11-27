package com.crud.crud.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
@Entity
@Table(name = "tb_user2")
@Immutable
public class UserModel{
	
	@Id
	@GeneratedValue
	public Long id;
	
	@Column(name = "user_name")
	public String user_name;

	@Column(name = "user_password")
	public String user_password;
	
	@Column(name = "user_pict")
	public String user_pict;
	
	public UserModel(String name,String pass, String pict) {
		this.user_name = name;
		this.user_password = pass;
		this.user_pict = pict;
	}
//	
//	@Id
//	@GeneratedValue
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	@Column(name = "user_name")
//	public String getUser_name() {
//		return user_name;
//	}
//
//	public void setUser_name(String user_name) {
//		this.user_name = user_name;
//	}
//
//	@Column(name = "user_password")
//	public String getUser_password() {
//		return user_password;
//	}
//
//	public void setUser_password(String user_password) {
//		this.user_password = user_password;
//	}
//	
//	@Column(name = "user_pict")
//	public String getUser_pict() {
//		return user_pict;
//	}
//
//	public void setUser_pict(String user_pict) {
//		this.user_pict = user_pict;
//	}

}
