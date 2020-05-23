package com.example.authmodule.paciente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.authmodule.paciente.model.Paciente;


public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

}
