package com.techelevator.dao;

import com.techelevator.model.Appointment;


import java.util.List;

public interface AppointmentDao {



    List<Appointment> getAppointmentListsByDoctorId(int id);

    List<Appointment> getAppointmentLists();

    //Appointment getAppointmentById(int id);

    //Appointment createAppointment(Appointment appointment);

    //Appointment updateAppointment(Appointment appointment);


}
