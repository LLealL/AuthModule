package com.example.authmodule.repository;

import com.example.authmodule.models.User;
import com.example.authmodule.models.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);


    @Query("select new com.example.authmodule.models.UserGroup(u.nomeHospital,u.telefone,u.email,u.id) from User u")
    List<UserGroup> listAll();


}
