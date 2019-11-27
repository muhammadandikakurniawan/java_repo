package com.crud.crud.repository;

import org.springframework.stereotype.Repository;
import com.crud.crud.models.*;
import org.springframework.data.jpa.repository.*;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
	 
}
