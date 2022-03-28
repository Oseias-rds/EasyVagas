package com.exemplo.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exemplo.api.models.VacancyModel;

//banco de dados

@Repository
public interface RegistrationRepository extends CrudRepository<VacancyModel, Long> {
	
	public VacancyModel findByEmail(String email);
	
}

