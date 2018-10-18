package com.ahextech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ahextech.domain.RegistrationEntity;

@Repository
public interface RegistrationRepository extends CrudRepository<RegistrationEntity,Integer> {
	RegistrationEntity findByEmail(String  email);
}
