package com.techelevator.controller;

import com.techelevator.dao.AppointmentDao;
import com.techelevator.dao.PatientDao;
import com.techelevator.model.AppointmentResponseModel;
import com.techelevator.model.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/agenda")
public class AgendaController {
    private final AppointmentDao appointmentDao;
    private final PatientDao patientDao;
    public AgendaController(AppointmentDao appointmentDao, PatientDao patientDao) {
        this.appointmentDao = appointmentDao;
        this.patientDao = patientDao;
    }
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/appointmentlistbydoctorid/{id}", method = RequestMethod.GET)
    public List<AppointmentResponseModel> listappointments(@PathVariable int id) {
        List<AppointmentResponseModel> appointmentList = new ArrayList<>();
        try {
            appointmentList = appointmentDao.getAppointmentListsByDoctorId(id);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Appointment List By Doctor Id failed.");
        }
        return appointmentList;
    }
    @RequestMapping(path = "/patientlist", method = RequestMethod.GET)
    public List<Patient> listpatients() {
        List<Patient> patientList = new ArrayList<>();
        try {
            patientList = patientDao.getPatientLists();

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Patient List failed.");
        }
        return patientList;
    }
    @RequestMapping(path = "/patientlistbyid/{id}", method = RequestMethod.GET)
    public List<Patient> listpatientsById(@PathVariable int id) {
        List<Patient> patientList = new ArrayList<>();
        try {
            patientList = patientDao.getPatientListByPatientId(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Patient List By Id failed.");
        }
        return patientList;
    }
}
