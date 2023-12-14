package com.example.imen_abid_lsi3_mesure_glycemie.model;

public class User {
    private String userName;
    private String password;
    public User(String userName,String password){
        this.userName=userName;
        this.password=password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}

