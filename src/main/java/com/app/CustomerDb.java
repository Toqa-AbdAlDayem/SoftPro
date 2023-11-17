package com.app;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "customer")
public class CustomerDb {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CUST_ID")
    private int id;
    private String name;
    private String email;
 private String pass;
 private String conf_pass;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="birthdate")
 private Date birthDate;
 private String gender;
 private String role;

    public String getEmail() {
        return email;
    }

    public String getConf_pass() {
        return conf_pass;
    }

    public void setConf_pass(String conf_pass) {
        this.conf_pass = conf_pass;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getId() {

        return id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name =name;
    }

    public void setEmail(String mail) {

        this.email=mail;
    }
    public String getMail(){

        return email;
    }


    public void setId(int userId) {
        this.id =userId ;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
