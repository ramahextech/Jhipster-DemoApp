package com.ahextech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ahextech.domain.Login;
@Repository
public interface LoginRepository extends CrudRepository<Login,Integer> {
   Login findByUuid(String uuid);
   Login findByEmail(String email);
}
