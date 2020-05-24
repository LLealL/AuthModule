package com.example.authmodule.paciente.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.authmodule.models.User;
import com.example.authmodule.paciente.model.Paciente;
import com.example.authmodule.paciente.repository.PacienteRepository;
import com.example.authmodule.repository.UserRepository;


@Service
public class PacienteService {
	@Autowired
	PacienteRepository pacienteRepository;
	@Autowired
	UserRepository userRepository;
	
	public ResponseEntity<?> cadastrarPaciente(Paciente paciente) {

		
		Paciente pacienteExist = pacienteRepository.findById(paciente.getId()).orElse(null);

		if (pacienteExist != null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Paciente já cadastrado!");
		}
		
		Optional<User> u = userRepository.findById(paciente.getUser().getId());
		
		User user = u.get();
		
		paciente.setUser(user);

		pacienteRepository.save(paciente);

		return ResponseEntity.ok().build();

	}
	
	public ResponseEntity<?> listarPacientes(int idHospital) {
		
		List<Paciente> pacientes = pacienteRepository.findAll();
		
		return ResponseEntity.ok(pacientes.stream().filter(x -> x.getId() == idHospital).collect(Collectors.toList()));
	}
	
	public ResponseEntity<?> consultarPaciente(int id) {

		return ResponseEntity.ok(pacienteRepository.findById(id));

	}

	public ResponseEntity<?> editarPaciente(Paciente paciente) {

		Paciente pacienteExist = pacienteRepository.findById(paciente.getId()).orElse(null);

		if (pacienteExist == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}

		return ResponseEntity.ok(pacienteRepository.save(paciente));
	}

	public ResponseEntity<?> removerPaciente(int id) {
		Paciente pacienteExist = pacienteRepository.findById(id).orElse(null);

		if (pacienteExist == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
		pacienteRepository.delete(pacienteExist);
		return ResponseEntity.ok(pacienteExist);
	}


}

