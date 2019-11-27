package com.app.project.repository;

import java.util.*;
import com.app.project.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("EmployeeRepository")
public interface EmployeeRepository extends JpaRepository<TbEmployee, Integer>{
//	List<EmployeeModel> findByFirstName(String name);
//	List<EmployeeModel> findAll();
}
