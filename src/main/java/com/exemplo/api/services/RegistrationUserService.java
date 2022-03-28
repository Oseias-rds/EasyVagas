package com.exemplo.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.api.DTOS.CreateUseresDTO;
import com.exemplo.api.models.ClientModel;
import com.exemplo.api.repositories.RegistrationUserRepository;

@Service
public class RegistrationUserService {

	
	@Autowired
	public RegistrationUserRepository registration;
	
	
	public ClientModel create(CreateUseresDTO obj) {
		ClientModel cm = new ClientModel();
		
		cm.setEmail(obj.getEmail());
		cm.setName(obj.getName());
		cm.setPassword(obj.getPassword());
		return registration.save(cm);
		
		
	}
	
	
	public ClientModel update(Long id, CreateUseresDTO newData) {
		Optional<ClientModel> cm = registration.findById(id);
		cm.get().setEmail(newData.getEmail());
		cm.get().setName(newData.getName());
		cm.get().setPassword(newData.getPassword());
		return registration.save(cm.get());
	}
	
	
	public void delete() {}
	
	public void read() {}

}
