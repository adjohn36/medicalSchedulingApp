package com.techelevator.dao;

import com.techelevator.model.Appointment;
import com.techelevator.model.AppointmentResponseModel;


import java.util.List;

public interface AppointmentDao {



    List<AppointmentResponseModel> getAppointmentListsByDoctorId(int id);
}
