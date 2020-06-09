package com.example.authmodule.controllers;

import com.example.authmodule.repository.HistoricoRepository;
import com.example.authmodule.services.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*",maxAge=3600)
@RestController
@RequestMapping("/historico")
public class HistoricoController {

    @Autowired
    HistoricoService historicoService;

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarHistorico(@PathVariable("id") Long id) {
        return historicoService.listarHistorico(id);
    }

}
