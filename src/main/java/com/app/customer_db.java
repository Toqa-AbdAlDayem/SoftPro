package com.app;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "customer")
public class customer_db {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String  Name;
//    private String email;
    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name=name;
    }

//    public void setEmail(String mail) {
//        email=mail;
//    }
//    public String getMail(){
//    return email;
//    }


}
