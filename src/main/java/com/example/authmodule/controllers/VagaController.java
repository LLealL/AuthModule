package com.example.authmodule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.authmodule.models.Vaga;
import com.example.authmodule.services.VagaService;

@CrossOrigin(origins = "*",maxAge=3600)
@RestController
@RequestMapping("/vaga")
public class VagaController {
	@Autowired
	VagaService vagaService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> criarVaga(@RequestBody Vaga vaga) {
		return vagaService.cadastrarVaga(vaga);
	}
	
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<?> removerVaga(@PathVariable("id") int id){
		return vagaService.removerVaga(id);
	}

	@GetMapping("/listar/{id}")
	public ResponseEntity<?> listarVaga(@PathVariable("id") int id) {
		return vagaService.listarVagas(id);
	}
	@GetMapping("/consultar/{id}")
	public ResponseEntity<?> consultarVaga(@PathVariable("id") int id) {
		return vagaService.consultarVaga(id);
	}
	@PutMapping("/editar")
	public ResponseEntity<?> editarVaga(@RequestBody Vaga vaga) {
		return vagaService.editarVaga(vaga);

	}
	
}
