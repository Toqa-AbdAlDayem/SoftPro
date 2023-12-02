package com.app.Installation;
// Installation.java
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "INSTALLATION")
public class InstallationDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int customerId;
    private String carModel;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="INSTALLDATE")
    private Date installDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="OTHERDATE")
    private Date otherDate;

    private String AVAILABILITY;

    // Getters and setters
    private String CHECKED;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerName() {
        return customerId;
    }

    public void setCustomerName(int customerId) {
        this.customerId = customerId;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getInstallDate() {
        return installDate;
    }

    public void setInstallDate(Date installDate) {
        this.installDate = installDate;
    }

    public Date getOtherDate() {
        return otherDate;
    }

    public void setOtherDate(Date otherDate) {
        this.otherDate = otherDate;
    }

    public String getAVAILABILITY() {
        return AVAILABILITY;
    }

    public void setAVAILABILITY(String AVAILABILITY) {
        this.AVAILABILITY = AVAILABILITY;
    }

    public String getCHECKED() {
        return CHECKED;
    }

    public void setCHECKED(String CHECKED) {
        this.CHECKED = CHECKED;
    }
}

