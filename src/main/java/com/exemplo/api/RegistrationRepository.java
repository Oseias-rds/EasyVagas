package com.exemplo.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//banco de dados

@Repository
public interface RegistrationRepository extends CrudRepository<VacancyModel, Long> {
	
	public VacancyModel findByEmail(String email);
	

}

