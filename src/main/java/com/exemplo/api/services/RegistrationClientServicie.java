package com.exemplo.api.services;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.api.DTOS.CreateClientDTO;
import com.exemplo.api.models.ClientModel;
import com.exemplo.api.repositories.RegistrationClientRepository;

/*
 * AS CLASSES DE CADATRO-USUARIO E CADATRO-CLIENTE SEGUEM O MESMO PARAMETRO DE VERIFICAÇÃO
 * SENDO ASSIM AS CLASSES TERÃO UM SEGUIMENTO E PADRONIZAÇÃP UNICA 
 * OQUE VAI VARIAR SÃO AS HERANÇAS
 */

@Service
public class RegistrationClientServicie {
	
	
	@Autowired
	public RegistrationClientRepository registration;
	
	
	public ClientModel create(CreateClientDTO obj) throws Exception {
		ClientModel cm = new ClientModel();
		boolean verification = isValidEmail(obj.getEmail());
		
		if(verification == false) {
			throw new Exception("this email is invalid");
		}
		
		cm.setEmail(obj.getEmail());
		cm.setName(obj.getName());
		cm.setCpf(obj.getCpf());
		cm.setPassword(obj.getPassword());
		return registration.save(cm);
		
		
	}
	
	
	public ClientModel update(Long id, CreateClientDTO newData) throws Exception {
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
	
	//metodo para verificar se o CPF É VALIDO
	/*
	 * 
	 */

}
