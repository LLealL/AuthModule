package com.example.authmodule.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class HistoricoGroup {

    private Long count;

    @JsonFormat(pattern ="yyyy-MM-dd")
    private LocalDate data;
    private Long user;

    public HistoricoGroup(Long count, LocalDate data, Long user) {
        this.count = count;
        this.data = data;
        this.user = user;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }


    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }
}
