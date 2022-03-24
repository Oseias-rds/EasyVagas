package com.exemplo.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/teste")
public class RegisterController {
	
	@Autowired
	RegistrationService regService;
	
	@PostMapping
	public VacancyModel create(CreateDto obj) {
		return regService.create(obj);
		
		
	}

	
	@PatchMapping
	@PutMapping(value="/{id}")
	public VacancyModel update(@PathVariable("id") long id, @RequestBody CreateDto newData) {
		return regService.update(id, newData);
		
	}
	
	
	
	@GetMapping(value = "/{email}")
	public VacancyModel read(@PathVariable("email") String email) {
		return regService.read(email);
		
		
	}
	
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") long id) {
		regService.delete(id);
		
	}
	
	
	
	
	
}

