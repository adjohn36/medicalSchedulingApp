package com.techelevator.dao;

import com.techelevator.model.Doctor;

public interface DoctorDao {
    public Doctor getDoctorByUserId(int userId);
}
