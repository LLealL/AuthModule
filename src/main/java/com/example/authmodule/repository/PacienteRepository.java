package com.example.authmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.authmodule.models.Paciente;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

    Paciente findPacienteByCpf(String cpf);

}
