package com.example.authmodule.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.authmodule.models.Vaga;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long>{

}
