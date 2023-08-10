package com.techelevator.controller;

import com.techelevator.dao.AppointmentDao;
import com.techelevator.dao.PatientDao;
import com.techelevator.model.Appointment;
import com.techelevator.model.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    //@RequestMapping(path = "/appointmentlist/{id}", method = RequestMethod.GET)
    //public List<Appointment> listappointments(@PathVariable int id) {
    @RequestMapping(path = "/appointmentlist", method = RequestMethod.GET)
    public List<Appointment> listappointments() {
        List<Appointment> appointmentList = new ArrayList<>();
        try {
            appointmentList = appointmentDao.getAppointmentLists();

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "appointmentlist failed.");
        }
        return appointmentList;
    }
    @RequestMapping(path = "/patientlist", method = RequestMethod.GET)
    public List<Patient> listpatients() {
        List<Patient> patientList = new ArrayList<>();
        try {
            patientList = patientDao.getPatientLists();

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "patientList failed.");
        }
        return patientList;
    }

    @RequestMapping(path = "/patientlistbyid/{id}", method = RequestMethod.GET)
    public List<Patient> listpatientsById(@PathVariable int id) {
        List<Patient> patientList = new ArrayList<>();
        try {
            patientList = patientDao.getPatientListByPatientId(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "patientlistbyid failed.");
        }
        return patientList;
    }

}
