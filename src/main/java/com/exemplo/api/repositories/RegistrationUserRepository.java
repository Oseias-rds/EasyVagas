package com.exemplo.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exemplo.api.models.UserModel;

@Repository
public interface RegistrationUserRepository  extends CrudRepository<UserModel, Long>{

	
}
