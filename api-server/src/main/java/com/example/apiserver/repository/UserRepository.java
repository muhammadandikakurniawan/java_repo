package com.example.apiserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiserver.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel,Integer> {

}
