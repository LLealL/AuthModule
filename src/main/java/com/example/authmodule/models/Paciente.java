package com.example.authmodule.models;


import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.Constraint;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="tb_paciente")
public class Paciente implements Serializable{

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;


	private String nome;

	private String email;
	
	private String telefone;

	@NotBlank
	@Column(unique=true)
	private String cpf;

	private LocalDateTime nascimento;
	
	public Paciente() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
