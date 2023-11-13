package com.app;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class CustomerDb {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CUST_ID")
    private int id;
    private String name;
    private String email;

    public int getId() {

        return id;
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
}
