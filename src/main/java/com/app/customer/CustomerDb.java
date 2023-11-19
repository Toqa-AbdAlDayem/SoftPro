package com.app.customer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@NoArgsConstructor
@Document(collection = "customer")
public class CustomerDb {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CUST_ID")
    private ObjectId id;
    private String name;
    private String email;
 private String pass;
    @Column(name="conf_pass")
 private String confPass;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="birthdate")
 private Date birthDate;
 private String gender;
 private String role;

    public String getEmail() {
        return email;
    }

    public String getConfPass() {
        return confPass;
    }

    public void setConfPass(String confPass) {
        this.confPass = confPass;
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

    public ObjectId getId() {

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


    public void setId(ObjectId userId) {
        this.id =userId ;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
