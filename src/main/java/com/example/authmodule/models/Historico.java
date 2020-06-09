package com.example.authmodule.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="tb_historico")
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToOne
    public User hospital;

    @JsonFormat(pattern ="yyyy-MM-dd")
    public LocalDate data;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getHospital() {
        return hospital;
    }

    public void setHospital(User hospital) {
        this.hospital = hospital;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
