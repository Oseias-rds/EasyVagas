package com.exemplo.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//mesmo metodos controller 

@Service
public class RegistrationService {
	
	@Autowired
	RegistrationRepository regRepository;
	
	
	
	
	public VacancyModel create(CreateDto obj) {
		VacancyModel vc = new VacancyModel();
		vc.setEmail(obj.getEmail());
		vc.setNumber(obj.getNumber());
		return regRepository.save(vc);
		
		
	}

	
	
	public VacancyModel update(long id, CreateDto newData) {
		
		
		Optional<VacancyModel> vm = regRepository.findById(id);
		vm.get().setNumber(newData.getNumber());
		return regRepository.save(vm.get());
		
		
	}
	
	
	
	
	
	public VacancyModel read(String email) {
		
		 return regRepository.findByEmail(email);
		
		
		
	}
	
	
	
	
	public void delete(long id) {
		Optional<VacancyModel> vm = regRepository.findById(id);
		regRepository.delete(vm.get()); 
	}
	
	
	
	
	
}




