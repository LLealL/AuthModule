package com.example.authmodule.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.authmodule.models.Paciente;
import com.example.authmodule.repository.PacienteRepository;
import com.example.authmodule.security.payload.response.MessageResponse;
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
	@Autowired
	PacienteRepository pacienteRepository;
	
	public ResponseEntity<?> cadastrarVaga(Vaga vaga) {

		
		Vaga vagaExist = vagaRepository.findById(vaga.getId()).orElse(null);

		if (vagaExist != null) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Quarto já cadastrado!"));
		}
		
		Optional<User> u = userRepository.findById(vaga.getUser().getId());
		
		User user = u.get();
		
		vaga.setUser(user);
		
		vaga.setSituacao("livre");

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
		
		for(Vaga vaga: vagasHospital) {
			vaga.getUser().setVagas(null);
		}
		
		//tESTE
		
		return ResponseEntity.ok(vagasHospital);
	}
	

	public ResponseEntity<?> consultarVaga(int id) {
		Optional<Vaga> v = vagaRepository.findById(id);
		
		Vaga vaga = v.get();
		
		vaga.getUser().setVagas(null);
		
		return ResponseEntity.ok(vaga);

	}

	public ResponseEntity<?> editarVaga(Vaga vaga) {

		Vaga vagaExist = vagaRepository.findById(vaga.getId()).orElse(null);

		if (vagaExist == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		if(vaga.getPaciente()!=null){
			Paciente pacienteFound = pacienteRepository.findPacienteByCpf(vaga.getPaciente().getCpf());


			if (pacienteFound == null) {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new MessageResponse("Error: Paciente não encontrado!"));
			}

			if(vagaRepository.existsVagaByPaciente(pacienteFound)){
				return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
			}

			List<Vaga> vagas = vagaRepository.findAll();
			
//			for(Vaga v: vagas) {
//				if(v.getPaciente().getCpf().equals(pacienteFound.getCpf())) {
//					return ResponseEntity.badRequest().body(new MessageResponse("Error: Paciente já alocado a uma vaga!"));
//				}
//			}
			vagaExist.setSituacao("ocupado");
			vagaExist.setPaciente(pacienteFound);
		}else{
			vagaExist.setSituacao("livre");
			vagaExist.setPaciente(null);
		}

		vagaExist.setDataAlocacao(vaga.getDataAlocacao());
		vagaExist.setNumeroQuarto(vaga.getNumeroQuarto());
		vagaExist.setDescricao(vaga.getDescricao());
		vagaExist.getUser().setVagas(null);

		return ResponseEntity.ok(vagaRepository.save(vagaExist));
	}

	public ResponseEntity<?> removerVaga(int id) {
		Vaga vagaExist = vagaRepository.findById(id).orElse(null);

		if (vagaExist == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		vagaRepository.delete(vagaExist);
		return ResponseEntity.ok(vagaExist);
	}



}
