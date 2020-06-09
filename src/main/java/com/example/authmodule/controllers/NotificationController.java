package com.example.authmodule.controllers;

import com.example.authmodule.models.Notification;
import com.example.authmodule.models.Vaga;
import com.example.authmodule.services.HistoricoService;
import com.example.authmodule.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*",maxAge=3600)
@RestController
@RequestMapping("/notification")
public class NotificationController {
    
    @Autowired
    NotificationService notificationService;

    @PostMapping("/notificar")
    public ResponseEntity<?> criarNotificacao(@RequestBody Notification notification) {
        return notificationService.addNotificação(notification);
    }

    @GetMapping("/notificacoesRecebedidas/{id}")
    public ResponseEntity<?> listReceived(@PathVariable("id") Long id) {
        return notificationService.listarRecebidas(id);
    }

    @GetMapping("/notificacoesEnviadas/{id}")
    public ResponseEntity<?> listSent(@PathVariable("id") Long id) {
        return notificationService.listarEnviadas(id);
    }


}
