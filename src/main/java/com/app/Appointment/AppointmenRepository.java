package com.app.Appointment;


import org.springframework.data.jpa.repository.JpaRepository;



public interface AppointmenRepository extends JpaRepository<AppointmentDb, Long> {

}

