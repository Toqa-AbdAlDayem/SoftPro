package com.app;

import org.springframework.boot.autoconfigure.domain.EntityScan;

//@Entity
public class customer_db {
    private int ID;
    private String  Name;

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }
}
