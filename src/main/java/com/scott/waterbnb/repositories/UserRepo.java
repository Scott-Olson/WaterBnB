package com.scott.waterbnb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.scott.waterbnb.models.User;

public interface UserRepo extends CrudRepository<User, Long>{
	User findByEmail(String email);
	

}
