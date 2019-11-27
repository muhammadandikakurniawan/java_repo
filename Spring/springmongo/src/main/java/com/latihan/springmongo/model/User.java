package com.latihan.springmongo.model;

import java.io.File;
import java.util.Date;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="tb_user")
public class User {
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	@Id
	private String id;
//	@Field("user_name")
	private String user_name;
//	@Field("user_email")
	private String user_email;
//	@Field("user_password")
	private String user_password;
	
	private MultipartFile user_pict;

	public MultipartFile getUser_pict() {
		return user_pict;
	}
	public void setUser_pict(MultipartFile user_pict) {
		this.user_pict = user_pict;
	}
	
}
