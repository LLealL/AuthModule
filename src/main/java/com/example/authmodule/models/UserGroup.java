package com.example.authmodule.models;

public class UserGroup {
    private String nomeHospital;
    private String telefone;
    private String email;
    private Long id;

    public UserGroup(String nomeHospital, String telefone, String email, Long id) {
        this.nomeHospital = nomeHospital;
        this.telefone = telefone;
        this.email = email;
        this.id = id;
    }

    public String getNomeHospital() {
        return nomeHospital;
    }

    public void setNomeHospital(String nomeHospital) {
        this.nomeHospital = nomeHospital;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
