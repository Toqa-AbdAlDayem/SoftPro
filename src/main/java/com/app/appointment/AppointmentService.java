package com.app.appointment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppointmentService {
    @Autowired
   private AppointmentDb appointmentDb;

    @Autowired
    private AppointmenRepository appointmenRepository;
    @Autowired
    public AppointmentService(AppointmenRepository appointmenRepository){
        this.appointmenRepository=appointmenRepository;
    }

    public boolean creatRequast(AppointmentForm appointmentForm, AppointmentDb appointmentDb) {
       appointmentDb.setService(appointmentForm.getService());
       appointmentDb.setHour(appointmentForm.getHour());
       appointmentDb.setDay(appointmentForm.getDay());
appointmentDb.setApp_id(223);

return true;
    }

    public String online() {

        return "Home";
    }
}
