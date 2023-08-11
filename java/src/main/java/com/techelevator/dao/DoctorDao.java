package com.techelevator.dao;

import com.techelevator.model.Doctor;

public interface DoctorDao {
    Doctor getDoctorByUserId(int userId);

    Doctor getDoctorByDoctorId(int doctorId);
}
