package com.example.authmodule.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.authmodule.security.payload.response.MessageResponse;
import com.sun.mail.iap.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.authmodule.models.Paciente;
import com.example.authmodule.models.User;
import com.example.authmodule.repository.PacienteRepository;
import com.example.authmodule.repository.UserRepository;


@Service
public class PacienteService {
	@Autowired
	PacienteRepository pacienteRepository;
	@Autowired
	UserRepository userRepository;
	
	public ResponseEntity<?> cadastrarPaciente(Paciente paciente) {

		
		//Paciente pacienteExist = pacienteRepository.findById(paciente.getId()).orElse(null);

		Paciente pacienteExist = pacienteRepository.findPacienteByCpf(paciente.getCpf());

		if (pacienteExist != null) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Paciente já cadastrado!"));
		}
		
		
		pacienteRepository.save(paciente);

		return ResponseEntity.ok().build();

	}
	
	public ResponseEntity<?> listarPacientes() {
		
		List<Paciente> pacientes = pacienteRepository.findAll();
		
		return ResponseEntity.ok(pacientes);
	}
	
	public ResponseEntity<?> consultarPaciente(int id) {

		return ResponseEntity.ok(pacienteRepository.findById(id));

	}

	public ResponseEntity<?> editarPaciente(Paciente paciente) {

		Paciente pacienteExist = pacienteRepository.findById(paciente.getId()).orElse(null);

		if (pacienteExist == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		pacienteExist.setEmail(paciente.getEmail());
		pacienteExist.setNome(paciente.getNome());
		pacienteExist.setDataNascimento(paciente.getDataNascimento());
		

		return ResponseEntity.ok(pacienteRepository.save(pacienteExist));
	}

	public ResponseEntity<?> removerPaciente(int id) {
		Paciente pacienteExist = pacienteRepository.findById(id).orElse(null);

		if (pacienteExist == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		try {
			pacienteRepository.delete(pacienteExist);
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
		}
		return ResponseEntity.ok(pacienteExist);
	}

	public ResponseEntity<?> findByCpf(String cpf){
		Paciente pacienteExist = pacienteRepository.findPacienteByCpf(cpf);

		if(pacienteExist == null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.ok(pacienteExist);
	}


}

