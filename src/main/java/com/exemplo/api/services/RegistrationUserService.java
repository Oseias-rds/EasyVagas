package com.exemplo.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.api.DTOS.CreateUseresDTO;
import com.exemplo.api.models.ClientModel;
import com.exemplo.api.repositories.RegistrationUserRepository;

//verificar email
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegistrationUserService {

	
	@Autowired
	public RegistrationUserRepository registration;
	
	
	public ClientModel create(CreateUseresDTO obj) throws Exception {
		ClientModel cm = new ClientModel();
		boolean verification = isValidEmail(obj.getEmail());
		
		if(verification == false) {
			throw new Exception("this email is invalid");
		}
		
		cm.setEmail(obj.getEmail());
		cm.setName(obj.getName());
		cm.setPassword(obj.getPassword());
		return registration.save(cm);
		
		
	}
	
	
	public ClientModel update(Long id, CreateUseresDTO newData) throws Exception {
		boolean verification = isValidEmail (newData.getEmail());
		
		//({!verification}=>>>>verificatio == false)
		if(!verification) {
			throw new Exception("this email is invalid");
		}
		
		
		Optional<ClientModel> cm = registration.findById(id);
		cm.get().setEmail(newData.getEmail());
		cm.get().setName(newData.getName());
		cm.get().setPassword(newData.getPassword());
		return registration.save(cm.get());
	}
	
	
	public void delete(Long id) {
		Optional<ClientModel> cm = registration.findById(id);
		registration.delete(cm.get());
	}
	
	public ClientModel read(Long id) {
		return registration.findById(id).get();
		
		
	}
	
	private boolean isValidEmail (String email) {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }
		

	
	
}
