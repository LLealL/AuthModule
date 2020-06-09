package com.example.authmodule.repository;

import com.example.authmodule.models.Notification;
import com.example.authmodule.models.User;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findNotificationsBySender(User sender);
    List<Notification> findNotificationsByReceiver(User receiver);
}
