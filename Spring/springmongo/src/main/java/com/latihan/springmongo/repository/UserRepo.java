package com.latihan.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.latihan.springmongo.model.User;

@Repository
public interface UserRepo extends MongoRepository<User,String>{

}
