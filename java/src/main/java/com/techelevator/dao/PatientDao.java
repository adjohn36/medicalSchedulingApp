package com.techelevator.dao;
import com.techelevator.model.Patient;

import java.util.List;

public interface PatientDao {






        List<Patient> getPatientListByPatientId(int patientId);

        List<Patient> getPatientLists();
}