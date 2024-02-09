package com.channoufi.banking.repositories;

import com.channoufi.banking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User,Integer> {
	
}
