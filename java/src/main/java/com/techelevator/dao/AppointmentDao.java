package com.techelevator.dao;

import com.techelevator.model.AppointmentResponseDto;
import com.techelevator.model.BookAppointViewDto;
import com.techelevator.model.BookAppointViewDto;
import com.techelevator.model.Appointment;


import java.util.List;

public interface AppointmentDao {



    List<AppointmentResponseDto> getAppointmentListsByDoctorId(int doctorId);
    List<AppointmentResponseDto> getNextSevenDayAppointmentListsByDoctorId(int doctorId);
    List<BookAppointViewDto> getAvailableAppointmentLists();
    int postBookAnAppointment(Appointment anAppointment);
}
