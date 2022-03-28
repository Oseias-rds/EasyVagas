package com.exemplo.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.api.DTOS.CreateDto;
import com.exemplo.api.DTOS.CreateUseresDTO;
import com.exemplo.api.models.ClientModel;
import com.exemplo.api.services.RegistrationUserService;

@RestController
@RequestMapping("/user")
public class RegisterUserController {

	@Autowired
	public RegistrationUserService registrtion;
	
	
	@PostMapping
	public ClientModel create(@Valid @RequestBody CreateUseresDTO obj) {
		return registrtion.create(obj);
	}
	
	
	@PatchMapping(value="/{id}")
	public ClientModel update(@PathVariable("id") long id, @RequestBody CreateUseresDTO newData) {
		return registrtion.update(id, newData);
	}
	
	@GetMapping
	public void read() {
		
	}
	
	@DeleteMapping("/{id}")
	public void delete() {}
	

}
