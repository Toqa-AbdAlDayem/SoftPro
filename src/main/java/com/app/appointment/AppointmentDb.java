package com.app.appointment;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Appointment")
@Component
public class AppointmentDb {
    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "app_id")
    private int appId;
    private String service;
    private String isreceive;
    private String day;
    private String hour;
    public String getIsreceive() {
        return isreceive;
    }
    public void setIsreceive(String isreceive) {
        this.isreceive = isreceive;
    }
    public String getHour() {
        return hour;
    }
    public String getService() {
        return service;
    }
    public void setService(String service) {
        this.service = service;
    }
    public void setHour(String hour) {
        this.hour = hour;
    }
    public int getAppId() {
        return appId;
    }
    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }
    public void setAppId(int appId) {
        this.appId = appId;
    }
}

