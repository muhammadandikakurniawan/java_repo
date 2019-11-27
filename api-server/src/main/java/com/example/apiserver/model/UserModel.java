package com.example.apiserver.model;


import java.io.Serializable;

import javax.persistence.*;

@Entity 
@Table(name="tbl_user")
public class UserModel{
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="data")
	private String data;
	
	@Override
	public String toString() {
		return String.format(""
				+ "UserModel[id=%d,data=%s", 
				id, data);
	}
	
	public UserModel(Integer id, String data) {
		this.setId(id);
		this.setData(data);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	

}
