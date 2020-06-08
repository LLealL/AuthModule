package com.example.authmodule.repository;
import com.example.authmodule.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.authmodule.models.Vaga;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Integer>{

    boolean existsVagaByPaciente(Paciente p);

}
