package com.exemplo.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.api.DTOS.CreateClientDTO;
import com.exemplo.api.models.ClientModel;
import com.exemplo.api.services.RegistrationClientServicie;

@RestController
@RequestMapping("/client")
public class RegisterClientController {

	@Autowired
	public RegistrationClientServicie registration;
	
	@PostMapping
	public ClientModel create(@Valid @RequestBody CreateClientDTO obj) throws Exception {
		return registration.create(obj);
	}
	

	@PatchMapping(value="/{id}")
	public ClientModel update(@PathVariable("id") long id, @RequestBody CreateClientDTO newData) throws Exception {
		return registration.update(id, newData);
	}
	
	@GetMapping
	@PatchMapping(value="/{id}")
	public ClientModel read(@PathVariable ("id") Long id) {
		return registration.read(id);
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable ("id") Long id) {
		registration.delete(id);
	}
}
