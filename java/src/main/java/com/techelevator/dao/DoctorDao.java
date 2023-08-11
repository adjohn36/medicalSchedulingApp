package com.techelevator.dao;

import com.techelevator.model.Doctor;
import com.techelevator.model.DoctorOfficeList;

import java.util.List;

public interface DoctorDao {
    Doctor getDoctorByUserId(int userId);

    Doctor getDoctorByDoctorId(int doctorId);

    List<Doctor> getDoctors();

    List<DoctorOfficeList> getDoctorsAndOfficeInfo();
}
