package com.techelevator.controller;

import com.techelevator.dao.AppointmentDao;
import com.techelevator.dao.PatientDao;
import com.techelevator.model.AppointmentResponseDto;
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
    @RequestMapping(path = "/appointmentlistbydoctorid/{doctorId}", method = RequestMethod.GET)
    public List<AppointmentResponseDto> listappointments(@PathVariable int doctorId) {
        List<AppointmentResponseDto> appointmentList = new ArrayList<>();
        try {
            appointmentList = appointmentDao.getAppointmentListsByDoctorId(doctorId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Appointment List By Doctor Id failed.");
        }
        return appointmentList;
    }
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/nextsevendayappointmentlistbydoctorid/{doctorId}", method = RequestMethod.GET)
    public List<AppointmentResponseDto> sevendayslistappointments(@PathVariable int doctorId) {
        List<AppointmentResponseDto> nextSevenDayAppointmentList = new ArrayList<>();
        try {
            nextSevenDayAppointmentList = appointmentDao.getNextSevenDayAppointmentListsByDoctorId(doctorId);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Next Seven Day Appointment List By Doctor Id failed.");
        }
        return nextSevenDayAppointmentList;
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
    @RequestMapping(path = "/patientlistbyid/{patienId}", method = RequestMethod.GET)
    public List<Patient> listpatientsById(@PathVariable int patienId) {
        List<Patient> patientList = new ArrayList<>();
        try {
            patientList = patientDao.getPatientListByPatientId(patienId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Patient List By Id failed.");
        }
        return patientList;
    }
}
