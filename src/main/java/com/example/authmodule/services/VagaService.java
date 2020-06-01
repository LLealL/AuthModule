package com.example.authmodule.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.authmodule.models.User;
import com.example.authmodule.models.Vaga;
import com.example.authmodule.repository.UserRepository;
import com.example.authmodule.repository.VagaRepository;

@Service
public class VagaService {

	@Autowired
	VagaRepository vagaRepository;
	@Autowired
	UserRepository userRepository;
	
	public ResponseEntity<?> cadastrarVaga(Vaga vaga) {

		
		Vaga vagaExist = vagaRepository.findById(vaga.getId()).orElse(null);

		if (vagaExist != null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Paciente já cadastrado!");
		}
		
		Optional<User> u = userRepository.findById(vaga.getUser().getId());
		
		User user = u.get();
		
		vaga.setUser(user);

		vagaRepository.save(vaga);

		return ResponseEntity.ok().build();

	}
	
	public ResponseEntity<?> listarVagas(int idUser) {
		
		List<Vaga> vagas = vagaRepository.findAll();
		
		List<Vaga> vagasHospital = new ArrayList<>();
		
		for(Vaga vaga: vagas) {
			if(vaga.getUser().getId() == idUser) {
				vagasHospital.add(vaga);
			}
		}
		return ResponseEntity.ok(vagasHospital);
	}
	
	public ResponseEntity<?> consultarVaga(int id) {

		return ResponseEntity.ok(vagaRepository.findById(id));

	}

	public ResponseEntity<?> editarVaga(Vaga vaga) {

		Vaga vagaExist = vagaRepository.findById(vaga.getId()).orElse(null);

		if (vagaExist == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
		
		vagaExist.setNumeroQuarto(vaga.getNumeroQuarto());
		vagaExist.setSituacao(vaga.getSituacao());
		

		return ResponseEntity.ok(vagaRepository.save(vagaExist));
	}

	public ResponseEntity<?> removerVaga(int id) {
		Vaga vagaExist = vagaRepository.findById(id).orElse(null);

		if (vagaExist == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
		vagaRepository.delete(vagaExist);
		return ResponseEntity.ok(vagaExist);
	}



}
