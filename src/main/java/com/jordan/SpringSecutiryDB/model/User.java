package com.jordan.SpringSecutiryDB.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameUser;
    private String password;

    //Constructor
    public User(){

    }

    public User(Long id, String nameUser, String password){
        this.id = id;
        this.nameUser = nameUser;
        this.password = password;

    }

    //Setters and Getters
    public void setId(Long id){
        this.id = id;

    }
    public void setNameUser(String nameUser){
        this.nameUser = nameUser;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public Long getId(){
        return this.id;
    }
    public String getNameUser(){
        return this.nameUser;
    }
    public String getPassword(){
        return this.password;
    }
}
