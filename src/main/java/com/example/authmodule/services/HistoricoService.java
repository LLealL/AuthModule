package com.example.authmodule.services;


import com.example.authmodule.models.Historico;
import com.example.authmodule.models.HistoricoGroup;
import com.example.authmodule.models.Paciente;
import com.example.authmodule.models.User;
import com.example.authmodule.repository.HistoricoRepository;
import com.example.authmodule.repository.UserRepository;
import com.example.authmodule.security.payload.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class HistoricoService {

    @Autowired
    public HistoricoRepository historicoRepository;

    @Autowired
    public UserRepository userRepository;



    public void cadastrarHistórico(Historico h) {

        historicoRepository.save(h);

        return;

    }

    public ResponseEntity<?> listarHistorico(Long id) {

       Optional<User> userOp = userRepository.findById(id);
       User userFound = userOp.get();

       List<HistoricoGroup> usergroup = new LinkedList<HistoricoGroup>();
       if(userFound!=null) {

           // List<Historico> lista = historicoRepository.findHistoricosByHospital(userFound);
           List<HistoricoGroup> group = historicoRepository.groupBy();
           for (HistoricoGroup histGroup : group) {
               if (histGroup.getUser().getId() == userFound.getId()) {
                   usergroup.add(histGroup);
               }
           }
       }else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }

        return ResponseEntity.ok(usergroup);
    }


}
