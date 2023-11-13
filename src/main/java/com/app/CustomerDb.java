package com.app;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class CustomerDb {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CUST_ID")
    private int ID;
    private String  Name;
    private String email;

    public int getID() {

        return ID;
    }

    public String getName() {

        return Name;
    }

    public void setName(String name) {

        this.Name=name;
    }

    public void setEmail(String mail) {

        this.email=mail;
    }
    public String getMail(){

        return email;
    }


    public void setId(int userId) {
        this.ID=userId ;
    }
}
