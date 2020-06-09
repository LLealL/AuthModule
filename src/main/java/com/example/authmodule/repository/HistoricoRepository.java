package com.example.authmodule.repository;

import com.example.authmodule.models.Historico;
import com.example.authmodule.models.HistoricoGroup;
import com.example.authmodule.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface HistoricoRepository extends JpaRepository<Historico, Integer> {

    List<Historico> findHistoricosByHospital(User hospital);



    @Query("select new com.example.authmodule.models.HistoricoGroup(count(h.data),h.data,h.hospital.id) from Historico h group by h.data")
    List<HistoricoGroup> groupBy();
}
