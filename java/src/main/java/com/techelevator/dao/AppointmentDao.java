package com.techelevator.dao;

import com.techelevator.model.AppointmentResponseDto;


import java.util.List;

public interface AppointmentDao {



    List<AppointmentResponseDto> getAppointmentListsByDoctorId(int id);
}
