package com.crud.crud.dao;
import java.io.*;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.ByteArrayInputStream;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.crud.crud.models.*;

@Component
public class UserDao {
	@Autowired
	private JdbcTemplate jdbc;
	
	public List<UserModel> GetModel(){
		return this.jdbc.query("select * from tables.tb_user", (res,rnum) -> new UserModel(
					res.getString("user_name"),
					res.getString("user_password"),
					res.getString("user_pict")
				)
			);
	}
	public Integer InsertModel(String name, String Password, MultipartFile pict) throws Exception {
		byte[] fileByteStream = pict.getBytes();
		String user_pict = Base64.getEncoder().encodeToString(fileByteStream);
		return this.jdbc.update("insert into tables.tb_user(user_name,user_password,user_pict) values(?,?,?)",name,Password,user_pict);
	}
}
