package com.techelevator.controller;

import com.techelevator.dao.AppointmentDao;
import com.techelevator.model.Appointment;
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

    public AgendaController(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
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
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "List of appointments failed.");
        }
        return appointmentList;
    }

}
