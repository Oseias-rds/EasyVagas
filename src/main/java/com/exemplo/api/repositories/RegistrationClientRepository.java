package com.exemplo.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exemplo.api.models.ClientModel;

@Repository
public interface RegistrationClientRepository extends CrudRepository<ClientModel, Long>{

}
