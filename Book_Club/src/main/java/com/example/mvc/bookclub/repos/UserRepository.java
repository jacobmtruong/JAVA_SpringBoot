package com.example.mvc.bookclub.repos;

import java.util.Optional;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mvc.bookclub.models.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	Optional<User> findByEmail(String email);
	
//	Optional<User> findByUserName (String userName);
}
