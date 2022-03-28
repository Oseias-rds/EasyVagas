package com.exemplo.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//*entidade do banco de dados (entity)


//*basicamente Uma entidade (Entity) é uma classe que irá representar uma tabela no banco de dados,
//*ou seja, é a classe que vamos persistir. Cada instancia de uma Entity é uma linha da tabela
//*
//*



@Entity
@Table(name="vacancy")
public class VacancyModel {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	



	@Column(name= "email")
	private String email;
	
	@Column(name= "number")
	private int number;

	
	
	public VacancyModel(String email, int number) {
		super();
		this.email = email;
		this.number = number;
		
	}


	public VacancyModel() {
		
		
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}
	
	
}

