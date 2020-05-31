package com.example.authmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.authmodule.models.Paciente;


public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

}
