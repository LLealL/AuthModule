package com.example.authmodule.services;

import com.example.authmodule.models.Notification;
import com.example.authmodule.models.User;
import com.example.authmodule.repository.NotificationRepository;
import com.example.authmodule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    UserRepository userRepository;


    public ResponseEntity<?> addNotificação(Notification notificacao){
        Optional<User> userOp = userRepository.findById(notificacao.getReceiver().getId());
        Optional<User> userOp2 = userRepository.findById(notificacao.getSender().getId());

        User userReceiver = userOp.get();
        User userSender = userOp2.get();

        if(userReceiver== null || userSender==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        notificationRepository.save(notificacao);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> listarRecebidas(Long id){
        Optional<User> userOp = userRepository.findById(id);
        User userFound = userOp.get();

        if(userFound==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<Notification> lista = notificationRepository.findNotificationsByReceiver(userFound);

        return ResponseEntity.ok(lista);
    }

    public ResponseEntity<?> listarEnviadas(Long id){
        Optional<User> userOp = userRepository.findById(id);
        User userFound = userOp.get();

        if(userFound==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<Notification> lista = notificationRepository.findNotificationsBySender(userFound);

        return ResponseEntity.ok(lista);
    }



}
