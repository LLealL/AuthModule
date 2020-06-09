package com.example.authmodule.models;

import java.time.LocalDate;

public class HistoricoGroup {

    private int count;
    private LocalDate data;
    private User user;

    public HistoricoGroup(int count, LocalDate data, User user) {
        this.count = count;
        this.data = data;
        this.user = user;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
