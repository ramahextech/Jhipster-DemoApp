package com.ahextech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ahextech.domain.UserProfile;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile,Integer> {
 
	
	
}
