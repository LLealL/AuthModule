package com.example.authmodule.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="tb_vaga")
public class Vaga {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;

	private int numeroQuarto;

	private String situacao;
<<<<<<< HEAD

	@OneToOne
	private Paciente paciente;

	@JsonBackReference
=======
	private String idPaciente;
	//@JsonBackReference
>>>>>>> 3830ce7638b6be6a6b40c0b483812003b8160ba9
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;


	public Vaga() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumeroQuarto() {
		return numeroQuarto;
	}
	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
